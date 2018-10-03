package view.shape;

import java.awt.Color;
import java.awt.Point;

import model.ShapeShadingType;
import view.shapetypedecorator.IShadingTypeDecorator;

public abstract class AbstractShapeGraphic implements IShapeGraphic, IShadingTypeDecorator {
	
	private Point upperLeftHandCornerPoint;
	private int width;
	private int height;
	
	private Color primaryColor;
	private Color secondaryColor;
	
	private ShapeShadingType shapeShadingType;
	
	public AbstractShapeGraphic(Point upperLeftHandCornerPointIn, int widthIn, int heightIn, Color primaryColorIn, Color secondaryColorIn, ShapeShadingType shapeShadingTypeIn)
	{
		upperLeftHandCornerPoint = upperLeftHandCornerPointIn;
		width = widthIn;
		height = heightIn;
		
		primaryColor = primaryColorIn;
		secondaryColor = secondaryColorIn;
		
		shapeShadingType = shapeShadingTypeIn;
	}

	@Override
	public final Point getUpperLeftHandCornerPoint()
	{
		return upperLeftHandCornerPoint;
	}
	
	@Override
	public void setUpperLeftHandCornerPoint(Point newPointIn)
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
	public final Color getPrimaryColor()
	{
		return primaryColor;
	}
	
	@Override
	public final void setPrimaryColor(Color colorIn)
	{
		primaryColor = colorIn;
	}
	
	@Override
	public final Color getSecondaryColor()
	{
		return secondaryColor;
	}
	
	@Override
	public final void setSecondaryColor(Color colorIn)
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
