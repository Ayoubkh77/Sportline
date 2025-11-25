package org.ldv.sporline.service

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration

@Configuration
@EnableMethodSecurity
class SecurityConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }

            // ================= Autorisations =================
            .authorizeHttpRequests {
                it
                    .requestMatchers(
                        "/Sportline",
                        "/Sportline/register",
                        "/Sportline/login",
                        "/css/**",
                        "/js/**",
                        "/img/**",
                        "/favicon.ico"
                    ).permitAll()

                    .requestMatchers("/Sportline/admin/**").hasRole("ADMIN")
                    .requestMatchers("/Sportline/client/**").hasRole("USER")

                    .anyRequest().authenticated()
            }

            // ================= Login =================
            .formLogin { form: FormLoginConfigurer<HttpSecurity?> ->
                form
                    .loginPage("/Sportline/login")          // page affichant le formulaire
                    .loginProcessingUrl("/Sportline/login") // POST traité par Spring Security
                    .defaultSuccessUrl("/Sportline/profile", true) // redirection après succès
                    .failureUrl("/Sportline/login?error=true")     // redirection après échec
                    .permitAll()
            }

            // ================= Logout =================
            .logout { logout: LogoutConfigurer<HttpSecurity?> ->
                logout
                    .logoutUrl("/Sportline/logout")

                    .permitAll()
            }

            // ================= Gestion des erreurs =================
            .exceptionHandling { exceptions ->
                exceptions
                    .accessDeniedPage("/Sportline/login?denied=true") // page en cas de 403
            }

        return http.build()
    }

    @Bean
    fun authenticationManager(config: AuthenticationConfiguration): AuthenticationManager {
        return config.authenticationManager
    }
}
