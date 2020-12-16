package com.safarihotel.config;

import com.safarihotel.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableAutoConfiguration
public class SafariHotelSecurityConfigurer extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    private final UserDetailsService userDetailsService;

    private final String DEF_USERS_BY_USERNAME_QUERY =
            "select username, password, full_name, enabled " +
            "from Users " +
            "where username = ?";
    private final String DEF_AUTHORITIES_BY_USERNAME_QUERY =
            "select authority, username, true " +
            "from Authorities " +
            "where username = ?";

    @Autowired
    public SafariHotelSecurityConfigurer(DataSource dataSource, UserDetailsService userDetailsService) {
        this.dataSource = dataSource;
        this.userDetailsService = userDetailsService;
    }


    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(BCryptVersion.$2Y);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Method #1: in memory user store
        /*auth
            .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("toto")
                    .password("$2a$10$SiBGh.tPtHhPFNYI3S7gKOix1gr0lY54Thvk8OpRb/DsS57eU1y52")
                    .authorities("ROLE_USER")
                .and()
                .withUser("tata")
                    .password("$2a$10$ydXKzPFOmAHsqdN/BYvfHeqt91xlD6tl6UQGYsXQTZzoSNTGTHeD.")
                    .authorities("ROLE_USER");*/

        // Method #2: a jdbc user store
        /*auth
            .jdbcAuthentication()
            .dataSource(dataSource)
                .usersByUsernameQuery(DEF_USERS_BY_USERNAME_QUERY)
                .usersByUsernameQuery(DEF_AUTHORITIES_BY_USERNAME_QUERY)
            .passwordEncoder(encoder());*/
        // Method #3: custom user store
        auth
           .userDetailsService(userDetailsService)
           .passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
           .authorizeRequests()
                .antMatchers("/admin")
                    .authenticated()
                .antMatchers("/", "/**")
                    .permitAll()
           .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/admin")
           .and()
                .logout()
                    .logoutSuccessUrl("/");
    }
}
