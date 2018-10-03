package view.subscriptions;

import view.shape.AbstractShapeGraphic;

public interface ShapeGraphicCreatedSubject {
	void addShapeGraphicCreatedObserver(ShapeGraphicCreatedObserver shapeGraphicCreatedObserverIn);
	void removeShapeGraphicCreatedObserver(ShapeGraphicCreatedObserver shapeGraphicCreatedObserverIn);
	void notifyShapeGraphicCreated(AbstractShapeGraphic shapeGraphicIn);
}
