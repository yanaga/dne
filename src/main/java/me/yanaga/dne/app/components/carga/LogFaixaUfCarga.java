package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogFaixaUf;
import me.yanaga.dne.app.bean.LogFaixaUfPK;
import me.yanaga.dne.app.bean.LogFaixaUfRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogFaixaUfCarga extends CargaAbstract<LogFaixaUf, LogFaixaUfPK> {

	private LogFaixaUfRepository logFaixaUfRepository;

	private LineMapper<LogFaixaUf> logFaixaUfLineMapper;

	private LogFaixaUfCarga() {
		super(LogFaixaUf.class);
	}

	public static LogFaixaUfCarga logFaixaUf() {
		return new LogFaixaUfCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "LOG_FAIXA_UF.TXT" };
	}

	@Override
	protected void configLineMapper() {
		logFaixaUfLineMapper = getBeanMapper().logFaixaUfLineMapper();
	}

	@Override
	public LineMapper<LogFaixaUf> lineMapper() {
		return checkNotNull(logFaixaUfLineMapper);
	}

	@Override
	protected void configRepository() {
		logFaixaUfRepository = getBean(LogFaixaUfRepository.class);
	}

	@Override
	public JpaRepository<LogFaixaUf, LogFaixaUfPK> repository() {
		return checkNotNull(logFaixaUfRepository);
	}
}
