package me.yanaga.dne;

import com.google.common.base.Strings;
import me.yanaga.dne.config.root.BatchConfig;
import me.yanaga.dne.app.bean.LogVarBai;
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
public class LogVarBaiLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<LogVarBai> logVarBaiLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "56120@1@Setor de Habitações Coletivas Noroeste" },
				{ "7653@1@Jd Tatiana" },
				{ "7652@1@Jd Tamboara" },
				{ "7649@1@Jardim São Roque" },
				{ "7649@2@Jd S Roque" },
				{ "8193@1@Jardim Itaboa" },
				{ "8192@1@Jardim Helvidia" },
				{ "8724@1@Cjto Alice" }
		};
	}

	@Test(dataProvider = "lines")
	public void testLogVarBaiLineMaper(String line) throws Exception {
		LogVarBai logVarBai = logVarBaiLineMapper.mapLine(line, 1);
		assertTrue(logVarBai.getBaiNu() > 0);
		assertNotNull(logVarBai.getVdbNu());
		assertTrue(!Strings.isNullOrEmpty(logVarBai.getVdbTx()));
	}

	@Test
	public void testValues() throws Exception {
		LogVarBai logVarBai = logVarBaiLineMapper.mapLine("56120@1@Setor de Habitações Coletivas Noroeste", 1);
		assertEquals(logVarBai.getBaiNu(), new Integer(56120));
		assertEquals(logVarBai.getVdbNu(), new Integer(1));
		assertEquals(logVarBai.getVdbTx(), "Setor de Habitações Coletivas Noroeste");
	}

}
