package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogBairro;
import me.yanaga.dne.app.bean.LogBairroRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogBairroCarga extends CargaAbstract<LogBairro, Integer> {

	private LineMapper<LogBairro> logBairroLineMapper;

	private LogBairroRepository logBairroRepository;

	private LogBairroCarga() {
		super(LogBairro.class);
	}

	public static LogBairroCarga logBairro() {
		return new LogBairroCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "LOG_BAIRRO.TXT" };
	}

	@Override
	protected void configLineMapper() {
		logBairroLineMapper = getBeanMapper().logBairroLineMapper();
	}

	@Override
	public LineMapper<LogBairro> lineMapper() {
		return checkNotNull(logBairroLineMapper);
	}

	@Override
	protected void configRepository() {
		logBairroRepository = getBean(LogBairroRepository.class);
	}

	@Override
	public JpaRepository<LogBairro, Integer> repository() {
		return checkNotNull(logBairroRepository);
	}
}
