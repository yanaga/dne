package me.yanaga.dne.config.root;

import me.yanaga.dne.app.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackageClasses = { Application.class })
@Import({ BatchConfig.class, JpaConfig.class })
@Configuration
public class DneConfig {

}
