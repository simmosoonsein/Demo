package impl.views.exercisesAndPlans.pages

import impl.views.core.pages.CorePage
import io.cify.framework.core.Device
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class ExercisesAndPlansPage extends CorePage {

    Device device

    @FindBy(className = "col-md-12")
    WebElement pageBody

    @FindBy(css = "a[href*='/staging/exercises/workout_plans']")
    WebElement workoutPlansMenu

    @FindBy(css = "*.btn-primary")
    WebElement searchButton


    ExercisesAndPlansPage(Device device) {
        super(device)
        this.device = device
    }

    WebElement getSearchField() {
        WebElement elem = pageBody.findElement(By.cssSelector("div[class='form-group']"))
        return elem.findElement(By.name("s"))
    }

    WebElement getSearchResultsTable() {
        return pageBody.findElement(By.cssSelector("*.table-bordered"))
    }

}