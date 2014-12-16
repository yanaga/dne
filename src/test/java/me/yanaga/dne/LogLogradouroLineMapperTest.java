package me.yanaga.dne;

import com.google.common.base.Strings;
import me.yanaga.dne.sqlite.bean.LogLogradouro;
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
public class LogLogradouroLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<LogLogradouro> logLogradouroLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "1@AC@16@47@@Nelson Mesquita@@69918703@Rua@S@R Nelson Mesquita" },
				{ "1000@AL@30@69@@Costa Cavalcante@@57306420@Rua@S@R Costa Cavalcante" },
				{ "10012@AM@243@170@@dos Trevos@@69088460@Rua@S@" },
				{ "1032588@AP@307@33114@@Beira Rio@(Cj, Habitacional Jard. America)@68906450@Rua@S@R Beira Rio" },
				{ "1001872@BA@582@408@@Casarão@@44028110@Rua@S@R Casarão" },
				{ "1001881@CE@1284@948@@Célia Nascimento@@61624512@Rua@S@R Célia Nascimento" },
				{ "1001964@DF@1778@1231@@QC 2 Conjunto Q@@72536165@Quadra@N@Q QC" },
				{ "100000@ES@2044@1705@@Platino@@29112060@Rua@S@R Platino" },
				{ "996939@GO@2258@31548@@Área Especial Estação Saneago@@72860029@Área@N@" },
				{ "1003122@MA@2475@56636@@São Lázaro@@65915063@Rua@S@R S Lázaro" },
				{ "1003182@MG@2754@50940@@Célio de Castro@- até 699/700@31110000@Rua@S@R Célio de Castro" },
				{ "1003278@MS@4226@55712@@MS 164@@79901130@Rodovia@S@Rod MS 164" },
				{ "1003279@MT@4462@57139@@Rio Vermelho@@78715840@Rua@S@R Rio Vermelho" },
				{ "1003303@PA@4565@6741@@Arara@@66110225@Travessa@S@Tv Arara" },
				{ "1003304@PB@4904@6949@@Maria Luiza Nascimento Alencar@@58421652@Rua@S@R Maria L N Alencar" },
				{ "1003321@PE@5135@7084@@Carlos Hilário@@53585750@Rua@S@R Carlos Hilário" },
				{ "1003446@PI@5721@7556@@Socorro de Macêdo Claudino@(Lot Ladeira Uruguai)@64073445@Rua@S@R Socorro de M Claudino" },
				{ "1003447@PR@5789@8051@@Ângelo Rigolino@@83706314@Rua@S@R Ângelo Rigolino" },
				{ "1003565@RJ@6912@11073@@Sete de Janeiro@(Novo S Bento)@25045037@Rua@S@R Sete de Janeiro" },
				{ "1003610@RN@7221@12805@@Rio Salgado@@59122507@1ª Travessa@S@1ª Tv Rio Salgado" },
				{ "1003615@RO@7352@34105@@Miguel de Cervante@@76811003@Rua@S@R Miguel de Cervante" },
				{ "1009056@RR@7375@34977@@de Acesso@@69312526@Via@S@V de Acesso" },
				{ "1003618@RS@7533@13130@@Antônio João Bianchini@- até 399 - lado ímpar@92325781@Rua@S@R Antônio J Bianchini" },
				{ "1000014@SC@8357@48449@@Olimpio Germano Rosa@@88334055@Rua@S@R Olimpio G Rosa" },
				{ "1001195@SE@8770@14221@@H@(Lot Juciara)@49061085@Rua@S@R H" },
				{ "1001235@SP@8912@14716@@Octaviano de Arruda Campos@- de 960/961 ao fim@14810227@Avenida@S@Av Octaviano de A Campos" },
				{ "1001849@TO@9862@29090@@Antonio Nunes da Silva@@77425295@Rua@S@R Antonio N da Silva" }
		};
	}

	@Test(dataProvider = "lines")
	public void testLogLogradouroLineMaper(String line) throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine(line, 1);
		assertTrue(logLogradouro.getLogNu() > 0);
		assertTrue(logLogradouro.getUfeSg().matches("[a-zA-Z]{2}"));
		assertNotNull(logLogradouro.getLocNu());
		assertNotNull(logLogradouro.getBaiNuIni());
		assertTrue(!Strings.isNullOrEmpty(logLogradouro.getLogNo()));
		assertTrue(logLogradouro.getCep().matches("\\d{8}"));
		assertTrue(!Strings.isNullOrEmpty(logLogradouro.getTloTx()));
		assertTrue(Strings.isNullOrEmpty(logLogradouro.getLogStaTlo()) || logLogradouro.getLogStaTlo().matches("[snSN]"));
	}

	@Test
	public void testValuesAC() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1@AC@16@47@@Nelson Mesquita@@69918703@Rua@S@R Nelson Mesquita", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1));
		assertEquals(logLogradouro.getUfeSg(), "AC");
		assertEquals(logLogradouro.getLocNu(), new Integer(16));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(47));
		assertEquals(logLogradouro.getLogNo(), "Nelson Mesquita");
		assertEquals(logLogradouro.getCep(), "69918703");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Nelson Mesquita");
	}

	@Test
	public void testValuesAL() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1000@AL@30@69@@Costa Cavalcante@@57306420@Rua@S@R Costa Cavalcante", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1000));
		assertEquals(logLogradouro.getUfeSg(), "AL");
		assertEquals(logLogradouro.getLocNu(), new Integer(30));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(69));
		assertEquals(logLogradouro.getLogNo(), "Costa Cavalcante");
		assertEquals(logLogradouro.getCep(), "57306420");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Costa Cavalcante");
	}

	@Test
	public void testValuesAM() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("10012@AM@243@170@@dos Trevos@@69088460@Rua@S@", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(10012));
		assertEquals(logLogradouro.getUfeSg(), "AM");
		assertEquals(logLogradouro.getLocNu(), new Integer(243));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(170));
		assertEquals(logLogradouro.getLogNo(), "dos Trevos");
		assertEquals(logLogradouro.getCep(), "69088460");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertTrue(Strings.isNullOrEmpty(logLogradouro.getLogNoAbrev()));
	}

	@Test
	public void testValuesAP() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1032588@AP@307@33114@@Beira Rio@(Cj, Habitacional Jard. America)@68906450@Rua@S@R Beira Rio", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1032588));
		assertEquals(logLogradouro.getUfeSg(), "AP");
		assertEquals(logLogradouro.getLocNu(), new Integer(307));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(33114));
		assertEquals(logLogradouro.getLogNo(), "Beira Rio");
		assertEquals(logLogradouro.getLogComplemento(), "(Cj, Habitacional Jard. America)");
		assertEquals(logLogradouro.getCep(), "68906450");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Beira Rio");
	}

	@Test
	public void testValuesBA() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1001872@BA@582@408@@Casarão@@44028110@Rua@S@R Casarão", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1001872));
		assertEquals(logLogradouro.getUfeSg(), "BA");
		assertEquals(logLogradouro.getLocNu(), new Integer(582));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(408));
		assertEquals(logLogradouro.getLogNo(), "Casarão");
		assertEquals(logLogradouro.getCep(), "44028110");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Casarão");
	}

	@Test
	public void testValuesCE() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1001881@CE@1284@948@@Célia Nascimento@@61624512@Rua@S@R Célia Nascimento", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1001881));
		assertEquals(logLogradouro.getUfeSg(), "CE");
		assertEquals(logLogradouro.getLocNu(), new Integer(1284));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(948));
		assertEquals(logLogradouro.getLogNo(), "Célia Nascimento");
		assertEquals(logLogradouro.getCep(), "61624512");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Célia Nascimento");
	}

	@Test
	public void testValuesDF() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1001964@DF@1778@1231@@QC 2 Conjunto Q@@72536165@Quadra@N@Q QC", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1001964));
		assertEquals(logLogradouro.getUfeSg(), "DF");
		assertEquals(logLogradouro.getLocNu(), new Integer(1778));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(1231));
		assertEquals(logLogradouro.getLogNo(), "QC 2 Conjunto Q");
		assertEquals(logLogradouro.getCep(), "72536165");
		assertEquals(logLogradouro.getTloTx(), "Quadra");
		assertEquals(logLogradouro.getLogStaTlo(), "N");
		assertEquals(logLogradouro.getLogNoAbrev(), "Q QC");
	}

	@Test
	public void testValuesES() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("100000@ES@2044@1705@@Platino@@29112060@Rua@S@R Platino", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(100000));
		assertEquals(logLogradouro.getUfeSg(), "ES");
		assertEquals(logLogradouro.getLocNu(), new Integer(2044));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(1705));
		assertEquals(logLogradouro.getLogNo(), "Platino");
		assertEquals(logLogradouro.getCep(), "29112060");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Platino");
	}

	@Test
	public void testValuesGO() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("996939@GO@2258@31548@@Área Especial Estação Saneago@@72860029@Área@N@", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(996939));
		assertEquals(logLogradouro.getUfeSg(), "GO");
		assertEquals(logLogradouro.getLocNu(), new Integer(2258));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(31548));
		assertEquals(logLogradouro.getLogNo(), "Área Especial Estação Saneago");
		assertEquals(logLogradouro.getCep(), "72860029");
		assertEquals(logLogradouro.getTloTx(), "Área");
		assertEquals(logLogradouro.getLogStaTlo(), "N");
		assertTrue(Strings.isNullOrEmpty(logLogradouro.getLogNoAbrev()));
	}

	@Test
	public void testValuesMA() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1003122@MA@2475@56636@@São Lázaro@@65915063@Rua@S@R S Lázaro", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1003122));
		assertEquals(logLogradouro.getUfeSg(), "MA");
		assertEquals(logLogradouro.getLocNu(), new Integer(2475));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(56636));
		assertEquals(logLogradouro.getLogNo(), "São Lázaro");
		assertEquals(logLogradouro.getCep(), "65915063");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R S Lázaro");
	}

	@Test
	public void testValuesMG() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1003182@MG@2754@50940@@Célio de Castro@- até 699/700@31110000@Rua@S@R Célio de Castro", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1003182));
		assertEquals(logLogradouro.getUfeSg(), "MG");
		assertEquals(logLogradouro.getLocNu(), new Integer(2754));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(50940));
		assertEquals(logLogradouro.getLogNo(), "Célio de Castro");
		assertEquals(logLogradouro.getLogComplemento(), "- até 699/700");
		assertEquals(logLogradouro.getCep(), "31110000");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Célio de Castro");
	}

	@Test
	public void testValuesMS() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1003278@MS@4226@55712@@MS 164@@79901130@Rodovia@S@Rod MS 164", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1003278));
		assertEquals(logLogradouro.getUfeSg(), "MS");
		assertEquals(logLogradouro.getLocNu(), new Integer(4226));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(55712));
		assertEquals(logLogradouro.getLogNo(), "MS 164");
		assertEquals(logLogradouro.getCep(), "79901130");
		assertEquals(logLogradouro.getTloTx(), "Rodovia");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "Rod MS 164");
	}

	@Test
	public void testValuesMT() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1003279@MT@4462@57139@@Rio Vermelho@@78715840@Rua@S@R Rio Vermelho", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1003279));
		assertEquals(logLogradouro.getUfeSg(), "MT");
		assertEquals(logLogradouro.getLocNu(), new Integer(4462));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(57139));
		assertEquals(logLogradouro.getLogNo(), "Rio Vermelho");
		assertEquals(logLogradouro.getCep(), "78715840");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Rio Vermelho");
	}

	@Test
	public void testValuesPA() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1003303@PA@4565@6741@@Arara@@66110225@Travessa@S@Tv Arara", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1003303));
		assertEquals(logLogradouro.getUfeSg(), "PA");
		assertEquals(logLogradouro.getLocNu(), new Integer(4565));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(6741));
		assertEquals(logLogradouro.getLogNo(), "Arara");
		assertEquals(logLogradouro.getCep(), "66110225");
		assertEquals(logLogradouro.getTloTx(), "Travessa");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "Tv Arara");
	}

	@Test
	public void testValuesPB() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1003304@PB@4904@6949@@Maria Luiza Nascimento Alencar@@58421652@Rua@S@R Maria L N Alencar", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1003304));
		assertEquals(logLogradouro.getUfeSg(), "PB");
		assertEquals(logLogradouro.getLocNu(), new Integer(4904));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(6949));
		assertEquals(logLogradouro.getLogNo(), "Maria Luiza Nascimento Alencar");
		assertEquals(logLogradouro.getCep(), "58421652");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Maria L N Alencar");
	}

	@Test
	public void testValuesPE() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1003321@PE@5135@7084@@Carlos Hilário@@53585750@Rua@S@R Carlos Hilário", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1003321));
		assertEquals(logLogradouro.getUfeSg(), "PE");
		assertEquals(logLogradouro.getLocNu(), new Integer(5135));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(7084));
		assertEquals(logLogradouro.getLogNo(), "Carlos Hilário");
		assertEquals(logLogradouro.getCep(), "53585750");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Carlos Hilário");
	}

	@Test
	public void testValuesPI() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1003446@PI@5721@7556@@Socorro de Macêdo Claudino@(Lot Ladeira Uruguai)@64073445@Rua@S@R Socorro de M Claudino", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1003446));
		assertEquals(logLogradouro.getUfeSg(), "PI");
		assertEquals(logLogradouro.getLocNu(), new Integer(5721));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(7556));
		assertEquals(logLogradouro.getLogNo(), "Socorro de Macêdo Claudino");
		assertEquals(logLogradouro.getLogComplemento(), "(Lot Ladeira Uruguai)");
		assertEquals(logLogradouro.getCep(), "64073445");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Socorro de M Claudino");
	}

	@Test
	public void testValuesPR() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1003447@PR@5789@8051@@Ângelo Rigolino@@83706314@Rua@S@R Ângelo Rigolino", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1003447));
		assertEquals(logLogradouro.getUfeSg(), "PR");
		assertEquals(logLogradouro.getLocNu(), new Integer(5789));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(8051));
		assertEquals(logLogradouro.getLogNo(), "Ângelo Rigolino");
		assertEquals(logLogradouro.getCep(), "83706314");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Ângelo Rigolino");
	}

	@Test
	public void testValuesRJ() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1003565@RJ@6912@11073@@Sete de Janeiro@(Novo S Bento)@25045037@Rua@S@R Sete de Janeiro", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1003565));
		assertEquals(logLogradouro.getUfeSg(), "RJ");
		assertEquals(logLogradouro.getLocNu(), new Integer(6912));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(11073));
		assertEquals(logLogradouro.getLogNo(), "Sete de Janeiro");
		assertEquals(logLogradouro.getLogComplemento(), "(Novo S Bento)");
		assertEquals(logLogradouro.getCep(), "25045037");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Sete de Janeiro");
	}

	@Test
	public void testValuesRN() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1003610@RN@7221@12805@@Rio Salgado@@59122507@1ª Travessa@S@1ª Tv Rio Salgado", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1003610));
		assertEquals(logLogradouro.getUfeSg(), "RN");
		assertEquals(logLogradouro.getLocNu(), new Integer(7221));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(12805));
		assertEquals(logLogradouro.getLogNo(), "Rio Salgado");
		assertEquals(logLogradouro.getCep(), "59122507");
		assertEquals(logLogradouro.getTloTx(), "1ª Travessa");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "1ª Tv Rio Salgado");
	}

	@Test
	public void testValuesRO() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1003615@RO@7352@34105@@Miguel de Cervante@@76811003@Rua@S@R Miguel de Cervante", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1003615));
		assertEquals(logLogradouro.getUfeSg(), "RO");
		assertEquals(logLogradouro.getLocNu(), new Integer(7352));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(34105));
		assertEquals(logLogradouro.getLogNo(), "Miguel de Cervante");
		assertEquals(logLogradouro.getCep(), "76811003");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Miguel de Cervante");
	}

	@Test
	public void testValuesRR() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1009056@RR@7375@34977@@de Acesso@@69312526@Via@S@V de Acesso", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1009056));
		assertEquals(logLogradouro.getUfeSg(), "RR");
		assertEquals(logLogradouro.getLocNu(), new Integer(7375));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(34977));
		assertEquals(logLogradouro.getLogNo(), "de Acesso");
		assertEquals(logLogradouro.getCep(), "69312526");
		assertEquals(logLogradouro.getTloTx(), "Via");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "V de Acesso");
	}

	@Test
	public void testValuesRS() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1003618@RS@7533@13130@@Antônio João Bianchini@- até 399 - lado ímpar@92325781@Rua@S@R Antônio J Bianchini", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1003618));
		assertEquals(logLogradouro.getUfeSg(), "RS");
		assertEquals(logLogradouro.getLocNu(), new Integer(7533));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(13130));
		assertEquals(logLogradouro.getLogNo(), "Antônio João Bianchini");
		assertEquals(logLogradouro.getLogComplemento(), "- até 399 - lado ímpar");
		assertEquals(logLogradouro.getCep(), "92325781");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Antônio J Bianchini");
	}

	@Test
	public void testValuesSC() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1000014@SC@8357@48449@@Olimpio Germano Rosa@@88334055@Rua@S@R Olimpio G Rosa", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1000014));
		assertEquals(logLogradouro.getUfeSg(), "SC");
		assertEquals(logLogradouro.getLocNu(), new Integer(8357));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(48449));
		assertEquals(logLogradouro.getLogNo(), "Olimpio Germano Rosa");
		assertEquals(logLogradouro.getCep(), "88334055");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Olimpio G Rosa");
	}

	@Test
	public void testValuesSE() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1001195@SE@8770@14221@@H@(Lot Juciara)@49061085@Rua@S@R H", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1001195));
		assertEquals(logLogradouro.getUfeSg(), "SE");
		assertEquals(logLogradouro.getLocNu(), new Integer(8770));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(14221));
		assertEquals(logLogradouro.getLogNo(), "H");
		assertEquals(logLogradouro.getLogComplemento(), "(Lot Juciara)");
		assertEquals(logLogradouro.getCep(), "49061085");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R H");
	}

	@Test
	public void testValuesSP() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1001235@SP@8912@14716@@Octaviano de Arruda Campos@- de 960/961 ao fim@14810227@Avenida@S@Av Octaviano de A Campos", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1001235));
		assertEquals(logLogradouro.getUfeSg(), "SP");
		assertEquals(logLogradouro.getLocNu(), new Integer(8912));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(14716));
		assertEquals(logLogradouro.getLogNo(), "Octaviano de Arruda Campos");
		assertEquals(logLogradouro.getLogComplemento(), "- de 960/961 ao fim");
		assertEquals(logLogradouro.getCep(), "14810227");
		assertEquals(logLogradouro.getTloTx(), "Avenida");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "Av Octaviano de A Campos");
	}

	@Test
	public void testValuesTO() throws Exception {
		LogLogradouro logLogradouro = logLogradouroLineMapper.mapLine("1001849@TO@9862@29090@@Antonio Nunes da Silva@@77425295@Rua@S@R Antonio N da Silva", 1);
		assertEquals(logLogradouro.getLogNu(), new Integer(1001849));
		assertEquals(logLogradouro.getUfeSg(), "TO");
		assertEquals(logLogradouro.getLocNu(), new Integer(9862));
		assertEquals(logLogradouro.getBaiNuIni(), new Integer(29090));
		assertEquals(logLogradouro.getLogNo(), "Antonio Nunes da Silva");
		assertEquals(logLogradouro.getCep(), "77425295");
		assertEquals(logLogradouro.getTloTx(), "Rua");
		assertEquals(logLogradouro.getLogStaTlo(), "S");
		assertEquals(logLogradouro.getLogNoAbrev(), "R Antonio N da Silva");
	}

}
