//package tcd.ie.houseplatform.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import tcd.ie.houseplatform.Service.ConsumerUserService;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests(
//                authorize -> authorize.requestMatchers("/signin", "signup").permitAll()
//                        .requestMatchers("/users/**", "/apps/**").hasAuthority("ADMIN")
//                        .requestMatchers("/myapps/**").hasAuthority("CLIENT")
//                        .anyRequest().authenticated())
//                .formLogin(login->login.loginPage("/signin")
//                        .usernameParameter("email")
//                        .defaultSuccessUrl("/", true)
//                        .permitAll())
//                .logout(logout -> logout.logoutUrl("/signout").permitAll())
//                .rememberMe(remember -> remember.key("remember_code"));
//
//
//        return http.build();
//    }
//
//
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        return new ConsumerUserService();
//    }
//
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Bean
////    public DaoAuthenticationConfigurer authenticationConfigurer(){
////        DaoAuthenticationConfigurer authenticationConfigurer = new DaoAuthenticationConfigurer();
////        authenticationConfigurer.setUserDetailsService(userDetailsService());
////    }
//}
