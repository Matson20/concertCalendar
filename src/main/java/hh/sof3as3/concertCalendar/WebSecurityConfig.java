package hh.sof3as3.concertCalendar;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import hh.sof3as3.concertCalendar.service.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    @Autowired
    private UserDetailServiceImpl userDetailsService;
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
                .requestMatchers("/","/eventlist","/css/**").permitAll()
                .requestMatchers(toH2Console()).permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/eventlist", true).permitAll()
                .and()
                .csrf().ignoringRequestMatchers(toH2Console())
                //.csrf(csrf -> csrf
                //.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")))
                .and()
            .logout()
                .logoutSuccessUrl("/eventlist")
                .permitAll()
                .and()
                .httpBasic();
            return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    /* InMemory Users
    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> users = new ArrayList<>();
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("user")
            .roles("USER")
            .build();
            
            users.add(user);

            user = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .roles("ADMIN")
            .build();

            users.add(user);

        return new InMemoryUserDetailsManager(users);

    }
    */
    
}
