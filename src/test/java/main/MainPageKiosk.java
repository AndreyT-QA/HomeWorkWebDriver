package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import org.openqa.selenium.WebDriver;



public class MainPageKiosk extends AbsBaseTestSuite{
  private static final Logger logger = LogManager.getLogger(MainPageKiosk.class);


  public MainPageKiosk() {
    super.mode = "--kiosk";
  }

  @Test
  @DisplayName("Тест № 2")
  public void openWindown() {
    MainPage mainPage = new MainPage(driver);
    logger.info("Открытие страницы");
    mainPage.open();
    logger.info("Открытие модального окна");
    mainPage.openModalWindow();
    logger.info("Проверка, что модальное окно открылось");
    mainPage.verifyModalWindowOpened();
  }
}
