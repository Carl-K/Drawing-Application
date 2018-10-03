package model.shapemanager;

import java.util.List;
import java.util.function.Predicate;

import model.shapes.AbstractShape;

public interface IShapeCollectionOperations
{
	public void addShape(AbstractShape shapeIn);
	public void removeShape(AbstractShape shapeIn);
	public void shapeUpdated(AbstractShape shapeIn);
	public List<AbstractShape> selectShapes(Predicate<? super AbstractShape> predicateIn);
}
