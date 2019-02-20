package impl.views.core.actions


import impl.views.core.actions.interfaces.ICoreActions
import impl.views.core.pages.CorePage
import io.cify.framework.actions.ActionsDesktopWeb
import io.cify.framework.core.Device
import org.openqa.selenium.support.ui.ExpectedConditions

import static impl.helpers.TestDataManager.addTestData
import static impl.helpers.TestDataManager.getTestData

class CoreActionsWEB implements ICoreActions, ActionsDesktopWeb {

    Device device
    CorePage corePage

    CoreActionsWEB(Device device) {
        this.device = device
        this.corePage = new CorePage(device)
    }

    @Override
    void openApplication() {
        device.openBrowser(getTestData("URL") as String)
        device.getDriver().manage().window().maximize()
    }

    @Override
    boolean isMainMenuVisible() {
        return waitForCondition(device, ExpectedConditions.visibilityOf(corePage.getMainMenu()), 60)
    }

    @Override
    void clickExercisesAndPlansMenu() {
        corePage.getExercisesAndPlansMenu().click()
    }

    @Override
    void clickRegistrationButton() {
        corePage.getRegisterButton().click()
    }

    @Override
    void enterEmail(String email) {
        addTestData("email", email)
        corePage.getEmailInputField().sendKeys(email)
    }

    @Override
    void clickRegistrationConfirmButton() {
        corePage.getRegistrationConfrimButton().click()
    }
}