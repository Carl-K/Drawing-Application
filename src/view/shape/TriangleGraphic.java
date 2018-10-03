package view.shape;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;

import model.ShapeShadingType;
import model.ShapeType;

public class TriangleGraphic extends AbstractShapeGraphic {

	TriangleGraphic(Point upperLeftHandCornerPointIn, int widthIn, int heightIn, Color primaryColorIn, Color secondaryColorIn, ShapeShadingType shapeShadingTypeIn)
	{
		super(upperLeftHandCornerPointIn, widthIn, heightIn, primaryColorIn, secondaryColorIn, shapeShadingTypeIn);
	}

	@Override
	public Shape draw()
	{
		Point upperLeftHandCornerPoint = getUpperLeftHandCornerPoint();
		int width = getWidth();
		int height = getHeight();
		
		int[] arrX = new int[]{
		  	upperLeftHandCornerPoint.x,
		  	upperLeftHandCornerPoint.x + (width / 2),
		  	upperLeftHandCornerPoint.x + width
		 };

		int[] arrY = new int[]{
	  	  	 upperLeftHandCornerPoint.y + height,
	  	  	 upperLeftHandCornerPoint.y,
	  	  	 upperLeftHandCornerPoint.y + height
	 	};

		return new Polygon(arrX, arrY, 3);
	}

	@Override
	public ShapeType getShapeType()
	{
		return ShapeType.TRIANGLE;
	}
}
