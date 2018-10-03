package model.commandhistory;

import java.awt.Point;
import java.util.List;

import model.ShapeColor;
import model.ShapeShadingType;
import model.shapes.AbstractShape;

public interface ICommandHandler
{
	public void addShape(AbstractShape shapeIn);
	public void removeShapes(List<AbstractShape> shapesIn);
	public void moveShapes(List<AbstractShape> shapesIn, Point startIn, Point endIn);
	public void updateShapesShapeShadingType(List<AbstractShape> shapesIn,
                             				List<ShapeShadingType> shadingTypeOldsIn);
	public void updateShapesPrimaryColor(List<AbstractShape> shapesIn,
										List<ShapeColor> primaryColorOldsIn);
	public void updateShapesSecondaryColor(List<AbstractShape> shapesIn,
										  List<ShapeColor> secondaryColorOldsIn);
	public void pastedShapes(List<AbstractShape> pastedIn);
}
