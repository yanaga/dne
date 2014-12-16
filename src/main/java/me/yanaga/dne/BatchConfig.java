package me.yanaga.dne;

import me.yanaga.dne.sqlite.bean.LogFaixaUf;
import me.yanaga.dne.sqlite.bean.LogLocalidade;
import me.yanaga.dne.sqlite.bean.LogUnidOper;
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

}
