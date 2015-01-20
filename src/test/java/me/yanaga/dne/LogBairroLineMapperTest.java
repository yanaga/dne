package me.yanaga.dne;

import com.google.common.base.Strings;
import me.yanaga.dne.app.BatchConfig;
import me.yanaga.dne.sqlite.bean.LogBairro;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = BatchConfig.class)
public class LogBairroLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<LogBairro> logBairroLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "7@AC@16@Bahia Velha@B Velha" },
				{ "8@AC@16@Bahia Nova@B Nova" },
				{ "9@AC@16@Baixa da Colina@Bx Colina" },
				{ "10@AC@16@Base@" },
				{ "12@AC@16@Bosque@" },
				{ "13@AC@16@Cidade Nova@C Nova" },
				{ "14@AC@16@Cadeia Velha@C Velha" },
				{ "15@AC@16@Calafate@" },
				{ "16@AC@16@Capoeira@" },
				{ "17@AC@16@Centro@" }
		};
	}

	@Test(dataProvider = "lines")
	public void testLogBairroLineMaper(String line) throws Exception {
		LogBairro logBairro = logBairroLineMapper.mapLine(line, 1);
		assertTrue(logBairro.getBaiNu() > 0);
		assertTrue(logBairro.getUfeSg().matches("[a-zA-Z]{2}"));
		assertNotNull(logBairro.getLocNu());
		assertTrue(!Strings.isNullOrEmpty(logBairro.getBaiNo()));
	}

	@Test
	public void testValues() throws Exception {
		LogBairro logBairro = logBairroLineMapper.mapLine("7@AC@16@Bahia Velha@B Velha", 1);
		assertEquals(logBairro.getBaiNu(), new Integer(7));
		assertEquals(logBairro.getUfeSg(), "AC");
		assertEquals(logBairro.getLocNu(), new Integer(16));
		assertEquals(logBairro.getBaiNo(), "Bahia Velha");
		assertEquals(logBairro.getBaiNoAbrev(), "B Velha");
	}

}
