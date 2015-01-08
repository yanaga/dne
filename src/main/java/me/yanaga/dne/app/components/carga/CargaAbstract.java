package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.config.root.BatchConfig;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class CargaAbstract<T, ID extends Serializable> {

	public static final int PAGE = 1000;

	private Class<T> beanClass;

	private ApplicationContext context;

	public CargaAbstract(Class<T> beanClass) {
		this.beanClass = beanClass;
	}

	public void config(ApplicationContext context) {
		this.context = context;
		configLineMapper();
		configRepository();
	}

	protected BatchConfig getBeanMapper() {
		return getBean(BatchConfig.class);
	}

	protected <B> B getBean(Class<B> aClass) {
		return checkNotNull(context).getBean(aClass);
	}

	public String getName() {
		return beanClass.getSimpleName();
	}

	public abstract String[] getArquivos();

	protected abstract void configLineMapper();

	public abstract LineMapper<T> lineMapper();

	protected abstract void configRepository();

	public abstract JpaRepository<T, ID> repository();
}