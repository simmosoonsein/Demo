package impl.views.stage.pages

import impl.views.core.pages.CorePage
import io.cify.framework.core.Device
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class StagePage extends CorePage {

    Device device

    @FindBy(className = "container")
    WebElement container

    @FindBy(className = "stats-row")
    WebElement alertText

    StagePage(Device device) {
        super(device)
        this.device = device
    }
}