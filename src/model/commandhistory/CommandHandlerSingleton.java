package model.commandhistory;

import java.awt.Point;
import java.util.List;

import model.ShapeColor;
import model.ShapeShadingType;
import model.shapes.AbstractShape;

public class CommandHandlerSingleton implements ICommandHandler {
	
	private static CommandHandlerSingleton commandHandlerSingleton = new CommandHandlerSingleton();
	
	private CommandHandlerSingleton()
	{
		
	}
	
	public static void add(AbstractShape shapeIn)
	{
		commandHandlerSingleton.addShape(shapeIn);
	}

	public void addShape(AbstractShape shapeIn)
	{
		ShapeAddedCommand command = new ShapeAddedCommand(shapeIn);
		command.execute();
		CommandHistorySingleton.add(command);
	}
	
	public static void remove(List<AbstractShape> shapesIn)
	{
		commandHandlerSingleton.removeShapes(shapesIn);
	}

	public void removeShapes(List<AbstractShape> shapesIn)
	{
		ShapesRemovedCommand command = new ShapesRemovedCommand(shapesIn);
		command.execute();
		CommandHistorySingleton.add(command);
	}
	
	public static void move(List<AbstractShape> shapesIn, Point startIn, Point endIn)
	{
		commandHandlerSingleton.moveShapes(shapesIn, startIn, endIn);
	}
	
	public void moveShapes(List<AbstractShape> shapesIn, Point startIn, Point endIn)
	{
		ShapesMovedCommand command = new ShapesMovedCommand(shapesIn, startIn, endIn);
		command.execute();
		CommandHistorySingleton.add(command);
	}

	public static void updateShapeShadingType(List<AbstractShape> shapesIn,
				List<ShapeShadingType> shadingTypeOldsIn)
	{
		commandHandlerSingleton.updateShapesShapeShadingType(shapesIn, shadingTypeOldsIn);
	}
	
	public void updateShapesShapeShadingType(List<AbstractShape> shapesIn,
                             				List<ShapeShadingType> shadingTypeOldsIn)
	{
		ShapesShapeShadingTypeUpdatedCommand command = new ShapesShapeShadingTypeUpdatedCommand(shapesIn,
			                                                    shadingTypeOldsIn);
		command.execute();
		CommandHistorySingleton.add(command);
	}
	
	public static void updatePrimaryColor(List<AbstractShape> shapesIn,
			List<ShapeColor> primaryColorOldsIn)
	{
		commandHandlerSingleton.updateShapesPrimaryColor(shapesIn, primaryColorOldsIn);
	}
	
	public void updateShapesPrimaryColor(List<AbstractShape> shapesIn,
										List<ShapeColor> primaryColorOldsIn)
	{
		ShapesPrimaryColorUpdatedCommand command = new ShapesPrimaryColorUpdatedCommand(shapesIn,
                                primaryColorOldsIn);
		command.execute();
		CommandHistorySingleton.add(command);
	}
	
	public static void updateSecondaryColor(List<AbstractShape> shapesIn,
			  List<ShapeColor> secondaryColorOldsIn)
	{
		commandHandlerSingleton.updateShapesSecondaryColor(shapesIn, secondaryColorOldsIn);
	}
	
	public void updateShapesSecondaryColor(List<AbstractShape> shapesIn,
										  List<ShapeColor> secondaryColorOldsIn)
	{
		ShapesSecondaryColorUpdatedCommand command = new ShapesSecondaryColorUpdatedCommand(shapesIn,
                                secondaryColorOldsIn);
		command.execute();
		CommandHistorySingleton.add(command);
	}
	
	public static void pasted(List<AbstractShape> pastedIn)
	{
		commandHandlerSingleton.pastedShapes(pastedIn);
	}
	
	public void pastedShapes(List<AbstractShape> pastedIn)
	{
		PasteCommand command = new PasteCommand(pastedIn);
		command.execute();
		CommandHistorySingleton.add(command);
	}
}