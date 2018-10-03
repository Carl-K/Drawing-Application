package model.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import model.ShapeColor;
import model.ShapeShadingType;
import model.StartAndEndPointMode;
import model.blocks.ShapeBlocks;
import model.commandhistory.CommandHandlerSingleton;
import model.interfaces.IApplicationState;
import model.shapes.AbstractShape;

public class SelectionCallbacksSingleton implements ISelectionCallbacks
{
	private IApplicationState applicationState;
	
	private static SelectionCallbacksSingleton selectionUpdaterSingleton;
	
	private SelectionCallbacksSingleton(IApplicationState applicationStateIn)
	{
		applicationState = applicationStateIn;
	}
	
	public static SelectionCallbacksSingleton getInstance(IApplicationState applicationStateIn)
	{
		if (selectionUpdaterSingleton == null)
		{
			selectionUpdaterSingleton = new SelectionCallbacksSingleton(applicationStateIn);
		}
		
		return selectionUpdaterSingleton;
	}
	
	public void updateShapeShadingType()
	{
		if (applicationState.getActiveStartAndEndPointMode() == StartAndEndPointMode.SELECT)
		{
			ShapeShadingType newShadingType = applicationState.getActiveShapeShadingType();
			
			List<AbstractShape> selectedShapes = SelectedSingleton.getInstance().getSelectedShapes();
			
			ArrayList<ShapeShadingType> shadingTypeOlds = new ArrayList<ShapeShadingType>();
			
			for (int i = 0; i < selectedShapes.size(); i++)
			{
				AbstractShape s = selectedShapes.get(i);
				
				shadingTypeOlds.add(s.getShapeShadingType());
			}
			
			Consumer<? super AbstractShape> consumer = ShapeBlocks.updateShapeShadingType(newShadingType);
			SelectedSingleton.getInstance().operateOnSelection(consumer);
			
			CommandHandlerSingleton.updateShapeShadingType(selectedShapes, shadingTypeOlds);
		}
	}
	
	public void updatePrimaryColor()
	{
		if (applicationState.getActiveStartAndEndPointMode() == StartAndEndPointMode.SELECT)
		{
			ShapeColor newPrimaryColor = applicationState.getActivePrimaryColor();
			
			List<AbstractShape> selectedShapes = SelectedSingleton.getInstance().getSelectedShapes();
			
			ArrayList<ShapeColor> primaryColorOlds = new ArrayList<ShapeColor>();
			
			for (int i = 0; i < selectedShapes.size(); i++)
			{
				AbstractShape s = selectedShapes.get(i);
				
				primaryColorOlds.add(s.getPrimaryColor());
			}
			
			Consumer<? super AbstractShape> consumer = ShapeBlocks.updatePrimaryColor(newPrimaryColor);
			
			SelectedSingleton.getInstance().operateOnSelection(consumer);
			
			CommandHandlerSingleton.updatePrimaryColor(selectedShapes, primaryColorOlds);
		}
	}
	
	public void updateSecondaryColor()
	{
		if (applicationState.getActiveStartAndEndPointMode() == StartAndEndPointMode.SELECT)
		{
			ShapeColor newSecondaryColor = applicationState.getActiveSecondaryColor();
			
			List<AbstractShape> selectedShapes = SelectedSingleton.getInstance().getSelectedShapes();
			
			ArrayList<ShapeColor> secondaryColorOlds = new ArrayList<ShapeColor>();
			
			for (int i = 0; i < selectedShapes.size(); i++)
			{
				AbstractShape s = selectedShapes.get(i);
				
				secondaryColorOlds.add(s.getSecondaryColor());
			}
			
			Consumer<? super AbstractShape> consumer = ShapeBlocks.updateSecondaryColor(newSecondaryColor);
			SelectedSingleton.getInstance().operateOnSelection(consumer);
			
			CommandHandlerSingleton.updateSecondaryColor(selectedShapes, secondaryColorOlds);
		}
	}
}
