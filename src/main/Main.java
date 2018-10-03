package main;

import model.shapemanager.ShapeCollectionSingleton;
import controller.IJPaintController;
import controller.JPaintController;
import controller.interaction.*;
import model.persistence.ApplicationState;
import view.graphicmanager.Drawer;
import view.graphicmanager.IShapeGraphicCollectionObservers;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;
import controller.interaction.MousePressAndReleaseEventReceiver;
import controller.shapegraphicmanager.IShapeCollectionObservers;
import controller.shapegraphicmanager.IShapeGraphicCollectionSubjects;
import controller.shapegraphicmanager.ShapeGraphicsHandler;
import controller.subscriptions.MousePressAndReleaseEventOnCanvasObserver;

public class Main {
    public static void main(String[] args) {

    		PaintCanvas paintCanvas = new PaintCanvas();
    		
    		PaintCanvasListener paintCanvasListener = new PaintCanvasListener();
        paintCanvas.addMouseListener(paintCanvasListener);
        
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
    		
    		MousePressAndReleaseEventOnCanvasObserver mousePressAndReleaseEventReceiver = new MousePressAndReleaseEventReceiver(appState);
    		paintCanvasListener.addMousePressAndReleaseEventOnCanvasObserver(mousePressAndReleaseEventReceiver);
    		
    		IShapeGraphicCollectionSubjects shapeGraphicsCollectionSubjects = ShapeGraphicsHandler.getInstance();
    		IShapeCollectionObservers shapeGraphicsCollectionObservers = ShapeGraphicsHandler.getInstance();
    		
    		ShapeCollectionSingleton.subscribeShapeAddedObserver(shapeGraphicsCollectionObservers);
    		ShapeCollectionSingleton.subscribeShapeUpdatedObserver(shapeGraphicsCollectionObservers);
    		ShapeCollectionSingleton.subscribeShapeRemovedObserver(shapeGraphicsCollectionObservers);
    		
    		IShapeGraphicCollectionObservers paintCanvasDrawer = new Drawer(paintCanvas);
    		
    		shapeGraphicsCollectionSubjects.addShapeGraphicCreatedObserver(paintCanvasDrawer);
    		shapeGraphicsCollectionSubjects.addShapeGraphicUpdatedObserver(paintCanvasDrawer);
    		shapeGraphicsCollectionSubjects.addShapeGraphicRemovedObserver(paintCanvasDrawer);
        
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
    }
}
