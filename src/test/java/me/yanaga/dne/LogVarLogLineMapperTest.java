package me.yanaga.dne;

import com.google.common.base.Strings;
import me.yanaga.dne.sqlite.bean.LogVarLog;
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
public class LogVarLogLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<LogVarLog> logVarLogLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "660@1@Rua@Rua Túlias" },
				{ "1687@1@Rua@Rua da Aurora" },
				{ "1035@1@Rua@Rua 13-30" },
				{ "678044@1@Avenida@Avenida Norte" },
				{ "678045@1@Avenida@Avenida Norte" },
				{ "678046@1@Avenida@Avenida Norte" },
				{ "676499@1@Rua@Rua Neide Barbosa Rocha" },
				{ "676500@1@Rua@Rua Neide Barbosa Rocha" }
		};
	}

	@Test(dataProvider = "lines")
	public void testLogVarLogLineMaper(String line) throws Exception {
		LogVarLog logVarLog = logVarLogLineMapper.mapLine(line, 1);
		assertTrue(logVarLog.getLogNu() > 0);
		assertNotNull(logVarLog.getVloNu());
		assertTrue(!Strings.isNullOrEmpty(logVarLog.getTloTx()));
		assertTrue(!Strings.isNullOrEmpty(logVarLog.getVloTx()));
	}

	@Test
	public void testValues() throws Exception {
		LogVarLog logVarLog = logVarLogLineMapper.mapLine("660@1@Rua@Rua Túlias", 1);
		assertEquals(logVarLog.getLogNu(), new Integer(660));
		assertEquals(logVarLog.getVloNu(), new Integer(1));
		assertEquals(logVarLog.getTloTx(), "Rua");
		assertEquals(logVarLog.getVloTx(), "Rua Túlias");
	}

}
