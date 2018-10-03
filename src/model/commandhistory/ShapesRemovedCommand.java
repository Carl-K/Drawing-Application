package model.commandhistory;

import java.util.List;

import model.shapemanager.ShapeCollectionSingleton;
import model.shapes.AbstractShape;

class ShapesRemovedCommand implements IExecutable
{
	List<AbstractShape> shapes;
	
	ShapesRemovedCommand(List<AbstractShape> shapesIn)
	{
		shapes = shapesIn;
	}

	@Override
	public void undo()
	{
		for (AbstractShape shape : shapes)
		{
			ShapeCollectionSingleton.add(shape);
		}
	}

	@Override
	public void execute()
	{
		for (AbstractShape shape : shapes)
		{
			ShapeCollectionSingleton.remove(shape);
		}
	}
}
