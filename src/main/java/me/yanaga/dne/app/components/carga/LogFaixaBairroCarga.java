package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogFaixaBairro;
import me.yanaga.dne.app.bean.LogFaixaBairroPK;
import me.yanaga.dne.app.bean.LogFaixaBairroRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogFaixaBairroCarga extends CargaAbstract<LogFaixaBairro, LogFaixaBairroPK> {

	private LineMapper<LogFaixaBairro> logFaixaBairroLineMapper;

	private LogFaixaBairroRepository logFaixaBairroRepository;

	private LogFaixaBairroCarga() {
		super(LogFaixaBairro.class);
	}

	public static LogFaixaBairroCarga logFaixaBairro() {
		return new LogFaixaBairroCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "LOG_FAIXA_BAIRRO.TXT" };
	}

	@Override
	protected void configLineMapper() {
		logFaixaBairroLineMapper = getBeanMapper().logFaixaBairroLineMapper();
	}

	@Override
	public LineMapper<LogFaixaBairro> lineMapper() {
		return checkNotNull(logFaixaBairroLineMapper);
	}

	@Override
	protected void configRepository() {
		logFaixaBairroRepository = getBean(LogFaixaBairroRepository.class);
	}

	@Override
	public JpaRepository<LogFaixaBairro, LogFaixaBairroPK> repository() {
		return checkNotNull(logFaixaBairroRepository);
	}
}
