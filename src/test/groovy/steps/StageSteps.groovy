package steps


import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import impl.ActionsImpl
import impl.helpers.TestDataManager

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)



Then(~/^notification to check confirmation e-mail on user mailbox is displayed$/) { ->
    if (!ActionsImpl.getStageActions().isConfirmationMsgVisible(
            TestDataManager.getTestData("email") as String)) {
        throw new Error("E-mail confirmation message is not displayed")
    }

}
Then(~/^main page for logged in user is displayed$/) { ->
    if (!ActionsImpl.getStageActions().isStagePageVisible()) {
        throw new Error("Stage page not displayed")
    }
}