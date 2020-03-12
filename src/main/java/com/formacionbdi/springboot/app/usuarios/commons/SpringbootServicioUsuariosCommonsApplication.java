package com.formacionbdi.springboot.app.usuarios.commons;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * La etiqueta @EnableAutoConfiguration excluye la autoconfiguracion de Spring
 * Data JPA. Para que no pida una conexión al arrancar el microservicio, ya que
 * al ser un commons y utiliza etiquetas de JPA y es consumido por un servicio
 * para hacer uso de sus clases commons.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class SpringbootServicioUsuariosCommonsApplication {

}
