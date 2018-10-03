package view.shape;

import java.awt.Color;
import java.awt.Point;

import model.ShapeShadingType;
import model.ShapeType;

public interface IShapeGraphic {
	public Point getUpperLeftHandCornerPoint();
	public void setUpperLeftHandCornerPoint(Point newPointIn);
	public int getWidth();
	public int getHeight();
	
	public Color getPrimaryColor();
	public void setPrimaryColor(Color colorIn);
	public Color getSecondaryColor();
	public void setSecondaryColor(Color colorIn);
	
	public ShapeType getShapeType();
	
	public ShapeShadingType getShapeShadingType();
	public void setShadingType(ShapeShadingType shadingTypeIn);
}
