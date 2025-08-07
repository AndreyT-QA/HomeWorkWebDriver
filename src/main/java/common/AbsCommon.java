package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbsBasePage;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public abstract class AbsCommon {

  protected WebDriver driver;
  protected Actions actions;
  protected WebDriverWait wait;
  protected final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

  public AbsCommon(WebDriver driver) {
    this.driver = driver;
    this.actions = new Actions(driver);
    this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
  }

  protected WebElement $(By locator) {
    //return driver.findElement(locator);
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  protected List<WebElement> $$(By locator) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    return driver.findElements(locator);
  }

  protected void click(By locator) {
    $(locator).click();
  }

  protected void type(By locator, String text) {
    WebElement element = $(locator);
    element.clear();
    element.sendKeys(text);
  }
}
