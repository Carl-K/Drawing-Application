package view.subscriptions;

import view.shape.AbstractShapeGraphic;

public interface ShapeGraphicUpdatedObserver {
	void receiveShapeGraphicUpdatedMessage(AbstractShapeGraphic shapeIn);
}
