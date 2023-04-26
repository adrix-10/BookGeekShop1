package com.project.BookGeekShop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder().
                username("admin").
                password("{noop}admin1234").
                roles("USER", "OPERADOR", "ADMIN").
                build();
        UserDetails vendedor = User.builder().
                username("operador").
                password("{noop}operador1234").
                roles("USER", "VENDEDOR").
                build();
        UserDetails usuario = User.builder().
                username("usuario").
                password("{noop}usuario1234").
                roles("USER").build();
        return new InMemoryUserDetailsManager(usuario, vendedor, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/",
                        "/index",
                        "/catalogo/**",
                        "/perfil",
                        "/contacto/**",
                        "/errores/**",
                        "/sobreNosotros/**",
                        "/css/**",
                        "/carrito/**",
                        "/carrito/comprar/**",
                        "/img/**",
                        "/webjars/**").permitAll()
                .requestMatchers(
                        "/cliente/nuevo",
                        "/cliente/guardar",
                        "/cliente/modificar/**",
                        "/cliente/eliminar/**",
                        "/empleado/nuevo",
                        "/empleado/guardar",
                        "/empleado/modificar/**",
                        "/empleado/eliminar/**",
                        "/novelaGrafica/nuevo",
                        "/novelaGrafica/guardar",
                        "/novelaGrafica/modificar/**",
                        "/novelaGrafica/eliminar/**",
                        "/libro/nuevo",
                        "/libro/guardar",
                        "/libro/modificar/**",
                        "/libro/eliminar/**",
                        "/ventaLibro/nuevo",
                        "/ventaLibro/guardar",
                        "/ventaLibro/modificar/**",
                        "/ventaLibro/eliminar/**",
                        "/ventaNovelaGrafica/nuevo",
                        "/ventaNovelaGrafica/guardar",
                        "/ventaNovelaGrafica/modificar/**",
                        "/ventaNovelaGrafica/eliminar/**"
                ).hasRole("ADMIN")
                .requestMatchers(
                        "/cliente/listado_cliente",
                        "/empleado/listado_empleado",
                        "/novelaGrafica/listado_novelaGrafica",
                        "/libro/listado_libro",
                        "/ventaLibro/listado_ventaLibro",
                        "/ventaNovelaGrafica/listado_ventaNovelaGrafica"
                ).hasAnyRole("ADMIN", "VENDEDOR"))
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll())
                .exceptionHandling()
                .accessDeniedPage("/errores/403");
        return http.build();
    }

}
