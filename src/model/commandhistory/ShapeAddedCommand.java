package model.commandhistory;

import model.shapemanager.ShapeCollectionSingleton;
import model.shapes.AbstractShape;

class ShapeAddedCommand implements IExecutable
{
	AbstractShape shape;
	
	ShapeAddedCommand(AbstractShape shapeIn)
	{
		shape = shapeIn;
	}
	
	@Override
	public void undo()
	{
		ShapeCollectionSingleton.remove(shape);
	}

	@Override
	public void execute()
	{
		ShapeCollectionSingleton.add(shape);
	}

}
