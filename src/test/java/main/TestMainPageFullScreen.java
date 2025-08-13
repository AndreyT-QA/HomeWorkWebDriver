package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class TestMainPageFullScreen extends AbsBaseTestSuite{
  private static final Logger logger = LogManager.getLogger(TestMainPageFullScreen.class);


  public TestMainPageFullScreen() {
    super.mode = "--start-fullscreen";
  }

  @Test
  @DisplayName("Тест № 3")
  public void sampleForm() {
    MainPage mainPage = new MainPage(driver);
    logger.info("Открытие страницы");
    mainPage.open();
    logger.info("Ввод имени и email");
    String name = "фыв";
    String email = "asdf@sdfg.rt";
    mainPage.fillForm(name, email);
    logger.info("Проверка, что появилось динамическое сообщение");
    mainPage.submitForm();
    mainPage.verifyMessagebox(name, email);
  }
}

