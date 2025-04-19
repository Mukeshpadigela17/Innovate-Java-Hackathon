package configure;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/retry/**").hasAnyRole("ADMIN", "OPERATOR")
                .requestMatchers("/api/replay/**").hasRole("ADMIN")
                .anyRequest().authenticated())
            .httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager users() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin").password("admin123").roles("ADMIN").build();
        UserDetails operator = User.withDefaultPasswordEncoder()
                .username("op").password("op123").roles("OPERATOR").build();
        return new InMemoryUserDetailsManager();
    }
}
