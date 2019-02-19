package steps


import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import impl.ActionsImpl

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


When(~/^user clicks on (.+) menu$/) { String menuName ->
    ActionsImpl.getCoreActions().clickExercisesAndPlansMenu()
}