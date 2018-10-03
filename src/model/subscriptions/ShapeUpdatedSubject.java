package model.subscriptions;

import model.shapes.AbstractShape;

public interface ShapeUpdatedSubject {
	void addShapeUpdatedObserver(ShapeUpdatedObserver shapeEditedObserverIn);
	void removeShapeUpdatedObserver(ShapeUpdatedObserver shapeEditedObserverIn);
	void notifyShapeUpdated(AbstractShape shapeIn);
}
