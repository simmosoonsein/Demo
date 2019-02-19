package impl.views.exercisesAndPlans.actions.interfaces

interface IExercisesAndPlansActions {

    /**
     * Checks if Wxercises and Plans page is visible
     * @return
     */
    boolean isExercisesAndPlansVisible()

    /**
     * Clicks on Workout Plans tab
     */
    void clickWorkoutPlans()

    /**
     * Checks if workout plan tab is displayed
     * @return
     */
    boolean isPopularWorkoutPlansVisible()

    /**
     * Enters search criteria to search field
     * @param searchCriteria
     */
    void enterSearchCriteria(String searchCriteria)

    /**
     * Clicks on search button
     */
    void clickSearchButton()

    /**
     * Checks if search results include given search parameter
     * @param searchCriteria
     * @return
     */
    boolean checkSearchResults(String searchCriteria)
}