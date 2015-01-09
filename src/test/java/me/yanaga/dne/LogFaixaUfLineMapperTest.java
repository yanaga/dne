package me.yanaga.dne;

import me.yanaga.dne.config.root.BatchConfig;
import me.yanaga.dne.app.bean.LogFaixaUf;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = BatchConfig.class)
public class LogFaixaUfLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<LogFaixaUf> logFaixaUfLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{"AC@69900000@69999999"},
				{"AL@57000000@57999999"},
				{"AM@69000000@69299999"},
				{"AM@69400000@69899999"},
				{"AP@68900000@68999999"},
				{"BA@40000000@48999999"},
				{"CE@60000000@63999999"},
				{"DF@70000000@72799999"}
		};
	}

	@Test(dataProvider = "lines")
	public void testLogFaixaUfLineMapper(String line) throws Exception {
		LogFaixaUf logFaixaUf = logFaixaUfLineMapper.mapLine(line, 1);
		assertTrue(logFaixaUf.getUfeSg().matches("[a-zA-Z]{2}"));
		assertTrue(logFaixaUf.getUfeCepIni().matches("\\d{8}"));
		assertTrue(logFaixaUf.getUfeCepFim().matches("\\d{8}"));
	}

	@Test
	public void testValues() throws Exception {
		LogFaixaUf logFaixaUf = logFaixaUfLineMapper.mapLine("AC@69900000@69999999", 1);
		assertEquals(logFaixaUf.getUfeSg(), "AC");
		assertEquals(logFaixaUf.getUfeCepIni(), "69900000");
		assertEquals(logFaixaUf.getUfeCepFim(), "69999999");
	}

}
