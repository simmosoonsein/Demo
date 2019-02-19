package impl

import impl.views.core.actions.interfaces.ICoreActions
import impl.views.exercisesAndPlans.actions.interfaces.IExercisesAndPlansActions
import impl.views.stage.actions.interfaces.IStageActions
import io.cify.framework.Actions
import io.cify.framework.core.DeviceManager

class ActionsImpl {

    /**
     * Implementation package
     */
    private static final String IMPLEMENTATION_PACKAGE = "impl.views."

    /**
     * Gets core actions for current device
     * @return
     */
    static ICoreActions getCoreActions() {
        return (ICoreActions) Actions.getCustomActions(DeviceManager.getInstance().getActiveDevice(), IMPLEMENTATION_PACKAGE + "core.actions.CoreActions")
    }

    /**
     * Gets Exercises and plans actions for current device
     * @return
     */
    static IExercisesAndPlansActions getExercisesAndPlansActions() {
        return (IExercisesAndPlansActions) Actions.getCustomActions(DeviceManager.getInstance().getActiveDevice(), IMPLEMENTATION_PACKAGE + "exercisesAndPlans.actions.ExercisesAndPlansActions")
    }

    /**
     * Gets Exercises and plans actions for current device
     * @return
     */
    static IStageActions getStageActions() {
        return (IStageActions) Actions.getCustomActions(DeviceManager.getInstance().getActiveDevice(), IMPLEMENTATION_PACKAGE + "stage.actions.StageActions")
    }

}