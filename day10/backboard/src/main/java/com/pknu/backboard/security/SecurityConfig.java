package com.pknu.backboard.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//  스프링시큐리티 핵심파일!!

@Configuration // 스프링의 환경설정 파일 !!
@EnableWebSecurity // 스프링시큐리티 제어 활성화
@EnableMethodSecurity(prePostEnabled = true) // 계정세션 없는 사용자 방지
public class SecurityConfig {

        @Bean
        SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                // http.authorizeRequests() > 더는 안 씀 !!

                // 인증되지 않은 모든 페이지 요청을 허락 !(로그인 창 안 뜸!)
                http.authorizeHttpRequests((ahr) -> ahr.requestMatchers("/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated())

                                // h2-console URL은 CSRF에 예외라고 설정!
                                .csrf((csrf) -> csrf.ignoringRequestMatchers("/h2-console/**"))

                                // h2-console이 Frame방식(구시대방식)으로 개발돼 필요한 설정 !!
                                .headers((hdr) -> hdr.addHeaderWriter(new XFrameOptionsHeaderWriter(
                                                XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))

                                // 로그인 URL 접근 지정! ; 로그인 페이지와 로그인 성공 후 페이지 지정 !!
                                .formLogin((fl) -> fl.loginPage("/member/signin")
                                                .defaultSuccessUrl("/"))

                                // 로그아웃 URL 지정 !!
                                .logout((lo) -> lo.logoutUrl("/member/signout")
                                                .logoutSuccessUrl("/")
                                                .invalidateHttpSession(true))

                ; // ;를 분리해놓으면 chain method를 추가할 때 간편함 !!!

                return http.build();
        }

        // 스프링시큐리티로 MemberSecuritySErvice와 패스워드 등을 내부적으로 사용, 인증 + 권한 부여 프로세스 처리
        @Bean
        AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
                        throws Exception {
                // AuthenticationManager를 빈으로 등록해놓으면, 스프링 시큐리티가 알아서 사용함!
                return authenticationConfiguration.getAuthenticationManager();
        }

        // 회원가입, 로그인 시 동일하게 사용! (로그인 시 스프링 시큐리티가 자동으로 사)
        @Bean
        PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder(); // 회원가입 패스워드 암호화시 사용한 엔코더와 동일!!
        }

}
