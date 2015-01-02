package me.yanaga.dne.config.root.database;

import me.yanaga.dne.config.annotation.Producao;
import org.springframework.context.annotation.Configuration;

@Producao
@Configuration
public class ProducaoDatabaseConfig extends DatabaseConfigAbstract {

	protected String getUrl() {
		return "jdbc:mysql://localhost/dne";
	}

	@Override
	protected String getDriverClassName() {
		return "org.hibernate.dialect.MySQL5InnoDBDialect";
	}

	@Override
	protected String getPersistenceUnitName() {
		return "mysql";
	}

	protected String getUsername() {
		return "dne";
	}

	protected String getPassword() {
		return "dne";
	}
}