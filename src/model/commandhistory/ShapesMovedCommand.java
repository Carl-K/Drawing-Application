package model.commandhistory;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.shapemanager.ShapeCollectionSingleton;
import model.shapes.AbstractShape;

class ShapesMovedCommand implements IExecutable
{
	List<AbstractShape> shapes;
	ArrayList<Point> starts;
	ArrayList<Point> ends;
	
	ShapesMovedCommand(List<AbstractShape> shapesIn, Point startIn, Point endIn)
	{
		double widthChange = endIn.getX() - startIn.getX();
		double heightChange = endIn.getY() - startIn.getY();
		
		shapes = shapesIn;
		starts = new ArrayList<Point>(shapes.size());
		ends = new ArrayList<Point>(shapes.size());
		
		for (int i = 0; i < shapes.size(); i++)
		{
			AbstractShape s = shapes.get(i);
			Point p = new Point((int)(s.getUpperLeftHandCornerPoint().getX() - widthChange), (int)(s.getUpperLeftHandCornerPoint().getY() - heightChange));
			starts.add(p);
			ends.add(s.getUpperLeftHandCornerPoint());
		}
	}

	@Override
	public void undo()
	{
		for (int i = 0; i < shapes.size(); i++)
		{
			AbstractShape s = shapes.get(i);
			s.setUpperLeftHandCornerPoint(starts.get(i));
			ShapeCollectionSingleton.updated(s);
		}
	}

	@Override
	public void execute()
	{
		for (int i = 0; i < shapes.size(); i++)
		{
			AbstractShape s = shapes.get(i);
			s.setUpperLeftHandCornerPoint(ends.get(i));
			ShapeCollectionSingleton.updated(s);
		}
	}
}
