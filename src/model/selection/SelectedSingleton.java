package model.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import model.clipboard.ClipboardSingleton;
import model.commandhistory.CommandHandlerSingleton;
import model.shapemanager.ShapeCollectionSingleton;
import model.shapes.AbstractShape;

public class SelectedSingleton implements ISelected
{
	private List<AbstractShape> selectedShapes;
	private ClipboardSingleton clipboard;
	
	private static SelectedSingleton selectedManagerSingleton;
	
	private SelectedSingleton()
	{
		selectedShapes = new ArrayList<AbstractShape>();
		clipboard = ClipboardSingleton.getInstance();
	}
	
	public static SelectedSingleton getInstance()
	{
		if (selectedManagerSingleton == null)
		{
			selectedManagerSingleton = new SelectedSingleton();
		}
		
		return selectedManagerSingleton;
	}
	
	public List<AbstractShape> getSelectedShapes()
	{
		return selectedShapes;
	}
	
	public void setSelectedShapes(List<AbstractShape> selectedShapesIn)
	{
		selectedShapes = selectedShapesIn;
	}
	
	public void operateOnSelection(Consumer<? super AbstractShape> consumerIn)
	{
		selectedShapes.stream().forEach(consumerIn);
		
		pushUpdates();
	}
	
	public void deleteSelected()
	{
		/*
		for (AbstractShape s : selectedShapes)
		{
			ShapeCollectionSingleton.remove(s);
		}
		*/
		CommandHandlerSingleton.remove(selectedShapes);
	}
	
	public void copySelected()
	{
		clipboard.setClipboard(selectedShapes);
	}
	
	private void pushUpdates()
	{
		for (AbstractShape s : selectedShapes)
		{
			ShapeCollectionSingleton.updated(s);
		}
	}
}
