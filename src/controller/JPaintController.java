package controller;

import model.clipboard.ClipboardSingleton;
import model.clipboard.IClipboard;
import model.commandhistory.CommandHistorySingleton;
import model.interfaces.IApplicationState;
import model.selection.ISelected;
import model.selection.ISelectionCallbacks;
import model.selection.SelectedSingleton;
import model.selection.SelectionCallbacksSingleton;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    
    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
    	
    		ISelectionCallbacks selectionUpdater = SelectionCallbacksSingleton.getInstance(applicationState);
    		ISelected selectedManager = SelectedSingleton.getInstance();
    		IClipboard clipboard = ClipboardSingleton.getInstance();
    
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> selectionUpdater.updatePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> selectionUpdater.updateSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> selectionUpdater.updateShapeShadingType());
        
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        
        uiModule.addEvent(EventName.UNDO, () -> CommandHistorySingleton.undo());
        uiModule.addEvent(EventName.REDO, () -> CommandHistorySingleton.redo());
        uiModule.addEvent(EventName.COPY, () -> selectedManager.copySelected());
        uiModule.addEvent(EventName.PASTE, () -> clipboard.paste());
        uiModule.addEvent(EventName.DELETE, () -> selectedManager.deleteSelected());
    }
}
