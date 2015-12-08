package casosTeste;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteSelenium {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8082/inovagamesTCC/administradores.xhtml";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testESelenium() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.name("j_idt5:j_idt31:j_idt35")).clear();
    driver.findElement(By.name("j_idt5:j_idt31:j_idt35")).sendKeys("Matematica");
    driver.findElement(By.name("j_idt5:j_idt31:j_idt39")).clear();
    driver.findElement(By.name("j_idt5:j_idt31:j_idt39")).sendKeys("232");
    driver.findElement(By.name("j_idt5:j_idt31:j_idt43")).clear();
    driver.findElement(By.name("j_idt5:j_idt31:j_idt43")).sendKeys("testando");
    driver.findElement(By.name("j_idt5:j_idt31:j_idt45")).click();
    driver.findElement(By.linkText("Lista de produtos")).click();
    driver.findElement(By.xpath("//div[@id='conteudo']/div/table/tbody/tr[16]/td")).click();
    // logo abaixo procura pelo nome cadastrado, para da erro só troca o nome matematica para outro nome
    assertEquals("Matematica", driver.findElement(By.xpath("//div[@id='conteudo']/div/table/tbody/tr[16]/td")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
