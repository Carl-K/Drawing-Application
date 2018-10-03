package model.subscriptions;

import model.shapes.AbstractShape;

public interface ShapeAddedSubject {
	void addShapeAddedObserver(ShapeAddedObserver shapeAddedObserverIn);
	void removeShapeAddedObserver(ShapeAddedObserver shapeAddedObserverIn);
	void notifyShapeAdded(AbstractShape shapeIn);
}
