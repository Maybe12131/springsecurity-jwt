package com.cc.security.config.security;

import com.cc.security.config.security.filter.JWTAuthenticationTokenFilter;
import com.cc.security.config.security.handle.RestfulAccessDeniedHandler;
import com.cc.security.config.security.handle.RestfulAuthenticationEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author CaiCang
 * @Date 2020/9/1 14:54
 * @Version 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    private final RestfulAuthenticationEntryPoint restfulAuthenticationEntryPoint;
    private final JWTAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    public SecurityConfig(RestfulAccessDeniedHandler restfulAccessDeniedHandler, RestfulAuthenticationEntryPoint restfulAuthenticationEntryPoint, JWTAuthenticationTokenFilter jwtAuthenticationTokenFilter) {
        this.restfulAccessDeniedHandler = restfulAccessDeniedHandler;
        this.restfulAuthenticationEntryPoint = restfulAuthenticationEntryPoint;
        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //不使用防跨站攻击
        http.csrf().disable()
                //不使用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //允许静态资源无授权访问
                .antMatchers(HttpMethod.GET, "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/login").permitAll()
                .and()
                //根据权限授权 authorities.add("post"); 对应/post接口
                .authorizeRequests().antMatchers("/api").hasAuthority("api")
                .and()
                //根据角色授权  authorities.add("ROLE_USER");
                .authorizeRequests().antMatchers("/test/get").hasRole("USER")
                .and()
                //配置跨域的option请求，跨域请求之前都会进行一次option请求
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
                .and()
                //其他没有配置的请求都需要身份认证
                .authorizeRequests().anyRequest().authenticated();
        //http的cache控制，如下这句代码会禁用cache
        http.headers().cacheControl();
        //添加JWT身份认证的filter
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权的处理器
        http.exceptionHandling().accessDeniedHandler(restfulAccessDeniedHandler);
        //添加自定义未登录的处理器
        http.exceptionHandling().authenticationEntryPoint(restfulAuthenticationEntryPoint);
    }
}
