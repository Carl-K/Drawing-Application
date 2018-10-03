package view.shape;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import model.ShapeShadingType;
import model.ShapeType;

public class RectangleGraphic extends AbstractShapeGraphic {
	
	RectangleGraphic(Point upperLeftHandCornerPointIn, int widthIn, int heightIn, Color primaryColorIn, Color secondaryColorIn, ShapeShadingType shapeShadingTypeIn) {
		super(upperLeftHandCornerPointIn, widthIn, heightIn, primaryColorIn, secondaryColorIn, shapeShadingTypeIn);
	}

	@Override
	public Shape draw()
	{
		Point upperLeftHandCornerPoint = getUpperLeftHandCornerPoint();
		int width = getWidth();
		int height = getHeight();
		
		return new Rectangle2D.Float(upperLeftHandCornerPoint.x, upperLeftHandCornerPoint.y, width, height);
	}

	@Override
	public ShapeType getShapeType()
	{
		return ShapeType.RECTANGLE;
	}
}
