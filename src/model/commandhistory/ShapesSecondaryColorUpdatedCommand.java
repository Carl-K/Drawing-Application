package model.commandhistory;

import java.util.List;

import model.ShapeColor;
import model.shapemanager.ShapeCollectionSingleton;
import model.shapes.AbstractShape;

class ShapesSecondaryColorUpdatedCommand implements IExecutable {
	
	List<AbstractShape> shapes;
	
	List<ShapeColor> secondaryColorOlds;
	
	ShapeColor secondaryColorNew;
	
	ShapesSecondaryColorUpdatedCommand(List<AbstractShape> shapesIn,
			                    List<ShapeColor> secondaryColorOldsIn)
	{
		shapes = shapesIn;
		
		secondaryColorOlds = secondaryColorOldsIn;
		
		if (shapes.size() > 0)
		{
			AbstractShape s = shapes.get(0);
			
			secondaryColorNew = s.getSecondaryColor();
		}
	}

	@Override
	public void undo()
	{
		for (int i = 0; i < shapes.size(); i++)
		{
			AbstractShape s = shapes.get(i);
			
			s.setSecondaryColor(secondaryColorOlds.get(i));
			
			ShapeCollectionSingleton.updated(s);
		}
	}

	@Override
	public void execute()
	{
		for (int i = 0; i < shapes.size(); i++)
		{
			AbstractShape s = shapes.get(i);
			
			s.setSecondaryColor(secondaryColorNew);
			
			ShapeCollectionSingleton.updated(s);
		}
	}

}
