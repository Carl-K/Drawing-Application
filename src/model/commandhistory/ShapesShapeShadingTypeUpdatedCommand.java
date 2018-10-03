package model.commandhistory;

import java.util.List;

import model.ShapeShadingType;
import model.shapemanager.ShapeCollectionSingleton;
import model.shapes.AbstractShape;

class ShapesShapeShadingTypeUpdatedCommand implements IExecutable {
	
	List<AbstractShape> shapes;
	
	List<ShapeShadingType> shadingTypeOlds;
	
	ShapeShadingType shadingTypeNew;
	
	ShapesShapeShadingTypeUpdatedCommand(List<AbstractShape> shapesIn,
			                    List<ShapeShadingType> shadingTypeOldsIn)
	{
		shapes = shapesIn;
		
		shadingTypeOlds = shadingTypeOldsIn;
		
		if (shapes.size() > 0)
		{
			AbstractShape s = shapes.get(0);
			
			shadingTypeNew = s.getShapeShadingType();
		}
	}

	@Override
	public void undo()
	{
		for (int i = 0; i < shapes.size(); i++)
		{
			AbstractShape s = shapes.get(i);
			
			s.setShadingType(shadingTypeOlds.get(i));
			
			ShapeCollectionSingleton.updated(s);
		}
	}

	@Override
	public void execute()
	{
		for (int i = 0; i < shapes.size(); i++)
		{
			AbstractShape s = shapes.get(i);
			
			s.setShadingType(shadingTypeNew);
			
			ShapeCollectionSingleton.updated(s);
		}
	}

}
