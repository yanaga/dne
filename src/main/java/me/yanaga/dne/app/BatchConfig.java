package me.yanaga.dne.app;

import com.google.common.collect.ImmutableMap;
import me.yanaga.dne.app.importer.DneLineImporter;
import me.yanaga.dne.sqlite.QEctPais;
import me.yanaga.dne.sqlite.QLogBairro;
import me.yanaga.dne.sqlite.QLogCpc;
import me.yanaga.dne.sqlite.QLogFaixaBairro;
import me.yanaga.dne.sqlite.QLogFaixaCpc;
import me.yanaga.dne.sqlite.QLogFaixaLocalidade;
import me.yanaga.dne.sqlite.QLogFaixaUf;
import me.yanaga.dne.sqlite.QLogFaixaUop;
import me.yanaga.dne.sqlite.QLogGrandeUsuario;
import me.yanaga.dne.sqlite.QLogLocalidade;
import me.yanaga.dne.sqlite.QLogLogradouro;
import me.yanaga.dne.sqlite.QLogNumSec;
import me.yanaga.dne.sqlite.QLogUnidOper;
import me.yanaga.dne.sqlite.QLogVarBai;
import me.yanaga.dne.sqlite.QLogVarLoc;
import me.yanaga.dne.sqlite.QLogVarLog;
import me.yanaga.dne.sqlite.bean.EctPais;
import me.yanaga.dne.sqlite.bean.LogBairro;
import me.yanaga.dne.sqlite.bean.LogCpc;
import me.yanaga.dne.sqlite.bean.LogFaixaBairro;
import me.yanaga.dne.sqlite.bean.LogFaixaCpc;
import me.yanaga.dne.sqlite.bean.LogFaixaLocalidade;
import me.yanaga.dne.sqlite.bean.LogFaixaUf;
import me.yanaga.dne.sqlite.bean.LogFaixaUop;
import me.yanaga.dne.sqlite.bean.LogGrandeUsuario;
import me.yanaga.dne.sqlite.bean.LogLocalidade;
import me.yanaga.dne.sqlite.bean.LogLogradouro;
import me.yanaga.dne.sqlite.bean.LogNumSec;
import me.yanaga.dne.sqlite.bean.LogUnidOper;
import me.yanaga.dne.sqlite.bean.LogVarBai;
import me.yanaga.dne.sqlite.bean.LogVarLoc;
import me.yanaga.dne.sqlite.bean.LogVarLog;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class BatchConfig {

	@Bean
	public Map<String, DneLineImporter<?>> dneLineImporterMap() {
		ImmutableMap.Builder<String, DneLineImporter<?>> builder = ImmutableMap.builder();
		builder.put("ECT_PAIS.TXT", ectPaisDneLineImporter());
		builder.put("LOG_BAIRRO.TXT", logBairroDneLineImporter());
		builder.put("LOG_CPC.TXT", logCpcDneLineImporter());
		builder.put("LOG_FAIXA_BAIRRO.TXT", logFaixaBairroDneLineImporter());
		builder.put("LOG_FAIXA_CPC.TXT", logFaixaCpcDneLineImporter());
		builder.put("LOG_FAIXA_LOCALIDADE.TXT", logFaixaLocalidadeDneLineImporter());
		builder.put("LOG_FAIXA_UF.TXT", logFaixaUfDneLineImporter());
		builder.put("LOG_FAIXA_UOP.TXT", logFaixaUopDneLineImporter());
		builder.put("LOG_GRANDE_USUARIO.TXT", logGrandeUsuarioDneLineImporter());
		builder.put("LOG_LOCALIDADE.TXT", logLocalidadeDneLineImporter());
		builder.put("LOG_LOGRADOURO_\\p{Alpha}{2}.TXT", logLogradouroDneLineImporter());
		builder.put("LOG_NUM_SEC.TXT", logNumSecDneLineImporter());
		builder.put("LOG_UNID_OPER.TXT", logUnidOperDneLineImporter());
		builder.put("LOG_VAR_BAI.TXT", logVarBaiDneLineImporter());
		builder.put("LOG_VAR_LOC.TXT", logVarLocDneLineImporter());
		builder.put("LOG_VAR_LOG.TXT", logVarLogDneLineImporter());
		return builder.build();
	}

	@Bean
	public DneLineImporter<LogUnidOper> logUnidOperDneLineImporter() {
		return DneLineImporter.of(logUnidOperLineMapper(), QLogUnidOper.logUnidOper);
	}

	@Bean
	public LineMapper<LogUnidOper> logUnidOperLineMapper() {
		return createLineMapper(
				createLineTokenizer("UOP_NU", "UFE_SG", "LOC_NU", "BAI_NU", "LOG_NU", "UOP_NO", "UOP_ENDERECO", "CEP", "UOP_IN_CP", "UOP_NO_ABREV"),
				createFieldSetMapper(LogUnidOper.class));
	}

	@Bean
	public DneLineImporter<LogFaixaUf> logFaixaUfDneLineImporter() {
		return DneLineImporter.of(logFaixaUfLineMapper(), QLogFaixaUf.logFaixaUf);
	}

	@Bean
	public LineMapper<LogFaixaUf> logFaixaUfLineMapper() {
		return createLineMapper(
				createLineTokenizer("UFE_SG", "UFE_CEP_INI", "UFE_CEP_FIM"),
				createFieldSetMapper(LogFaixaUf.class));
	}

	@Bean
	public DneLineImporter<LogLocalidade> logLocalidadeDneLineImporter() {
		return DneLineImporter.of(logLocalidadeLineMapper(), QLogLocalidade.logLocalidade);
	}

	@Bean
	public LineMapper<LogLocalidade> logLocalidadeLineMapper() {
		return createLineMapper(
				createLineTokenizer("LOC_NU", "UFE_SG", "LOC_NO", "CEP", "LOC_IN_SIT", "LOC_IN_TIPO_LOC", "LOC_NU_SUB", "LOC_NO_ABREV", "MUN_NU"),
				createFieldSetMapper(LogLocalidade.class));
	}

	@Bean
	public DneLineImporter<LogVarLoc> logVarLocDneLineImporter() {
		return DneLineImporter.of(logVarLocLineMapper(), QLogVarLoc.logVarLoc);
	}

	@Bean
	public LineMapper<LogVarLoc> logVarLocLineMapper() {
		return createLineMapper(
				createLineTokenizer("LOC_NU", "VAL_NU", "VAL_TX"),
				createFieldSetMapper(LogVarLoc.class));
	}

	@Bean
	public DneLineImporter<LogFaixaLocalidade> logFaixaLocalidadeDneLineImporter() {
		return DneLineImporter.of(logFaixaLocalidadeLineMapper(), QLogFaixaLocalidade.logFaixaLocalidade);
	}

	@Bean
	public LineMapper<LogFaixaLocalidade> logFaixaLocalidadeLineMapper() {
		return createLineMapper(
				createLineTokenizer("LOC_NU", "LOC_CEP_INI", "LOC_CEP_FIM"),
				createFieldSetMapper(LogFaixaLocalidade.class));
	}

	@Bean
	public DneLineImporter<LogBairro> logBairroDneLineImporter() {
		return DneLineImporter.of(logBairroLineMapper(), QLogBairro.logBairro);
	}

	@Bean
	public LineMapper<LogBairro> logBairroLineMapper() {
		return createLineMapper(
				createLineTokenizer("BAI_NU", "UFE_SG", "LOC_NU", "BAI_NO", "BAI_NO_ABREV"),
				createFieldSetMapper(LogBairro.class));
	}

	@Bean
	public DneLineImporter<LogVarBai> logVarBaiDneLineImporter() {
		return DneLineImporter.of(logVarBaiLineMapper(), QLogVarBai.logVarBai);
	}

	@Bean
	public LineMapper<LogVarBai> logVarBaiLineMapper() {
		return createLineMapper(
				createLineTokenizer("BAI_NU", "VDB_NU", "VDB_TX"),
				createFieldSetMapper(LogVarBai.class));
	}

	@Bean
	public DneLineImporter<LogFaixaBairro> logFaixaBairroDneLineImporter() {
		return DneLineImporter.of(logFaixaBairroLineMapper(), QLogFaixaBairro.logFaixaBairro);
	}

	@Bean
	public LineMapper<LogFaixaBairro> logFaixaBairroLineMapper() {
		return createLineMapper(
				createLineTokenizer("BAI_NU", "FCB_CEP_INI", "FCB_CEP_FIM"),
				createFieldSetMapper(LogFaixaBairro.class));
	}

	@Bean
	public DneLineImporter<LogCpc> logCpcDneLineImporter() {
		return DneLineImporter.of(logCpcLineMapper(), QLogCpc.logCpc);
	}

	@Bean
	public LineMapper<LogCpc> logCpcLineMapper() {
		return createLineMapper(
				createLineTokenizer("CPC_NU", "UFE_SG", "LOC_NU", "CPC_NO", "CPC_ENDERECO", "CEP"),
				createFieldSetMapper(LogCpc.class));
	}

	@Bean
	public DneLineImporter<LogFaixaCpc> logFaixaCpcDneLineImporter() {
		return DneLineImporter.of(logFaixaCpcLineMapper(), QLogFaixaCpc.logFaixaCpc);
	}

	@Bean
	public LineMapper<LogFaixaCpc> logFaixaCpcLineMapper() {
		return createLineMapper(
				createLineTokenizer("CPC_NU", "CPC_INICIAL", "CPC_FINAL"),
				createFieldSetMapper(LogFaixaCpc.class));
	}

	@Bean
	public DneLineImporter<LogLogradouro> logLogradouroDneLineImporter() {
		return DneLineImporter.of(logLogradouroLineMapper(), QLogLogradouro.logLogradouro);
	}

	@Bean
	public LineMapper<LogLogradouro> logLogradouroLineMapper() {
		return createLineMapper(
				createLineTokenizer("LOG_NU", "UFE_SG", "LOC_NU", "BAI_NU_INI", "BAI_NU_FIM", "LOG_NO", "LOG_COMPLEMENTO",
						"CEP", "TLO_TX", "LOG_STA_TLO", "LOG_NO_ABREV"),
				createFieldSetMapper(LogLogradouro.class));
	}

	@Bean
	public DneLineImporter<LogVarLog> logVarLogDneLineImporter() {
		return DneLineImporter.of(logVarLogLineMapper(), QLogVarLog.logVarLog);
	}

	@Bean
	public LineMapper<LogVarLog> logVarLogLineMapper() {
		return createLineMapper(
				createLineTokenizer("LOG_NU", "VLO_NU", "TLO_TX", "VLO_TX"),
				createFieldSetMapper(LogVarLog.class));
	}

	@Bean
	public DneLineImporter<LogNumSec> logNumSecDneLineImporter() {
		return DneLineImporter.of(logNumSecLineMapper(), QLogNumSec.logNumSec);
	}

	@Bean
	public LineMapper<LogNumSec> logNumSecLineMapper() {
		return createLineMapper(
				createLineTokenizer("LOG_NU", "SEC_NU_INI", "SEC_NU_FIM", "SEC_IN_LADO"),
				createFieldSetMapper(LogNumSec.class));
	}

	@Bean
	public DneLineImporter<LogGrandeUsuario> logGrandeUsuarioDneLineImporter() {
		return DneLineImporter.of(logGrandeUsuarioLineMapper(), QLogGrandeUsuario.logGrandeUsuario);
	}

	@Bean
	public LineMapper<LogGrandeUsuario> logGrandeUsuarioLineMapper() {
		return createLineMapper(
				createLineTokenizer("GRU_NU", "UFE_SG", "LOC_NU", "BAI_NU", "LOG_NU", "GRU_NO", "GRU_ENDERECO", "CEP", "GRU_NO_ABREV"),
				createFieldSetMapper(LogGrandeUsuario.class));
	}

	@Bean
	public DneLineImporter<LogFaixaUop> logFaixaUopDneLineImporter() {
		return DneLineImporter.of(logFaixaUopLineMapper(), QLogFaixaUop.logFaixaUop);
	}

	@Bean
	public LineMapper<LogFaixaUop> logFaixaUopLineMapper() {
		return createLineMapper(
				createLineTokenizer("UOP_NU", "FNC_INICIAL", "FNC_FINAL"),
				createFieldSetMapper(LogFaixaUop.class));
	}

	@Bean
	public DneLineImporter<EctPais> ectPaisDneLineImporter() {
		return DneLineImporter.of(ectPaisLineMapper(), QEctPais.ectPais);
	}

	@Bean
	public LineMapper<EctPais> ectPaisLineMapper() {
		return createLineMapper(
				createLineTokenizer("PAI_SG", "PAI_SG_ALTERNATIVA", "PAI_NO_PORTUGUES", "PAI_NO_INGLES", "PAI_NO_FRANCES", "PAI_ABREVIATURA"),
				createFieldSetMapper(EctPais.class));
	}

	private <T> LineMapper<T> createLineMapper(LineTokenizer lineTokenizer, FieldSetMapper<T> fieldSetMapper) {
		DefaultLineMapper<T> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}

	private LineTokenizer createLineTokenizer(String... fields) {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(fields);
		return tokenizer;
	}

	private <T> FieldSetMapper createFieldSetMapper(Class<T> type) {
		BeanWrapperFieldSetMapper<T> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(type);
		return fieldSetMapper;
	}

}
