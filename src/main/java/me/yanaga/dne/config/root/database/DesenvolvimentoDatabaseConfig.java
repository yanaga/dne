package me.yanaga.dne.config.root.database;

import me.yanaga.dne.config.annotation.Desenvolvimento;
import org.springframework.context.annotation.Configuration;

@Desenvolvimento
@Configuration
public class DesenvolvimentoDatabaseConfig extends DatabaseConfigAbstract {

	protected String getUrl() {
		return String.format("jdbc:sqlite:%s/dne.db", System.getProperty("user.dir"));
	}

	protected String getUsername() {
		return "";
	}

	protected String getPassword() {
		return "";
	}
}