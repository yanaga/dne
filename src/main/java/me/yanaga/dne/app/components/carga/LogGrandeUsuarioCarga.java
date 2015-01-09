package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogGrandeUsuario;
import me.yanaga.dne.app.bean.LogGrandeUsuarioRepository;

public class LogGrandeUsuarioCarga extends CargaAbstract<LogGrandeUsuario, Integer> {

	private LogGrandeUsuarioCarga() {
		super(LogGrandeUsuario.class);
	}

	public static LogGrandeUsuarioCarga logGrandeUsuario() {
		return new LogGrandeUsuarioCarga();
	}

	@Override
	protected String[] getArquivos() {
		return new String[] { "LOG_GRANDE_USUARIO.TXT" };
	}

	@Override
	protected void configLineMapper() {
		lineMapper = getBeanMapper().logGrandeUsuarioLineMapper();
	}

	@Override
	protected void configRepository() {
		repository = getBean(LogGrandeUsuarioRepository.class);
	}
}
