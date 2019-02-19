package steps

import cucumber.api.Scenario
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import impl.ActionsImpl
import io.cify.framework.core.DeviceCategory
import io.cify.framework.core.DeviceManager

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


Given(~/^user opens web (.+) with Gymwolf page$/) { String applicationType ->
    if (!DeviceManager.getInstance().hasActiveDevice(DeviceCategory.valueOf(applicationType.toUpperCase()))) {
        DeviceManager.getInstance().createDevice(DeviceCategory.valueOf(applicationType.toUpperCase()))
    }
    ActionsImpl.getCoreActions().openApplication()
    if (!ActionsImpl.getCoreActions().isMainMenuVisible()) {
        throw new Exception("Main page is not displayed")
    }
}

When(~/^user clicks on "Start Free" butto$/) { ->

}

When(~/^user clicks on "([^"]*)" button$/) { String arg1 ->
    ActionsImpl.getCoreActions().clickRegistrationButton()
}
Then(~/^user enters (.+) as e-mail$/) { String email ->
    ActionsImpl.getCoreActions().enterEmail(email)
}
When(~/^user clicks "Register" button$/) { ->
    ActionsImpl.getCoreActions().clickRegistrationConfirmButton()
}


After(1) { Scenario scenario ->
    try {
        DeviceManager.getInstance().quitAllDevices()
    } catch (all) {
        String message = all.message == null ? all.getCause().getMessage() : all.message
        println("Could not quit device cause: " + message)
    }
}

