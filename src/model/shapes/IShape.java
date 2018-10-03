package model.shapes;

import java.awt.Point;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public interface IShape {
	
	public Point getUpperLeftHandCornerPoint();
	public void setUpperLeftHandCornerPoint(Point newPointIn);
	public int getWidth();
	public int getHeight();
	
	public ShapeColor getPrimaryColor();
	public void setPrimaryColor(ShapeColor colorIn);
	public ShapeColor getSecondaryColor();
	public void setSecondaryColor(ShapeColor colorIn);
	
	public ShapeType getShapeType();
	
	public ShapeShadingType getShapeShadingType();
	public void setShadingType(ShapeShadingType shadingTypeIn);
}
