package model.shapes;

import java.awt.Point;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

class Triangle extends AbstractShape {
	
	Triangle(Point upperLeftHandCornerPointIn, int widthIn, int heightIn, ShapeColor primaryColorIn, ShapeColor secondaryColorIn, ShapeShadingType shapeShadingTypeIn)
	{
		super(upperLeftHandCornerPointIn, widthIn, heightIn, primaryColorIn, secondaryColorIn, shapeShadingTypeIn);
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		AbstractShape s = (AbstractShape)super.clone();
		
		return s;
	}
	
	@Override
	public final ShapeType getShapeType()
	{
		return ShapeType.TRIANGLE;
	}
}
