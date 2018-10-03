package view.shape;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import model.ShapeShadingType;
import model.ShapeType;

public class EllipseGraphic extends AbstractShapeGraphic
{

	EllipseGraphic(Point upperLeftHandCornerPointIn, int widthIn, int heightIn, Color primaryColorIn, Color secondaryColorIn, ShapeShadingType shapeShadingTypeIn) {
		super(upperLeftHandCornerPointIn, widthIn, heightIn, primaryColorIn, secondaryColorIn, shapeShadingTypeIn);
	}

	@Override
	public Shape draw()
	{
		Point upperLeftHandCornerPoint = getUpperLeftHandCornerPoint();
		int width = getWidth();
		int height = getHeight();
		
		return new Ellipse2D.Float(upperLeftHandCornerPoint.x, upperLeftHandCornerPoint.y, width, height);
	}

	@Override
	public ShapeType getShapeType()
	{
		return ShapeType.ELLIPSE;
	}
}
