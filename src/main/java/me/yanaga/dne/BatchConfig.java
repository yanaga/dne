package me.yanaga.dne;

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

@Configuration
public class BatchConfig {

	@Bean
	public LineMapper<LogUnidOper> logUnidOperLineMapper() {
		return createLineMapper(
				createLineTokenizer("UOP_NU", "UFE_SG", "LOC_NU", "BAI_NU", "LOG_NU", "UOP_NO", "UOP_ENDERECO", "CEP", "UOP_IN_CP", "UOP_NO_ABREV"),
				createFieldSetMapper(LogUnidOper.class));
	}

	@Bean
	public LineMapper<LogFaixaUf> logFaixaUfLineMapper() {
		return createLineMapper(
				createLineTokenizer("UFE_SG", "UFE_CEP_INI", "UFE_CEP_FIM"),
				createFieldSetMapper(LogFaixaUf.class));
	}

	@Bean
	public LineMapper<LogLocalidade> logLocalidadeLineMapper() {
		return createLineMapper(
				createLineTokenizer("LOC_NU", "UFE_SG", "LOC_NO", "CEP", "LOC_IN_SIT", "LOC_IN_TIPO_LOC", "LOC_NU_SUB", "LOC_NO_ABREV", "MUN_NU"),
				createFieldSetMapper(LogLocalidade.class));
	}

	@Bean
	public LineMapper<LogVarLoc> logVarLocLineMapper() {
		return createLineMapper(
				createLineTokenizer("LOC_NU", "VAL_NU", "VAL_TX"),
				createFieldSetMapper(LogVarLoc.class));
	}

	@Bean
	public LineMapper<LogFaixaLocalidade> logFaixaLocalidadeLineMapper() {
		return createLineMapper(
				createLineTokenizer("LOC_NU", "LOC_CEP_INI", "LOC_CEP_FIM"),
				createFieldSetMapper(LogFaixaLocalidade.class));
	}

	@Bean
	public LineMapper<LogBairro> logBairroLineMapper() {
		return createLineMapper(
				createLineTokenizer("BAI_NU", "UFE_SG", "LOC_NU", "BAI_NO", "BAI_NO_ABREV"),
				createFieldSetMapper(LogBairro.class));
	}

	@Bean
	public LineMapper<LogVarBai> logVarBaiLineMapper() {
		return createLineMapper(
				createLineTokenizer("BAI_NU", "VDB_NU", "VDB_TX"),
				createFieldSetMapper(LogVarBai.class));
	}

	@Bean
	public LineMapper<LogFaixaBairro> logFaixaBairroLineMapper() {
		return createLineMapper(
				createLineTokenizer("BAI_NU", "FCB_CEP_INI", "FCB_CEP_FIM"),
				createFieldSetMapper(LogFaixaBairro.class));
	}

	@Bean
	public LineMapper<LogCpc> logCpcLineMapper() {
		return createLineMapper(
				createLineTokenizer("CPC_NU", "UFE_SG", "LOC_NU", "CPC_NO", "CPC_ENDERECO", "CEP"),
				createFieldSetMapper(LogCpc.class));
	}

	@Bean
	public LineMapper<LogFaixaCpc> logFaixaCpcLineMapper() {
		return createLineMapper(
				createLineTokenizer("CPC_NU", "CPC_INICIAL", "CPC_FINAL"),
				createFieldSetMapper(LogFaixaCpc.class));
	}

	@Bean
	public LineMapper<LogLogradouro> logLogradouroLineMapper() {
		return createLineMapper(
				createLineTokenizer("LOG_NU", "UFE_SG", "LOC_NU", "BAI_NU_INI", "BAI_NU_FIM", "LOG_NO", "LOG_COMPLEMENTO",
						"CEP", "TLO_TX", "LOG_STA_TLO", "LOG_NO_ABREV"),
				createFieldSetMapper(LogLogradouro.class));
	}

	@Bean
	public LineMapper<LogVarLog> logVarLogLineMapper() {
		return createLineMapper(
				createLineTokenizer("LOG_NU", "VLO_NU", "TLO_TX", "VLO_TX"),
				createFieldSetMapper(LogVarLog.class));
	}

	@Bean
	public LineMapper<LogNumSec> logNumSecLineMapper() {
		return createLineMapper(
				createLineTokenizer("LOG_NU", "SEC_NU_INI", "SEC_NU_FIM", "SEC_IN_LADO"),
				createFieldSetMapper(LogNumSec.class));
	}

	@Bean
	public LineMapper<LogGrandeUsuario> logGrandeUsuarioLineMapper() {
		return createLineMapper(
				createLineTokenizer("GRU_NU", "UFE_SG", "LOC_NU", "BAI_NU", "LOG_NU", "GRU_NO", "GRU_ENDERECO", "CEP", "GRU_NO_ABREV"),
				createFieldSetMapper(LogGrandeUsuario.class));
	}

	@Bean
	public LineMapper<LogFaixaUop> logFaixaUopLineMapper() {
		return createLineMapper(
				createLineTokenizer("UOP_NU", "FNC_INICIAL", "FNC_FINAL"),
				createFieldSetMapper(LogFaixaUop.class));
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
