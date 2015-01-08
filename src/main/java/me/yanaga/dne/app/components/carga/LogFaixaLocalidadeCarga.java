package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogFaixaLocalidade;
import me.yanaga.dne.app.bean.LogFaixaLocalidadePK;
import me.yanaga.dne.app.bean.LogFaixaLocalidadeRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogFaixaLocalidadeCarga extends CargaAbstract<LogFaixaLocalidade, LogFaixaLocalidadePK> {

	private LineMapper<LogFaixaLocalidade> logFaixaLocalidadeLineMapper;

	private LogFaixaLocalidadeRepository logFaixaLocalidadeRepository;

	private LogFaixaLocalidadeCarga() {
		super(LogFaixaLocalidade.class);
	}

	public static LogFaixaLocalidadeCarga logFaixaLocalidade() {
		return new LogFaixaLocalidadeCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "LOG_FAIXA_LOCALIDADE.TXT" };
	}

	@Override
	protected void configLineMapper() {
		logFaixaLocalidadeLineMapper = getBeanMapper().logFaixaLocalidadeLineMapper();
	}

	@Override
	public LineMapper<LogFaixaLocalidade> lineMapper() {
		return checkNotNull(logFaixaLocalidadeLineMapper);
	}

	@Override
	protected void configRepository() {
		logFaixaLocalidadeRepository = getBean(LogFaixaLocalidadeRepository.class);
	}

	@Override
	public JpaRepository<LogFaixaLocalidade, LogFaixaLocalidadePK> repository() {
		return checkNotNull(logFaixaLocalidadeRepository);
	}
}
