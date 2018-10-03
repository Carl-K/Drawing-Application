package model.subscriptions;

import model.shapes.AbstractShape;

public interface ShapeUpdatedObserver {
	void receiveShapeUpdatedMessage(AbstractShape shapeIn);
}
