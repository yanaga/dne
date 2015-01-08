package me.yanaga.dne.config.root.database;

import me.yanaga.dne.config.root.annotation.Test;
import org.springframework.context.annotation.Configuration;

@Test
@Configuration
public class TestDatabaseConfig extends DatabaseConfigAbstract {

	@Override
	protected String getUrl() {
		return String.format("jdbc:sqlite:%s/dne.db", System.getProperty("user.dir"));
	}
}
