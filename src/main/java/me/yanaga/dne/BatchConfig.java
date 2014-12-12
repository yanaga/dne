package me.yanaga.dne;

import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

	@Bean
	public DelimitedLineTokenizer logUnidOperLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("@");
		tokenizer.setNames(new String[] {
				"UOP_NU", "UFE_SG", "LOC_NU", "BAI_NU", "LOG_NU", "UOP_NO",
				"UOP_ENDERECO", "CEP", "UOP_IN_CP", "UOP_NO_ABREV" });
		return tokenizer;
	}

}
