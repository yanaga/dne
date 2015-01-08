package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogGrandeUsuario;
import me.yanaga.dne.app.bean.LogGrandeUsuarioRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogGrandeUsuarioCarga extends CargaAbstract<LogGrandeUsuario, Integer> {

	private LineMapper<LogGrandeUsuario> logGrandeUsuarioLineMapper;

	private LogGrandeUsuarioRepository logGrandeUsuarioRepository;

	private LogGrandeUsuarioCarga() {
		super(LogGrandeUsuario.class);
	}

	public static LogGrandeUsuarioCarga logGrandeUsuario() {
		return new LogGrandeUsuarioCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "LOG_GRANDE_USUARIO.TXT" };
	}

	@Override
	protected void configLineMapper() {
		logGrandeUsuarioLineMapper = getBeanMapper().logGrandeUsuarioLineMapper();
	}

	@Override
	public LineMapper<LogGrandeUsuario> lineMapper() {
		return checkNotNull(logGrandeUsuarioLineMapper);
	}

	@Override
	protected void configRepository() {
		logGrandeUsuarioRepository = getBean(LogGrandeUsuarioRepository.class);
	}

	@Override
	public JpaRepository<LogGrandeUsuario, Integer> repository() {
		return checkNotNull(logGrandeUsuarioRepository);
	}
}
