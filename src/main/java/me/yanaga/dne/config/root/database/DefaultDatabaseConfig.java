package me.yanaga.dne.config.root.database;

import me.yanaga.dne.config.root.annotation.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Default
@Configuration
public class DefaultDatabaseConfig extends DatabaseConfigAbstract {

	@Autowired
	private Environment env;

	@Override
	protected String getUrl() {
		return env.getProperty("DATABASE_URL", String.format("jdbc:sqlite:%s/dne.db", System.getProperty("user.dir")));
	}
}
