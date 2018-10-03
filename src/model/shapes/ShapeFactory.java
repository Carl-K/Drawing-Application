package model.shapes;

import java.awt.Point;

import model.ShapeColor;
import model.ShapeShadingType;

public class ShapeFactory {
	
	public static AbstractShape createEllipse(Point upperLeftHandCornerPointIn, int widthIn, int heightIn, ShapeColor primaryColorIn, ShapeColor secondaryColorIn, ShapeShadingType shapeShadingTypeIn)
	{
		AbstractShape ellipse = new Ellipse(upperLeftHandCornerPointIn, widthIn, heightIn, primaryColorIn, secondaryColorIn, shapeShadingTypeIn);
		return ellipse;
	}

	public static AbstractShape createTriangle(Point upperLeftHandCornerPointIn, int widthIn, int heightIn, ShapeColor primaryColorIn, ShapeColor secondaryColorIn, ShapeShadingType shapeShadingTypeIn)
	{
		AbstractShape triangle = new Triangle(upperLeftHandCornerPointIn, widthIn, heightIn, primaryColorIn, secondaryColorIn, shapeShadingTypeIn);
		return triangle;
	}
	
	public static AbstractShape createRectangle(Point upperLeftHandCornerPointIn, int widthIn, int heightIn, ShapeColor primaryColorIn, ShapeColor secondaryColorIn, ShapeShadingType shapeShadingTypeIn)
	{
		AbstractShape rectangle = new Rectangle(upperLeftHandCornerPointIn, widthIn, heightIn, primaryColorIn, secondaryColorIn, shapeShadingTypeIn);
		return rectangle;
	}
}