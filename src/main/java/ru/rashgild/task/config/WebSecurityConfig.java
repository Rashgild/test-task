package ru.rashgild.task.config;

//import com.coder.psa.util.CsrfHeaderFilter;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;*/

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {//extends WebSecurityConfigurerAdapter {

   /* @Autowired
    DataSource dataSource;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/favicon.ico").permitAll()
            .antMatchers("/token").permitAll()
            //.antMatchers("/signature/**").permitAll()
            .antMatchers("/signature").permitAll()
            .antMatchers("/task").permitAll()
            .antMatchers("/draft").access("hasRole('ROLE_USER')")
            .antMatchers("/cancel-draft").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/theme.css").permitAll()
            .antMatchers("/user/me").permitAll()
            .antMatchers("/user/changepassword").permitAll()
            .antMatchers("/user/**").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/department/list").permitAll()
            .antMatchers("/department/**").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/metal/list").permitAll()
            .antMatchers("/metal/list-by-type").permitAll()
            .antMatchers("/metal/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER') " +
            "or hasRole('ROLE_ACCOUNTANT')")
            .antMatchers("/passport/delete")
            .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ACCOUNTANT')")
            .antMatchers("/company/save").permitAll()
            .antMatchers("/company/delete")
            .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ACCOUNTANT')")
            .antMatchers("/psa/delete")
            .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ACCOUNTANT')")
            .antMatchers("/payment/**")
            .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_PAYMENT')")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            //.successHandler(savedRequestAwareAuthenticationSuccessHandler())
            .loginPage("/login")
            .defaultSuccessUrl("/index.html", true)
            .permitAll()
            .and().logout().permitAll()
            .and().addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
            .csrf().csrfTokenRepository(csrfTokenRepository());
        //.and().rememberMe()
        // .tokenRepository(persistentTokenRepository()).tokenValiditySeconds(1209600);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/signature/**")
            .antMatchers("/task/**")
            .antMatchers("/draft-by-department/**")
            .antMatchers("/draft-result/**")
            .antMatchers("/payment/save-read");
    }

    *//**
     * PersistentTokenRepository bean.
     *
     * @return PersistentTokenRepository
     *//*
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }

    *//**
     * SavedRequestAwareAuthenticationSuccessHandler bean.
     *
     * @return SavedRequestAwareAuthenticationSuccessHandler
     *//*
    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler
    savedRequestAwareAuthenticationSuccessHandler() {

        SavedRequestAwareAuthenticationSuccessHandler auth
            = new SavedRequestAwareAuthenticationSuccessHandler();
        auth.setTargetUrlParameter("/");
        return auth;
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }

    *//**
     * Configure global.
     *
     * @param auth AuthenticationManagerBuilder
     * @throws Exception ...
     *//*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        *//*auth
            .inMemoryAuthentication()
            .withUser("user").password("password").roles("USER");*//*
        auth.jdbcAuthentication().dataSource(dataSource)
            .passwordEncoder(passwordEncoder)
            .usersByUsernameQuery("select username,password, enabled from users where username=?")
            //.authoritiesByUsernameQuery("SELECT username, role FROM users where username=?");
            .authoritiesByUsernameQuery("SELECT u.username, r.role FROM users u " +
                "JOIN user_roles ur ON u.id=ur.user_id JOIN roles r ON ur.role_id=r.id where username=?");
    }*/
}
