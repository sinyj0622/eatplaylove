package com.eatplaylove.security;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.eatplaylove.jwt.filter.JwtAuthenticationFilter;
import com.eatplaylove.jwt.provider.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

/**
 * SecurityConfig는 Spring Security 설정을 위한 클래스.
 * @author rimsong
 *
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * httpBasic().disable().csrf().disable(): rest api이므로 basic auth 및 csrf 보안을 사용하지 않는다는 설정
     *  sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS): JWT를 사용하기 때문에 세션을 사용하지 않는다는 설정
     *  antMatchers().permitAll(): 해당 API에 대해서는 모든 요청을 허가한다는 설정
     *  antMatchers().hasRole("USER"): USER 권한이 있어야 요청할 수 있다는 설정
     *  anyRequest().authenticated(): 이 밖에 모든 요청에 대해서 인증을 필요로 한다는 설정
     *  addFilterBefore(new JwtAUthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class): JWT 인증을 위하여 직접 구현한 필터를 UsernamePasswordAuthenticationFilter 전에 실행하겠다는 설정
     *  passwordEncoder: JWT를 사용하기 위해서는 기본적으로 password encoder가 필요한데, 여기서는 Bycrypt encoder를 사용
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors(Customizer.withDefaults())
                .csrf((csrfConfig) ->
                        csrfConfig.disable()
                )
                .headers((headerConfig) ->
                        headerConfig.frameOptions(frameOptionsConfig ->
                                frameOptionsConfig.disable()
                        )
                )
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
//                                .requestMatchers(PathRequest.toH2Console()).permitAll()
                                .requestMatchers("/", "/api/**").permitAll()
//                                .requestMatchers("/posts/**", "/api/v1/posts/**").hasRole(Role.USER.name())
//                                .requestMatchers("/admins/**", "/api/v1/admins/**").hasRole(Role.ADMIN.name())
                                .anyRequest().authenticated()
                )
//                .exceptionHandling((exceptionConfig) ->
//                        exceptionConfig.authenticationEntryPoint(unauthorizedEntryPoint).accessDeniedHandler(accessDeniedHandler)
//                )
//                .formLogin((formLogin) ->
//                        formLogin
//                                .loginPage("/login/login")
//                                .usernameParameter("username")
//                                .passwordParameter("password")
//                                .loginProcessingUrl("/login/login-proc")
//                                .defaultSuccessUrl("/", true)
//                )
                .logout((logoutConfig) ->
                        logoutConfig.logoutSuccessUrl("/")
                );
//                .userDetailsService(myUserDetailsService);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}