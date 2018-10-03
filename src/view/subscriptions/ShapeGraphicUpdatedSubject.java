package view.subscriptions;

import view.shape.AbstractShapeGraphic;

public interface ShapeGraphicUpdatedSubject {
	void addShapeGraphicUpdatedObserver(ShapeGraphicUpdatedObserver shapeGraphicUpdatedObserverIn);
	void removeShapeGraphicUpdatedObserver(ShapeGraphicUpdatedObserver shapeGraphicUpdatedObserverIn);
	void notifyShapeGraphicUpdated(AbstractShapeGraphic shapeGraphicIn);
}
