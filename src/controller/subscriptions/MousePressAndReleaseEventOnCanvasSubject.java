package controller.subscriptions;

import java.awt.Point;

public interface MousePressAndReleaseEventOnCanvasSubject {
	void addMousePressAndReleaseEventOnCanvasObserver(MousePressAndReleaseEventOnCanvasObserver observerIn);
	void removeMousePressAndReleaseEventOnCanvasObserver(MousePressAndReleaseEventOnCanvasObserver observerIn);
	
	void notify(Point startPointIn, Point endPointIn);
}
