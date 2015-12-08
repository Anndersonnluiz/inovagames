package casosTeste;
import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class PesquisaSimples extends SeleneseTestCase {
@Before
public void setUp() throws Exception {
setUp("http://www.google.com.br/&#8221;", "*chrome");
}
@Test
public void testarPesquisaSimples() throws Exception {
selenium.open("/");
selenium.click("link=Imagens");
selenium.waitForPageToLoad("30000");
verifyEquals("Imagens do Google",selenium.getTitle());
}
@After
public void tearDown() throws Exception {
selenium.stop();
}
}
