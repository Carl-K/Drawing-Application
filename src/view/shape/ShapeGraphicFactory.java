package view.shape;

import java.awt.Color;
import java.awt.Point;

import model.ShapeShadingType;

public class ShapeGraphicFactory {

	public static AbstractShapeGraphic createEllipse(Point upperLeftHandCornerPointIn, int widthIn, int heightIn, Color primaryColorIn, Color secondaryColorIn, ShapeShadingType shapeShadingTypeIn)
	{
		AbstractShapeGraphic ellipseGraphic = new EllipseGraphic(upperLeftHandCornerPointIn, widthIn, heightIn, primaryColorIn, secondaryColorIn, shapeShadingTypeIn);
		return ellipseGraphic;
	}

	public static AbstractShapeGraphic createTriangle(Point upperLeftHandCornerPointIn, int widthIn, int heightIn, Color primaryColorIn, Color secondaryColorIn, ShapeShadingType shapeShadingTypeIn)
	{
		AbstractShapeGraphic triangleGraphic = new TriangleGraphic(upperLeftHandCornerPointIn, widthIn, heightIn, primaryColorIn, secondaryColorIn, shapeShadingTypeIn);
		return triangleGraphic;
	}
	
	public static AbstractShapeGraphic createRectangle(Point upperLeftHandCornerPointIn, int widthIn, int heightIn, Color primaryColorIn, Color secondaryColorIn, ShapeShadingType shapeShadingTypeIn)
	{
		AbstractShapeGraphic rectangleGraphic = new RectangleGraphic(upperLeftHandCornerPointIn, widthIn, heightIn, primaryColorIn, secondaryColorIn, shapeShadingTypeIn);
		return rectangleGraphic;
	}
}
