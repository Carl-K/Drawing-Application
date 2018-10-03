package model.clipboard;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.commandhistory.CommandHandlerSingleton;
import model.shapes.AbstractShape;

public class ClipboardSingleton implements IClipboard
{
	private List<AbstractShape> clipboardedShapes = new ArrayList<AbstractShape>();
	
	private static ClipboardSingleton clipboardSingleton = new ClipboardSingleton();
	
	private ClipboardSingleton()
	{
		
	}
	
	public static ClipboardSingleton getInstance()
	{
		return clipboardSingleton;
	}
	
	public void setClipboard(List<AbstractShape> shapesIn)
	{
		clipboardedShapes = new ArrayList<AbstractShape>();
		for (AbstractShape s : shapesIn)
		{
			AbstractShape copy = null;
			try
			{
				copy = (AbstractShape)s.clone();
			}
			catch (Exception e)
			{
				
			}
			
			Point p = copy.getUpperLeftHandCornerPoint();
			Point pNew = new Point((int)p.getX() + 20, (int)p.getY() + 20);
			copy.setUpperLeftHandCornerPoint(pNew);
			
			clipboardedShapes.add(copy);
		}
	}
	
	public void paste()
	{
		/*
		for (AbstractShape s : clipboardedShapes)
		{
			ShapeCollectionSingleton.add(s);
		}
		*/
		CommandHandlerSingleton.pasted(clipboardedShapes);
	}
}
