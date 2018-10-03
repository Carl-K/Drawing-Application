package controller.subscriptions;

import java.awt.Point;

public interface MousePressAndReleaseEventOnCanvasObserver {
	void receiveMouseEventOnCanvasMessage(Point startPointIn, Point endPointIn);
}
