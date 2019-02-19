package impl.views.core.actions.interfaces

interface ICoreActions {

    /**
     * Opens application
     */
    void openApplication()

    /**
     * Checks if main menu bar is visible on the page
     * @return
     */
    boolean isMainMenuVisible()

    /**
     * Clicks "Exercises and Plans" menu point
     */
    void clickExercisesAndPlansMenu()

    /**
     * Clicks "Start free" button
     */
    void clickRegistrationButton()

    /**
     * Enters e-mail to e-mail field
     * @param email
     */
    void enterEmail(String email)

    /**
     * Clicks "Register" button
     */
    void clickRegistrationConfirmButton()

}