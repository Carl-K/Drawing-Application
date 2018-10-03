package model.shapes;

import java.awt.Point;

import model.ShapeColor;
import model.ShapeShadingType;

public abstract class AbstractShape implements IShape, Cloneable {
	
	private Point upperLeftHandCornerPoint;
	private int width;
	private int height;
	
	private ShapeColor primaryColor;
	private ShapeColor secondaryColor;
	
	private ShapeShadingType shapeShadingType;
	
	AbstractShape(Point upperLeftHandCornerPointIn, int widthIn, int heightIn, ShapeColor primaryColorIn, ShapeColor secondaryColorIn, ShapeShadingType shapeShadingTypeIn)
	{
		upperLeftHandCornerPoint = upperLeftHandCornerPointIn;
		width = widthIn;
		height = heightIn;
		
		primaryColor = primaryColorIn;
		secondaryColor = secondaryColorIn;
		
		shapeShadingType = shapeShadingTypeIn;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		AbstractShape s = (AbstractShape)super.clone();
		
		s.upperLeftHandCornerPoint = new Point((int)upperLeftHandCornerPoint.getX(), (int)upperLeftHandCornerPoint.getY());
		s.width = width;
		s.height = height;
		
		s.primaryColor = primaryColor;
		s.secondaryColor = secondaryColor;
		
		s.shapeShadingType = shapeShadingType;
		
		return s;
	}

	@Override
	public final Point getUpperLeftHandCornerPoint()
	{
		return upperLeftHandCornerPoint;
	}
	
	@Override
	public final void setUpperLeftHandCornerPoint(Point newPointIn)
	{
		upperLeftHandCornerPoint = newPointIn;
	}
	
	@Override
	public final int getWidth()
	{
		return width;
	}
	
	@Override
	public final int getHeight()
	{
		return height;
	}
	
	@Override
	public final ShapeColor getPrimaryColor()
	{
		return primaryColor;
	}
	
	@Override
	public final void setPrimaryColor(ShapeColor colorIn)
	{
		primaryColor = colorIn;
	}
	
	@Override
	public final ShapeColor getSecondaryColor()
	{
		return secondaryColor;
	}
	
	@Override
	public final void setSecondaryColor(ShapeColor colorIn)
	{
		secondaryColor = colorIn;
	}
	
	@Override
	public final ShapeShadingType getShapeShadingType()
	{
		return shapeShadingType;
	}
	
	@Override
	public final void setShadingType(ShapeShadingType shadingTypeIn)
	{
		shapeShadingType = shadingTypeIn;
	}
}
