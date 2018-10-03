package view.subscriptions;

import view.shape.AbstractShapeGraphic;

public interface ShapeGraphicRemovedSubject {
	void addShapeGraphicRemovedObserver(ShapeGraphicRemovedObserver shapeGraphicRemovedObserverIn);
	void removeShapeGraphicRemovedObserver(ShapeGraphicRemovedObserver shapeGraphicRemovedObserverIn);
	void notifyShapeGraphicRemoved(AbstractShapeGraphic shapeGraphicIn);
}
