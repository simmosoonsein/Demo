package impl.views.stage.actions.interfaces

interface IStageActions {

    /**
     * Checks if stage page is visible
     * @return
     */
    boolean isStagePageVisible()

    /**
     * Checks if confirmation message includes given e-mail
     * @param email
     * @return
     */
    boolean isConfirmationMsgVisible(String email)

}