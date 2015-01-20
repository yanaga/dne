package me.yanaga.dne;

import com.google.common.base.Strings;
import me.yanaga.dne.app.BatchConfig;
import me.yanaga.dne.sqlite.bean.LogGrandeUsuario;
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
public class LogGrandeUsuarioLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<LogGrandeUsuario> logGrandeUsuarioLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "2@AC@16@17@948218@Governo do Estado do Acre@Avenida Getúlio Vargas 232@69900900@Governo E Acre" },
				{ "3@AC@16@17@949571@Prefeitura Municipal de Rio Branco@Rua Rui Barbosa 285@69900901@Prefeitura M R Branco" },
				{ "1@AC@16@17@55@Assembléia Legislativa do Estado do Acre@Rua Arlindo Porto Leal 241@69900904@Assembléia L E Acre" },
				{ "4@AC@16@17@102@Oi@Avenida Brasil 378@69900902@" },
				{ "15346@AC@16@31@674758@UNINORTE@Alameda Hungria 200@69915901@" },
				{ "19123@AC@16@17@948295@Ministério da Fazenda@Rua Marechal Deodoro 340@69900903@Ministério Fazenda" },
				{ "20001@AC@16@25@948660@Shopping Via Verde@Estrada da Floresta 2320@69912900@Shopping V Verde" },
				{ "20277@AC@16@57389@1009708@Aeroporto Plácido de Castro@Avenida Plácido de Castro@69923900@Aer Plácido Castro" }
		};
	}

	@Test(dataProvider = "lines")
	public void testLogGrandeUsuarioLineMaper(String line) throws Exception {
		LogGrandeUsuario logGrandeUsuario = logGrandeUsuarioLineMapper.mapLine(line, 1);
		assertTrue(logGrandeUsuario.getGruNu() > 0);
		assertTrue(logGrandeUsuario.getUfeSg().matches("[a-zA-Z]{2}"));
		assertNotNull(logGrandeUsuario.getLocNu());
		assertNotNull(logGrandeUsuario.getBaiNu());
		assertTrue(!Strings.isNullOrEmpty(logGrandeUsuario.getGruNo()));
		assertTrue(!Strings.isNullOrEmpty(logGrandeUsuario.getGruEndereco()));
		assertTrue(logGrandeUsuario.getCep().matches("\\d{8}"));
	}

	@Test
	public void testValues() throws Exception {
		LogGrandeUsuario logGrandeUsuario = logGrandeUsuarioLineMapper.mapLine("2@AC@16@17@948218@Governo do Estado do Acre@Avenida Getúlio Vargas 232@69900900@Governo E Acre", 1);
		assertEquals(logGrandeUsuario.getGruNu(), new Integer(2));
		assertEquals(logGrandeUsuario.getUfeSg(), "AC");
		assertEquals(logGrandeUsuario.getLocNu(), new Integer(16));
		assertEquals(logGrandeUsuario.getBaiNu(), new Integer(17));
		assertEquals(logGrandeUsuario.getLogNu(), new Integer(948218));
		assertEquals(logGrandeUsuario.getGruNo(), "Governo do Estado do Acre");
		assertEquals(logGrandeUsuario.getGruEndereco(), "Avenida Getúlio Vargas 232");
		assertEquals(logGrandeUsuario.getCep(), "69900900");
		assertEquals(logGrandeUsuario.getGruNoAbrev(), "Governo E Acre");
	}

}
