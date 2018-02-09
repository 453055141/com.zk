package com.zk.zkbootweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity  //启用web安全性
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER","ADMIN");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //拦截
        http
                .authorizeRequests()    //http.authorizeRequests()方法有多个子节点，每个macher按照他们的声明顺序执行。
                .antMatchers("/resources/**", "/signup", "/about").permitAll()  //任何用户都可以访问URL以"/resources/", equals "/signup", 或者 "/about"开头的URL
                .antMatchers("/admin/**").hasRole("ADMIN")  //以 "/admin/" 开头的URL只能由拥有 "ROLE_ADMIN"角色的用户访问。请注意我们使用 hasRole 方法，没有使用 "ROLE_" 前缀
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//                .anyRequest().authenticated()   //尚未匹配的任何URL要求用户进行身份验证  //anyRequest().permitAll(),所有请求不用认证
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")    //指定登录页的路径
                .permitAll()       //允许所有用户访问我们的登录页（例如为验证的用户），这个formLogin().permitAll()方法允许基于表单登录的所有的URL的所有用户的访问
                .and()
                .logout()   //提供注销支持，使用WebSecurityConfigurerAdapter会自动被应用
                .logoutUrl("/my/logout")    //	设置触发注销操作的URL (默认是/logout). 如果CSRF内启用（默认是启用的）的话这个请求的方式被限定为POST
                .logoutSuccessUrl("/my/index")  //	注销之后跳转的URL。默认是/login?logout
//                .logoutSuccessHandler(logoutSuccessHandler) //让你设置定制的 LogoutSuccessHandler。如果指定了这个选项那么logoutSuccessUrl()的设置会被忽略
                .invalidateHttpSession(true);    //指定是否在注销时让HttpSession无效。 默认设置为 true
//                .addLogoutHandler(logoutHandler)    //添加一个LogoutHandler.默认SecurityContextLogoutHandler会被添加为最后一个LogoutHandler
//                .deleteCookies(cookieNamesToClear); //	允许指定在注销成功时将移除的cookie。这是一个现实的添加一个CookieClearingLogoutHandler的快捷方式
    }

}
