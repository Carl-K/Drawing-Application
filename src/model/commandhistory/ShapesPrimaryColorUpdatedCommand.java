package model.commandhistory;

import java.util.List;

import model.ShapeColor;
import model.shapemanager.ShapeCollectionSingleton;
import model.shapes.AbstractShape;

class ShapesPrimaryColorUpdatedCommand implements IExecutable {
	
	List<AbstractShape> shapes;
	
	List<ShapeColor> primaryColorOlds;
	
	ShapeColor primaryColorNew;
	
	ShapesPrimaryColorUpdatedCommand(List<AbstractShape> shapesIn,
			                    List<ShapeColor> primaryColorOldsIn)
	{
		shapes = shapesIn;
		
		primaryColorOlds = primaryColorOldsIn;
		
		if (shapes.size() > 0)
		{
			AbstractShape s = shapes.get(0);
			
			primaryColorNew = s.getPrimaryColor();
		}
	}

	@Override
	public void undo()
	{
		for (int i = 0; i < shapes.size(); i++)
		{
			AbstractShape s = shapes.get(i);
			
			s.setPrimaryColor(primaryColorOlds.get(i));
			
			ShapeCollectionSingleton.updated(s);
		}
	}

	@Override
	public void execute()
	{
		for (int i = 0; i < shapes.size(); i++)
		{
			AbstractShape s = shapes.get(i);
			
			s.setPrimaryColor(primaryColorNew);
			
			ShapeCollectionSingleton.updated(s);
		}
	}

}
