package steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import impl.ActionsImpl
import impl.helpers.TestDataManager

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


Then(~/^"Exercises list" page will be displayed$/) { ->
    if (!ActionsImpl.getExercisesAndPlansActions().isExercisesAndPlansVisible()) {
        throw new Error("Exercise list is not visible")
    }
}
When(~/^user clicks on "(.+)" tab$/) { String tabName ->
    ActionsImpl.getExercisesAndPlansActions().clickWorkoutPlans()
}
Then(~/^popular workout plans are displayed$/) { ->
    if (!ActionsImpl.getExercisesAndPlansActions().isPopularWorkoutPlansVisible()) {
        throw new Error("Popular workout plans table not visible")
    }
}
When(~/^user enters (.+) and clicks on Search button$/) { String searchCriteria ->
    ActionsImpl.getExercisesAndPlansActions().enterSearchCriteria(searchCriteria)
    ActionsImpl.getExercisesAndPlansActions().clickSearchButton()
}
Then(~/^workout plans for entered search criteria are displayed$/) { ->
    if (!ActionsImpl.getExercisesAndPlansActions().checkSearchResults()) {
        throw new Error("Search criteria: " + TestDataManager.getTestData("searchCriteria") +
                " is not found in the search results")
    }
}