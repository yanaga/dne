package me.yanaga.dne.app;

import me.yanaga.dne.config.root.DneConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	protected static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		logger.info("Iniciando DNE.");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setDefaultProfiles("desenvolvimento");
		context.register(DneConfig.class);
		context.refresh();
	}

}
