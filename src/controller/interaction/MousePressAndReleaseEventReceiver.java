package controller.interaction;

import java.awt.Point;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import model.shapemanager.ShapeCollectionSingleton;
import controller.subscriptions.MousePressAndReleaseEventOnCanvasObserver;
import model.interfaces.IApplicationState;
import model.selection.ISelected;
import model.selection.SelectedSingleton;
import model.shapes.AbstractShape;
import model.shapes.ShapeFactory;
import model.ShapeColor;
import model.ShapeShadingType;
import model.blocks.ShapeBlocks;
import model.commandhistory.CommandHandlerSingleton;

public class MousePressAndReleaseEventReceiver implements MousePressAndReleaseEventOnCanvasObserver {

	private final IApplicationState applicationState;
	
	public MousePressAndReleaseEventReceiver(IApplicationState applicationStateIn)
	{
		applicationState = applicationStateIn;
	}
	
	@Override
	public void receiveMouseEventOnCanvasMessage(Point startPointIn, Point endPointIn) {
		
		if (startPointIn == null || endPointIn == null)
		{
			return;
		}
		
		int smallerX = (startPointIn.x < endPointIn.x ? startPointIn.x : endPointIn.x);
		int smallerY = (startPointIn.y < endPointIn.y ? startPointIn.y : endPointIn.y);
		
		int largerX = (startPointIn.x >= endPointIn.x ? startPointIn.x : endPointIn.x);
		int largerY = (startPointIn.y >= endPointIn.y ? startPointIn.y : endPointIn.y);
		
		Point topLeftCorner = new Point(smallerX, smallerY);
		int width = largerX - smallerX;
		int height = largerY - smallerY;
		
		if (largerX == smallerX)
		{
			largerX += 1;
			width = 1;
		}
		if (largerY == smallerY)
		{
			largerY += 1;
			height = 1;
		}
		
		ShapeColor primaryColor = applicationState.getActivePrimaryColor();
		ShapeColor secondaryColor = applicationState.getActiveSecondaryColor();
		
		ShapeShadingType shapeShadingType = applicationState.getActiveShapeShadingType();
		
		ISelected selectedManager = SelectedSingleton.getInstance();

		switch (applicationState.getActiveStartAndEndPointMode())
		{
			case DRAW:
				
				AbstractShape shape = null;
				switch (applicationState.getActiveShapeType())
				{
					case TRIANGLE:
						shape = ShapeFactory.createTriangle(topLeftCorner, width, height, primaryColor, secondaryColor, shapeShadingType);
						break;
					case ELLIPSE:
						shape = ShapeFactory.createEllipse(topLeftCorner, width, height, primaryColor, secondaryColor, shapeShadingType);
						break;
					case RECTANGLE:
						shape = ShapeFactory.createRectangle(topLeftCorner, width, height, primaryColor, secondaryColor, shapeShadingType);
						break;
					default:
						throw new Error("MISSING SHAPE");
				}
				
				CommandHandlerSingleton.add(shape);
				
				break;
				
			case SELECT:
				
				Point bottomRightCorner = new Point(largerX, largerY);
				
				Predicate<? super AbstractShape> collisionPredicate = ShapeBlocks.collisionPredicate(topLeftCorner, bottomRightCorner);
				
				List<AbstractShape> shapesSelected = ShapeCollectionSingleton.select(collisionPredicate);
				selectedManager.setSelectedShapes(shapesSelected);
				
				break;
				
			case MOVE:
				
				Consumer<? super AbstractShape> consumer = ShapeBlocks.moveShape(startPointIn, endPointIn);
				
				selectedManager.operateOnSelection(consumer);
				List<AbstractShape> selectedShapes = SelectedSingleton.getInstance().getSelectedShapes();
				CommandHandlerSingleton.move(selectedShapes, startPointIn, endPointIn);
				
				break;
		}
		
	}

}
