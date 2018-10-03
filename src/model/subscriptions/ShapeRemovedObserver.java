package model.subscriptions;

import model.shapes.AbstractShape;

public interface ShapeRemovedObserver {
	void receiveShapeRemovedMessage(AbstractShape shapeIn);
}