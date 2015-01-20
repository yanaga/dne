package me.yanaga.dne;

import com.google.common.base.Strings;
import me.yanaga.dne.app.BatchConfig;
import me.yanaga.dne.sqlite.bean.LogVarLoc;
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
public class LogVarLocLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<LogVarLoc> logVarLocLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "9352@3@Martim Prado Júnior" },
				{ "9352@4@M Prado Júnior" },
				{ "9352@5@Martim P Júnior" },
				{ "9352@6@Martim P Jr" },
				{ "9630@1@Sto Antônio do Jardim" },
				{ "9630@2@S A Jardim" },
				{ "9124@1@Pinhal" },
				{ "9124@2@Espírito Sto Pinhal" }
		};
	}

	@Test(dataProvider = "lines")
	public void testLogVarLocLineMaper(String line) throws Exception {
		LogVarLoc logVarLoc = logVarLocLineMapper.mapLine(line, 1);
		assertTrue(logVarLoc.getLocNu() > 0);
		assertNotNull(logVarLoc.getValNu());
		assertTrue(!Strings.isNullOrEmpty(logVarLoc.getValTx()));
	}

	@Test
	public void testValues() throws Exception {
		LogVarLoc logVarLoc = logVarLocLineMapper.mapLine("9352@3@Martim Prado Júnior", 1);
		assertEquals(logVarLoc.getLocNu(), new Integer(9352));
		assertEquals(logVarLoc.getValNu(), new Integer(3));
		assertEquals(logVarLoc.getValTx(), "Martim Prado Júnior");
	}

}
