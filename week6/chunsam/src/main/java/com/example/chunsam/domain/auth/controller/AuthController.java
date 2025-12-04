package com.example.chunsam.domain.auth.controller;

import com.example.chunsam.domain.auth.dto.req.LoginReq;
import com.example.chunsam.domain.auth.dto.req.SignupReq;
import com.example.chunsam.domain.auth.dto.res.LoginRes;
import com.example.chunsam.domain.auth.dto.res.LogoutRes;
import com.example.chunsam.domain.auth.dto.res.SignupRes;
import com.example.chunsam.domain.auth.exception.AuthException;
import com.example.chunsam.domain.auth.exception.code.AuthErrorCode;
import com.example.chunsam.domain.auth.service.CustomUserDetails;
import com.example.chunsam.domain.auth.service.command.AuthService;
import com.example.chunsam.global.apiPayload.ApiResponse;
import com.example.chunsam.global.apiPayload.code.GeneralSuccessCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager; // ✅ 추가

    @PostMapping("/signup")
    public ApiResponse<SignupRes> signup(@Valid @RequestBody SignupReq request) {
        SignupRes signupRes = authService.signup(request);
        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS, signupRes);

    }

    @PostMapping("/login")
    public ApiResponse<LoginRes> login(
            @Valid @RequestBody LoginReq request,
            HttpServletRequest httpRequest
    ) {

        try {
            // 1) 인증 토큰 생성
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    );

            // 2) AuthenticationManager 를 통해 인증 수행
            Authentication authentication = authenticationManager.authenticate(authToken);


            // 3) SecurityContext 에 Authentication 저장
            SecurityContext context = SecurityContextHolder.createEmptyContext();
            context.setAuthentication(authentication);
            SecurityContextHolder.setContext(context);

            // 4) HTTP 세션에도 SecurityContext 저장 (세션 방식 유지)
            HttpSession session = httpRequest.getSession(true);
            session.setAttribute(
                    HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    context
            );

            // 5) 응답용 DTO 구성
            CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();

            LoginRes loginRes = new LoginRes(
                    true,
                    principal.getId(),
                    principal.getUsername(),
                    principal.getName()  // 필요하면 Member.name을 UserDetails에 넣어서 사용
            );

            return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS, loginRes);

        } catch (BadCredentialsException e) {
            // 아이디 또는 비밀번호가 틀린 경우
            // 네가 쓰는 에러 코드를 써도 되고, 공통 에러로 래핑해도 됨
            throw new AuthException(AuthErrorCode.Wrong_Passwd_ID);
        }
    }

    /**
     * 로그아웃 (세션 무효화)
     */
    @PostMapping("/logout")
    public ApiResponse<LogoutRes> logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        SecurityContextHolder.clearContext();

        return ApiResponse.onSuccess(
                GeneralSuccessCode.SUCCESS,
                new LogoutRes(true)
        );
    }




}
