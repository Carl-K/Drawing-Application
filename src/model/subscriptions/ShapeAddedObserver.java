package model.subscriptions;

import model.shapes.AbstractShape;

public interface ShapeAddedObserver {
	void receiveShapeAddedMessage(AbstractShape shapeIn);
}