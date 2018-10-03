package controller.shapegraphicmanager;

import java.util.ArrayList;

import view.shape.AbstractShapeGraphic;
import view.shape.ShapeGraphicFactory;
import view.subscriptions.ShapeGraphicCreatedObserver;
import view.subscriptions.ShapeGraphicRemovedObserver;
import view.subscriptions.ShapeGraphicUpdatedObserver;
import model.shapes.AbstractShape;
import model.color.ColorSet;
import model.color.IAWTColor;
import model.miscellaneous.Pair;

public class ShapeGraphicsHandler implements IShapeGraphicCollectionSubjects, IShapeCollectionObservers {
	
	private ArrayList<Pair<AbstractShape, AbstractShapeGraphic>> shapeGraphics;
	
	private ArrayList<ShapeGraphicCreatedObserver> shapeGraphicCreatedObservers;
	private ArrayList<ShapeGraphicUpdatedObserver> shapeGraphicUpdatedObservers;
	private ArrayList<ShapeGraphicRemovedObserver> shapeGraphicRemovedObservers;
	
	private static ShapeGraphicsHandler shapeGraphicsHandlerSingleton;
	
	private ShapeGraphicsHandler()
	{
		shapeGraphics = new ArrayList<Pair<AbstractShape, AbstractShapeGraphic>>();
		shapeGraphicCreatedObservers = new ArrayList<ShapeGraphicCreatedObserver>();
		shapeGraphicUpdatedObservers = new ArrayList<ShapeGraphicUpdatedObserver>();
		shapeGraphicRemovedObservers = new ArrayList<ShapeGraphicRemovedObserver>();
	}
	
	public static ShapeGraphicsHandler getInstance()
	{
		if (shapeGraphicsHandlerSingleton == null)
		{
			shapeGraphicsHandlerSingleton = new ShapeGraphicsHandler();
		}
		
		return shapeGraphicsHandlerSingleton;
	}
	
	//-----------------------------------
    //-----------------------------------
  	//ShapeGraphicCreatedSubject METHODS
  	//-----------------------------------
    //-----------------------------------

	@Override
	public void addShapeGraphicCreatedObserver(ShapeGraphicCreatedObserver shapeGraphicCreatedObserverIn) {
		shapeGraphicCreatedObservers.add(shapeGraphicCreatedObserverIn);
	}

	@Override
	public void removeShapeGraphicCreatedObserver(ShapeGraphicCreatedObserver shapeGraphicCreatedObserverIn) {
		shapeGraphicCreatedObservers.add(shapeGraphicCreatedObserverIn);
	}

	@Override
	public void notifyShapeGraphicCreated(AbstractShapeGraphic shapeGraphicIn)
	{
		for (ShapeGraphicCreatedObserver observer : shapeGraphicCreatedObservers)
		{
			observer.receiveShapeGraphicCreatedMessage(shapeGraphicIn);
		}
	}
	
	//-----------------------------------
    //-----------------------------------
  	//ShapeGraphicUpdatedSubject METHODS
  	//-----------------------------------
    //-----------------------------------

	@Override
	public void addShapeGraphicUpdatedObserver(ShapeGraphicUpdatedObserver shapeGraphicUpdatedObserverIn) {
		shapeGraphicUpdatedObservers.add(shapeGraphicUpdatedObserverIn);
	}

	@Override
	public void removeShapeGraphicUpdatedObserver(ShapeGraphicUpdatedObserver shapeGraphicUpdatedObserverIn) {
		shapeGraphicUpdatedObservers.remove(shapeGraphicUpdatedObserverIn);
	}

	@Override
	public void notifyShapeGraphicUpdated(AbstractShapeGraphic shapeGraphicIn) {
		for (ShapeGraphicUpdatedObserver o : shapeGraphicUpdatedObservers)
		{
			o.receiveShapeGraphicUpdatedMessage(shapeGraphicIn);
		}
	}
	
	//-----------------------------------
    //-----------------------------------
  	//ShapeGraphicRemovedObserver METHODS
  	//-----------------------------------
    //-----------------------------------

	@Override
	public void receiveShapeRemovedMessage(AbstractShape shapeIn) 
	{
		for (Pair<AbstractShape, AbstractShapeGraphic> p : shapeGraphics)
		{
			if (p.getValue1() == shapeIn)
			{
				int index = shapeGraphics.indexOf(p);
				shapeGraphics.remove(index);
				notifyShapeGraphicRemoved(p.getValue2());
				
				break;
			}
		}
	}
	
	//-----------------------------------
    //-----------------------------------
  	//ShapeAddedObserver METHODS
  	//-----------------------------------
    //-----------------------------------

	@Override
	public void receiveShapeAddedMessage(AbstractShape shapeIn)
	{
		AbstractShapeGraphic shapeGraphic = null;
		IAWTColor primaryColor = ColorSet.getColor(shapeIn.getPrimaryColor());
		IAWTColor secondaryColor = ColorSet.getColor(shapeIn.getSecondaryColor());
		
		switch (shapeIn.getShapeType())
		{
		case TRIANGLE:
			shapeGraphic = ShapeGraphicFactory.createTriangle(shapeIn.getUpperLeftHandCornerPoint(), shapeIn.getWidth(), shapeIn.getHeight(), primaryColor.getAWTColor(), secondaryColor.getAWTColor(), shapeIn.getShapeShadingType());
			break;
		case ELLIPSE:
			shapeGraphic = ShapeGraphicFactory.createEllipse(shapeIn.getUpperLeftHandCornerPoint(), shapeIn.getWidth(), shapeIn.getHeight(), primaryColor.getAWTColor(), secondaryColor.getAWTColor(), shapeIn.getShapeShadingType());
			break;
		case RECTANGLE:
			shapeGraphic = ShapeGraphicFactory.createRectangle(shapeIn.getUpperLeftHandCornerPoint(), shapeIn.getWidth(), shapeIn.getHeight(), primaryColor.getAWTColor(), secondaryColor.getAWTColor(), shapeIn.getShapeShadingType());
			break;
		default:
			throw new Error("MISSING SHAPE GRAPHIC");
		}
		
		Pair<AbstractShape, AbstractShapeGraphic> shapePair = new Pair<AbstractShape, AbstractShapeGraphic>(shapeIn, shapeGraphic);
		
		shapeGraphics.add(shapePair);
		
		notifyShapeGraphicCreated(shapeGraphic);
	}
	
	//-----------------------------------
    //-----------------------------------
  	//ShapeUpdatedObserver METHODS
  	//-----------------------------------
    //-----------------------------------
	
	@Override
	public void receiveShapeUpdatedMessage(AbstractShape shapeIn)
	{
		for (Pair<AbstractShape, AbstractShapeGraphic> p : shapeGraphics)
		{
			if (p.getValue1() == shapeIn)
			{
				IAWTColor primaryColor = ColorSet.getColor(shapeIn.getPrimaryColor());
				IAWTColor secondaryColor = ColorSet.getColor(shapeIn.getSecondaryColor());
				
				p.getValue2().setUpperLeftHandCornerPoint(shapeIn.getUpperLeftHandCornerPoint());
				p.getValue2().setShadingType(shapeIn.getShapeShadingType());
				p.getValue2().setPrimaryColor(primaryColor.getAWTColor());
				p.getValue2().setSecondaryColor(secondaryColor.getAWTColor());
				
				notifyShapeGraphicUpdated(p.getValue2());
				break;
			}
		}
	}
	
	//-----------------------------------
    //-----------------------------------
  	//ShapeGraphicRemovedSubject METHODS
  	//-----------------------------------
    //-----------------------------------

	@Override
	public void addShapeGraphicRemovedObserver(ShapeGraphicRemovedObserver shapeGraphicRemovedObserverIn) {
		shapeGraphicRemovedObservers.add(shapeGraphicRemovedObserverIn);
	}

	@Override
	public void removeShapeGraphicRemovedObserver(ShapeGraphicRemovedObserver shapeGraphicRemovedObserverIn) {
		shapeGraphicRemovedObservers.remove(shapeGraphicRemovedObserverIn);
	}

	@Override
	public void notifyShapeGraphicRemoved(AbstractShapeGraphic shapeGraphicIn) {
		for (ShapeGraphicRemovedObserver o : shapeGraphicRemovedObservers)
		{
			o.receiveShapeGraphicRemovedMessage(shapeGraphicIn);
		}
	}
}
