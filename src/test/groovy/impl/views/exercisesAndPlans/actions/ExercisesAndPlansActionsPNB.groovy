package impl.views.exercisesAndPlans.actions


import impl.views.exercisesAndPlans.actions.interfaces.IExercisesAndPlansActions
import impl.views.exercisesAndPlans.pages.ExercisesAndPlansPage
import io.cify.framework.actions.ActionsDesktopWeb
import io.cify.framework.core.Device
import org.openqa.selenium.support.ui.ExpectedConditions

import static impl.helpers.TestDataManager.addTestData
import static impl.helpers.TestDataManager.getTestData

class ExercisesAndPlansActionsPNB implements IExercisesAndPlansActions, ActionsDesktopWeb {
    Device device
    ExercisesAndPlansPage exercisesAndPlansPage


    ExercisesAndPlansActionsPNB(Device device) {
        this.device = device
        this.exercisesAndPlansPage = new ExercisesAndPlansPage(device)
    }

    @Override
    boolean isExercisesAndPlansVisible() {
        return waitForCondition(device, ExpectedConditions.visibilityOf(exercisesAndPlansPage.getPageBody()), 60)
    }

    @Override
    void clickWorkoutPlans() {
        exercisesAndPlansPage.getWorkoutPlansMenu().click()
    }

    @Override
    boolean isPopularWorkoutPlansVisible() {
        return waitForCondition(device, ExpectedConditions.visibilityOf(exercisesAndPlansPage.getSearchButton()), 60) &&
                waitForCondition(device, ExpectedConditions.visibilityOf(exercisesAndPlansPage.getSearchField()), 60)
    }

    @Override
    void enterSearchCriteria(String searchCriteria) {
        addTestData("searchCriteria", searchCriteria)
        exercisesAndPlansPage.getSearchField().sendKeys(searchCriteria)
    }

    @Override
    void clickSearchButton() {
        exercisesAndPlansPage.getSearchButton().click()
    }

    @Override
    boolean checkSearchResults(String searchCriteria) {
        return exercisesAndPlansPage.getSearchResultsTable().getText().
                contains(getTestData("searchCriteria") as CharSequence)
    }

}