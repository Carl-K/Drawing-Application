package controller.interaction;

import java.awt.Point;
import java.util.ArrayList;
import controller.subscriptions.MousePressAndReleaseEventOnCanvasObserver;
import controller.subscriptions.MousePressAndReleaseEventOnCanvasSubject;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaintCanvasListener extends MouseAdapter implements MousePressAndReleaseEventOnCanvasSubject {

	private Point startPoint;
	private Point endPoint;
	
	private ArrayList<MousePressAndReleaseEventOnCanvasObserver> mousePressAndReleaseEventOnCanvasObservers;
	
	//-----------------------------------
    //-----------------------------------
  	//MouseListener METHODS
  	//-----------------------------------
    //-----------------------------------
	
	public PaintCanvasListener()
	{
		mousePressAndReleaseEventOnCanvasObservers = new ArrayList<MousePressAndReleaseEventOnCanvasObserver>();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		startPoint = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		endPoint = e.getPoint();
		
		notify(startPoint, endPoint);
	}
	
	//-----------------------------------
	//-----------------------------------
	//MouseEventOnCanvasSubject METHODS
	//-----------------------------------
	//-----------------------------------

	@Override
	public void addMousePressAndReleaseEventOnCanvasObserver(MousePressAndReleaseEventOnCanvasObserver observerIn)
	{
		mousePressAndReleaseEventOnCanvasObservers.add(observerIn);
	}

	@Override
	public void removeMousePressAndReleaseEventOnCanvasObserver(MousePressAndReleaseEventOnCanvasObserver observerIn)
	{
		mousePressAndReleaseEventOnCanvasObservers.remove(observerIn);
	}

	@Override
	public void notify(Point startPointIn, Point endPointIn)
	{
		for (MousePressAndReleaseEventOnCanvasObserver observer : mousePressAndReleaseEventOnCanvasObservers)
		{
			observer.receiveMouseEventOnCanvasMessage(startPointIn, endPointIn);
		}
	}
}
