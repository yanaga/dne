package me.yanaga.dne;

import me.yanaga.dne.sqlite.bean.LogBairro;
import me.yanaga.dne.sqlite.bean.LogCpc;
import me.yanaga.dne.sqlite.bean.LogFaixaBairro;
import me.yanaga.dne.sqlite.bean.LogFaixaCpc;
import me.yanaga.dne.sqlite.bean.LogFaixaLocalidade;
import me.yanaga.dne.sqlite.bean.LogFaixaUf;
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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

	@Bean
	public LineMapper<LogUnidOper> logUnidOperLineMapper() {
		DefaultLineMapper<LogUnidOper> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(logUnidOperLineTokenizer());
		lineMapper.setFieldSetMapper(logUnidOperFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public DelimitedLineTokenizer logUnidOperLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"UOP_NU", "UFE_SG", "LOC_NU", "BAI_NU", "LOG_NU", "UOP_NO",
				"UOP_ENDERECO", "CEP", "UOP_IN_CP", "UOP_NO_ABREV" });
		return tokenizer;
	}

	@Bean
	public FieldSetMapper<LogUnidOper> logUnidOperFieldSetMapper() {
		BeanWrapperFieldSetMapper<LogUnidOper> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(LogUnidOper.class);
		return fieldSetMapper;
	}

	@Bean
	public LineMapper<LogFaixaUf> logFaixaUfLineMapper() {
		DefaultLineMapper<LogFaixaUf> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(logFaixaUfLineTokenizer());
		lineMapper.setFieldSetMapper(logFaixaUfFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public DelimitedLineTokenizer logFaixaUfLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"UFE_SG", "UFE_CEP_INI", "UFE_CEP_FIM"
		});
		return tokenizer;
	}

	@Bean
	public FieldSetMapper<LogFaixaUf> logFaixaUfFieldSetMapper() {
		BeanWrapperFieldSetMapper<LogFaixaUf> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(LogFaixaUf.class);
		return fieldSetMapper;
	}

	@Bean
	public LineMapper<LogLocalidade> logLocalidadeLineMapper() {
		DefaultLineMapper<LogLocalidade> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(logLocalidadeLineTokenizer());
		lineMapper.setFieldSetMapper(logLocalidadeFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public DelimitedLineTokenizer logLocalidadeLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"LOC_NU", "UFE_SG", "LOC_NO", "CEP", "LOC_IN_SIT",
				"LOC_IN_TIPO_LOC", "LOC_NU_SUB", "LOC_NO_ABREV", "MUN_NU"
		});
		return tokenizer;
	}

	@Bean
	public FieldSetMapper<LogLocalidade> logLocalidadeFieldSetMapper() {
		BeanWrapperFieldSetMapper<LogLocalidade> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(LogLocalidade.class);
		return fieldSetMapper;
	}

	@Bean
	public LineMapper<LogVarLoc> logVarLocLineMapper() {
		DefaultLineMapper<LogVarLoc> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(logVarLocLineTokenizer());
		lineMapper.setFieldSetMapper(logVarLocFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public DelimitedLineTokenizer logVarLocLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"LOC_NU", "VAL_NU", "VAL_TX"
		});
		return tokenizer;
	}

	@Bean
	public FieldSetMapper<LogVarLoc> logVarLocFieldSetMapper() {
		BeanWrapperFieldSetMapper<LogVarLoc> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(LogVarLoc.class);
		return fieldSetMapper;
	}

	@Bean
	public LineMapper<LogFaixaLocalidade> logFaixaLocalidadeLineMapper() {
		DefaultLineMapper<LogFaixaLocalidade> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(logFaixaLocalidadeLineTokenizer());
		lineMapper.setFieldSetMapper(logFaixaLocalidadeFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public DelimitedLineTokenizer logFaixaLocalidadeLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"LOC_NU", "LOC_CEP_INI", "LOC_CEP_FIM"
		});
		return tokenizer;
	}

	@Bean
	public FieldSetMapper<LogFaixaLocalidade> logFaixaLocalidadeFieldSetMapper() {
		BeanWrapperFieldSetMapper<LogFaixaLocalidade> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(LogFaixaLocalidade.class);
		return fieldSetMapper;
	}

	@Bean
	public LineMapper<LogBairro> logBairroLineMapper() {
		DefaultLineMapper<LogBairro> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(logBairroLineTokenizer());
		lineMapper.setFieldSetMapper(logBairroFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public DelimitedLineTokenizer logBairroLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"BAI_NU", "UFE_SG", "LOC_NU", "BAI_NO", "BAI_NO_ABREV"
		});
		return tokenizer;
	}

	@Bean
	public FieldSetMapper<LogBairro> logBairroFieldSetMapper() {
		BeanWrapperFieldSetMapper<LogBairro> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(LogBairro.class);
		return fieldSetMapper;
	}

	@Bean
	public LineMapper<LogVarBai> logVarBaiLineMapper() {
		DefaultLineMapper<LogVarBai> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(logVarBaiLineTokenizer());
		lineMapper.setFieldSetMapper(logVarBaiFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public DelimitedLineTokenizer logVarBaiLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"BAI_NU", "VDB_NU", "VDB_TX"
		});
		return tokenizer;
	}

	@Bean
	public FieldSetMapper<LogVarBai> logVarBaiFieldSetMapper() {
		BeanWrapperFieldSetMapper<LogVarBai> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(LogVarBai.class);
		return fieldSetMapper;
	}

	@Bean
	public LineMapper<LogFaixaBairro> logFaixaBairroLineMapper() {
		DefaultLineMapper<LogFaixaBairro> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(logFaixaBairroLineTokenizer());
		lineMapper.setFieldSetMapper(logFaixaBairroFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public DelimitedLineTokenizer logFaixaBairroLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"BAI_NU", "FCB_CEP_INI", "FCB_CEP_FIM"
		});
		return tokenizer;
	}

	@Bean
	public FieldSetMapper<LogFaixaBairro> logFaixaBairroFieldSetMapper() {
		BeanWrapperFieldSetMapper<LogFaixaBairro> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(LogFaixaBairro.class);
		return fieldSetMapper;
	}

	@Bean
	public LineMapper<LogCpc> logCpcLineMapper() {
		DefaultLineMapper<LogCpc> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(logCpcLineTokenizer());
		lineMapper.setFieldSetMapper(logCpcFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public DelimitedLineTokenizer logCpcLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"CPC_NU", "UFE_SG", "LOC_NU", "CPC_NO", "CPC_ENDERECO", "CEP"
		});
		return tokenizer;
	}

	@Bean
	public FieldSetMapper<LogCpc> logCpcFieldSetMapper() {
		BeanWrapperFieldSetMapper<LogCpc> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(LogCpc.class);
		return fieldSetMapper;
	}

	@Bean
	public LineMapper<LogFaixaCpc> logFaixaCpcLineMapper() {
		DefaultLineMapper<LogFaixaCpc> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(logFaixaCpcLineTokenizer());
		lineMapper.setFieldSetMapper(logFaixaCpcFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public DelimitedLineTokenizer logFaixaCpcLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"CPC_NU", "CPC_INICIAL", "CPC_FINAL"
		});
		return tokenizer;
	}

	@Bean
	public FieldSetMapper<LogFaixaCpc> logFaixaCpcFieldSetMapper() {
		BeanWrapperFieldSetMapper<LogFaixaCpc> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(LogFaixaCpc.class);
		return fieldSetMapper;
	}

	@Bean
	public LineMapper<LogLogradouro> logLogradouroLineMapper() {
		DefaultLineMapper<LogLogradouro> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(logLogradouroLineTokenizer());
		lineMapper.setFieldSetMapper(logLogradouroFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public DelimitedLineTokenizer logLogradouroLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"LOG_NU", "UFE_SG", "LOC_NU", "BAI_NU_INI", "BAI_NU_FIM", "LOG_NO", "LOG_COMPLEMENTO",
				"CEP", "TLO_TX", "LOG_STA_TLO", "LOG_NO_ABREV"
		});
		return tokenizer;
	}

	@Bean
	public FieldSetMapper<LogLogradouro> logLogradouroFieldSetMapper() {
		BeanWrapperFieldSetMapper<LogLogradouro> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(LogLogradouro.class);
		return fieldSetMapper;
	}

	@Bean
	public LineMapper<LogVarLog> logVarLogLineMapper() {
		DefaultLineMapper<LogVarLog> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(logVarLogLineTokenizer());
		lineMapper.setFieldSetMapper(logVarLogFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public DelimitedLineTokenizer logVarLogLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"LOG_NU", "VLO_NU", "TLO_TX", "VLO_TX"
		});
		return tokenizer;
	}

	@Bean
	public FieldSetMapper<LogVarLog> logVarLogFieldSetMapper() {
		BeanWrapperFieldSetMapper<LogVarLog> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(LogVarLog.class);
		return fieldSetMapper;
	}

	@Bean
	public LineMapper<LogNumSec> logNumSecLineMapper() {
		DefaultLineMapper<LogNumSec> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(logNumSecLineTokenizer());
		lineMapper.setFieldSetMapper(logNumSecFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public DelimitedLineTokenizer logNumSecLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"LOG_NU", "SEC_NU_INI", "SEC_NU_FIM", "SEC_IN_LADO"
		});
		return tokenizer;
	}

	@Bean
	public FieldSetMapper<LogNumSec> logNumSecFieldSetMapper() {
		BeanWrapperFieldSetMapper<LogNumSec> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(LogNumSec.class);
		return fieldSetMapper;
	}

	@Bean
	public LineMapper<LogGrandeUsuario> logGrandeUsuarioLineMapper() {
		DefaultLineMapper<LogGrandeUsuario> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(logGrandeUsuarioLineTokenizer());
		lineMapper.setFieldSetMapper(logGrandeUsuarioFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public DelimitedLineTokenizer logGrandeUsuarioLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"GRU_NU", "UFE_SG", "LOC_NU", "BAI_NU", "LOG_NU", "GRU_NO", "GRU_ENDERECO", "CEP", "GRU_NO_ABREV"
		});
		return tokenizer;
	}

	@Bean
	public FieldSetMapper<LogGrandeUsuario> logGrandeUsuarioFieldSetMapper() {
		BeanWrapperFieldSetMapper<LogGrandeUsuario> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(LogGrandeUsuario.class);
		return fieldSetMapper;
	}
}
