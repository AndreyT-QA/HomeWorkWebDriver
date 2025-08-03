package main;

import factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainPageHeadless extends AbsBaseTestSuite {
  private static final Logger logger = LogManager.getLogger(MainPageHeadless.class);


  public MainPageHeadless() {
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
