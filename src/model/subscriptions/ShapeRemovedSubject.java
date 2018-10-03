package model.subscriptions;

import model.shapes.AbstractShape;

public interface ShapeRemovedSubject {
	void addShapeRemovedObserver(ShapeRemovedObserver shapeAddedObserverIn);
	void removeShapeRemovedObserver(ShapeRemovedObserver shapeAddedObserverIn);
	void notifyShapeRemoved(AbstractShape shapeIn);
}
