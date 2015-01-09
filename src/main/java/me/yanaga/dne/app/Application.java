package me.yanaga.dne.app;

import me.yanaga.dne.app.components.carga.CargaDados;
import me.yanaga.dne.config.root.DneConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static me.yanaga.dne.app.components.carga.EctPaisCarga.ectPais;
import static me.yanaga.dne.app.components.carga.LogBairroCarga.logBairro;
import static me.yanaga.dne.app.components.carga.LogCpcCarga.logCpc;
import static me.yanaga.dne.app.components.carga.LogFaixaBairroCarga.logFaixaBairro;
import static me.yanaga.dne.app.components.carga.LogFaixaCpcCarga.logFaixaCpc;
import static me.yanaga.dne.app.components.carga.LogFaixaLocalidadeCarga.logFaixaLocalidade;
import static me.yanaga.dne.app.components.carga.LogFaixaUfCarga.logFaixaUf;
import static me.yanaga.dne.app.components.carga.LogFaixaUopCarga.logFaixaUop;
import static me.yanaga.dne.app.components.carga.LogGrandeUsuarioCarga.logGrandeUsuario;
import static me.yanaga.dne.app.components.carga.LogLocalidadeCarga.logLocalidade;
import static me.yanaga.dne.app.components.carga.LogLogradouroCarga.logLogradouro;
import static me.yanaga.dne.app.components.carga.LogNumSecCarga.logNumSec;
import static me.yanaga.dne.app.components.carga.LogUnidOperCarga.logUnidOper;
import static me.yanaga.dne.app.components.carga.LogVarBaiCarga.logVarBai;
import static me.yanaga.dne.app.components.carga.LogVarLocCarga.logVarLoc;
import static me.yanaga.dne.app.components.carga.LogVarLogCarga.logVarLog;

public class Application {

	protected static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		logger.info("Iniciando DNE.");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setDefaultProfiles("default");
		context.register(DneConfig.class);
		context.refresh();

		CargaDados cargaDados = context.getBean(CargaDados.class);
		cargaDados.prepare(
				ectPais(), logBairro(), logCpc(), logFaixaBairro(),
				logFaixaCpc(), logFaixaLocalidade(), logFaixaUf(),
				logFaixaUop(), logGrandeUsuario(), logLocalidade(),
				logLogradouro(), logNumSec(), logUnidOper(), logVarBai(),
				logVarLoc(), logVarLog()
		).run();
	}

}
