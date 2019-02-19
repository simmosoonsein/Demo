package impl.views.stage.actions


import impl.views.stage.actions.interfaces.IStageActions
import impl.views.stage.pages.StagePage
import io.cify.framework.actions.ActionsDesktopWeb
import io.cify.framework.core.Device
import org.openqa.selenium.support.ui.ExpectedConditions

class StageActionsPNB implements IStageActions, ActionsDesktopWeb {
    Device device
    StagePage stagePage


    StageActionsPNB(Device device) {
        this.device = device
        this.stagePage = new StagePage(device)
    }

    @Override
    boolean isStagePageVisible() {
        return waitForCondition(device, ExpectedConditions.visibilityOf(stagePage.getContainer()), 60)
    }

    @Override
    boolean isConfirmationMsgVisible(String email) {
        return stagePage.getAlertText().getText().contains(email)
    }
}