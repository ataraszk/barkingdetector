package ataraszkiewicz.config;

import ataraszkiewicz.controller.NoiseController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author ataraszkiewicz
 * @since 2015-08-31
 */
@EnableWebMvc
@ComponentScan(basePackageClasses = NoiseController.class)
@Configuration
public class WebMvcConfig {
}
