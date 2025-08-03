package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;

import javax.xml.xpath.XPath;

public class MainPage extends AbsBasePage{

  private final By TEXT_INPUT = By.id("textInput");
  private final By OPEN_MODAL_WINDOW = By.id("openModalBtn");
  private final By SAMPLE_FORM_NAME = By.id("name");
  private final By SAMPLE_FORM_EMAIL = By.id("email");
  private final By SAMPLE_FORM_SUBMIT = By.cssSelector("button[type='submit']");
  private final By MESSAGEBOX = By.id("messageBox");
//  private final By MODAL_CONTENT = By.xpath("//div[@class='modal-content']");

  public MainPage(WebDriver driver) {
    super(driver, "/training.html");
  }

  public void inputText(String text) {
    $(TEXT_INPUT).clear();
    $(TEXT_INPUT).sendKeys(text);
  }

  public void verifyInputText(String expectedText) {
    String actualText = $(TEXT_INPUT).getAttribute("value");
    assertThat(actualText).isEqualTo(expectedText);
  }
  public void openModalWindow() {
    $(OPEN_MODAL_WINDOW).click();
  }

  public void verifyModalWindowOpened() {
    assertThat($(OPEN_MODAL_WINDOW).isDisplayed()).isTrue();
  }

  public void fillForm(String name, String email) {
    $(SAMPLE_FORM_NAME).sendKeys(name);
    $(SAMPLE_FORM_EMAIL).sendKeys(email);
  }

  public void submitForm() {
    $(SAMPLE_FORM_SUBMIT).click();
  }

  public void verifyMessagebox(String expectedName, String expectedEmail) {
    String expectedMessage = String.format(
        "Форма отправлена с именем: %s и email: %s",
        expectedName, expectedEmail
    );
    assertThat($(MESSAGEBOX).getText()).isEqualTo(expectedMessage);
  }

}
