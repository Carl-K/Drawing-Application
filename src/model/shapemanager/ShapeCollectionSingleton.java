package model.shapemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.shapes.AbstractShape;
import model.subscriptions.ShapeAddedObserver;
import model.subscriptions.ShapeRemovedObserver;
import model.subscriptions.ShapeUpdatedObserver;

public class ShapeCollectionSingleton implements IShapeCollectionOperations, IShapeCollectionSubjects {
	
	private ArrayList<AbstractShape> shapes = new ArrayList<AbstractShape>();
	
	private ArrayList<ShapeAddedObserver> shapeAddedObservers = new ArrayList<ShapeAddedObserver>();
	private ArrayList<ShapeRemovedObserver> shapeRemovedObservers = new ArrayList<ShapeRemovedObserver>();
	private ArrayList<ShapeUpdatedObserver> shapeEditedObservers = new ArrayList<ShapeUpdatedObserver>();
	
	private static ShapeCollectionSingleton shapeCollectionInstance = new ShapeCollectionSingleton();
	
	private ShapeCollectionSingleton()
	{
		
	}
	
	public static void add(AbstractShape shapeIn)
	{
		shapeCollectionInstance.addShape(shapeIn);
	}

	public void addShape(AbstractShape shapeIn)
	{
		shapes.add(shapeIn);
		
		notifyShapeAdded(shapeIn);
	}
	
	public static void remove(AbstractShape shapeIn)
	{
		shapeCollectionInstance.removeShape(shapeIn);
	}
	
	public void removeShape(AbstractShape shapeIn)
	{
		shapes.remove(shapeIn);
		
		notifyShapeRemoved(shapeIn);
	}
	
	public static void updated(AbstractShape shapeIn)
	{
		shapeCollectionInstance.shapeUpdated(shapeIn);
	}
	
	public void shapeUpdated(AbstractShape shapeIn)
	{
		notifyShapeUpdated(shapeIn);
	}
	
	public static List<AbstractShape> select(Predicate<? super AbstractShape> predicateIn)
	{
		return shapeCollectionInstance.selectShapes(predicateIn);
	}
	
	public List<AbstractShape> selectShapes(Predicate<? super AbstractShape> predicateIn)
	{
		return shapes.stream().filter(predicateIn).collect(Collectors.toList());
	}
	
	//-----------------------------------
	//-----------------------------------
	//ShapeAddedSubject METHODS
	//-----------------------------------
	//-----------------------------------

	public static void subscribeShapeAddedObserver(ShapeAddedObserver shapeAddedObserverIn)
	{
		shapeCollectionInstance.addShapeAddedObserver(shapeAddedObserverIn);
	}

	public static void unsubscribeShapeAddedObserver(ShapeAddedObserver shapeAddedObserverIn)
	{
		shapeCollectionInstance.removeShapeAddedObserver(shapeAddedObserverIn);
	}
	
	@Override
	public void addShapeAddedObserver(ShapeAddedObserver shapeAddedObserverIn)
	{
		shapeAddedObservers.add(shapeAddedObserverIn);
	}

	@Override
	public void removeShapeAddedObserver(ShapeAddedObserver shapeAddedObserverIn)
	{
		shapeAddedObservers.remove(shapeAddedObserverIn);
	}

	@Override
	public void notifyShapeAdded(AbstractShape shapeIn)
	{
		for (ShapeAddedObserver observer : shapeAddedObservers)
		{
			observer.receiveShapeAddedMessage(shapeIn);
		}
	}
	
	//-----------------------------------
	//-----------------------------------
	//ShapeRemovedSubject METHODS
	//-----------------------------------
	//-----------------------------------

	public static void subscribeShapeRemovedObserver(ShapeRemovedObserver shapeRemovedObserverIn)
	{
		shapeCollectionInstance.addShapeRemovedObserver(shapeRemovedObserverIn);
	}

	public static void unsubscribeShapeRemovedObserver(ShapeRemovedObserver shapeRemovedObserverIn)
	{
		shapeCollectionInstance.removeShapeRemovedObserver(shapeRemovedObserverIn);
	}
	
	@Override
	public void addShapeRemovedObserver(ShapeRemovedObserver shapeAddedObserverIn)
	{
		shapeRemovedObservers.add(shapeAddedObserverIn);
	}

	@Override
	public void removeShapeRemovedObserver(ShapeRemovedObserver shapeAddedObserverIn)
	{
		shapeRemovedObservers.remove(shapeAddedObserverIn);
	}

	@Override
	public void notifyShapeRemoved(AbstractShape shapeIn)
	{
		for (ShapeRemovedObserver observer : shapeRemovedObservers)
		{
			observer.receiveShapeRemovedMessage(shapeIn);
		}
	}
	
	//-----------------------------------
	//-----------------------------------
	//ShapeUpdatedSubject METHODS
	//-----------------------------------
	//-----------------------------------

	public static void subscribeShapeUpdatedObserver(ShapeUpdatedObserver shapeUpdatedObserverIn)
	{
		shapeCollectionInstance.addShapeUpdatedObserver(shapeUpdatedObserverIn);
	}

	public static void unsubscribeShapeUpdatedObserver(ShapeUpdatedObserver shapeUpdatedObserverIn)
	{
		shapeCollectionInstance.removeShapeUpdatedObserver(shapeUpdatedObserverIn);
	}
	
	@Override
	public void addShapeUpdatedObserver(ShapeUpdatedObserver shapeEditedObserverIn)
	{
		shapeEditedObservers.add(shapeEditedObserverIn);
	}

	@Override
	public void removeShapeUpdatedObserver(ShapeUpdatedObserver shapeEditedObserverIn)
	{
		shapeEditedObservers.remove(shapeEditedObserverIn);
	}

	@Override
	public void notifyShapeUpdated(AbstractShape shapeIn)
	{
		for (ShapeUpdatedObserver o : shapeEditedObservers)
		{
			o.receiveShapeUpdatedMessage(shapeIn);
		}
	}
}
