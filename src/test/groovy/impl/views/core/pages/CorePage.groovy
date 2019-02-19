package impl.views.core.pages


import io.cify.framework.PageObjects
import io.cify.framework.core.Device
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class CorePage extends PageObjects {

    Device device

    @FindBy(id = "main-menu")
    WebElement mainMenu

    @FindBy(css = "a[href*='/staging/exercises']")
    WebElement exercisesAndPlansMenu

    @FindBy(className = "landing-signup")
    WebElement registerButton

    @FindBy(name = "signup_email")
    WebElement emailInputField

    @FindBy(className = "landing-signup")
    WebElement registrationPanel


    CorePage(Device device) {
        super(device)
        this.device = device
    }

    WebElement getRegistrationConfrimButton() {
        return registrationPanel.findElement(By.tagName("button"))
    }
}