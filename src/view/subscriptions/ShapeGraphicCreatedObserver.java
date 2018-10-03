package view.subscriptions;

import view.shape.AbstractShapeGraphic;

public interface ShapeGraphicCreatedObserver {
	void receiveShapeGraphicCreatedMessage(AbstractShapeGraphic shapeGraphicIn);
}
