package me.yanaga.dne.app.components.carga;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Component
public class CargaDados {

	protected static final Logger logger = LoggerFactory.getLogger(CargaDados.class);

	@Autowired
	private ApplicationContext context;

	private List<CargaAbstract> cargasConfigured = Lists.newLinkedList();

	public CargaDadosPrepared prepare(CargaAbstract... cargas) {
		logger.info("Preparando a carga de dados.");
		checkNotNull(cargas);
		checkArgument(cargas.length > 0);
		for (CargaAbstract carga: cargas) {
			carga.config(context);
			cargasConfigured.add(carga);
		}
		return new CargaDadosPrepared(this);
	}

	public ApplicationContext getContext() {
		return context;
	}

	public ImmutableList<CargaAbstract> getCargasConfigured() {
		return ImmutableList.copyOf(cargasConfigured);
	}

}
