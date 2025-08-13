package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class TestMainPageHeadless extends AbsBaseTestSuite {
  private static final Logger logger = LogManager.getLogger(TestMainPageHeadless.class);


  public TestMainPageHeadless() {
    super.mode = "--headless";
  }

  @Test
  @DisplayName("Тест № 1")
  public void inputText() {
    MainPage mainPage = new MainPage(driver);
    logger.info("Открытие страницы");
    mainPage.open();
    logger.info("Ввод текста 'ОТУС'");
    mainPage.inputText("ОТУС");
    logger.info("Проверка введенного текста");
    mainPage.verifyInputText("ОТУС");
  }
}
