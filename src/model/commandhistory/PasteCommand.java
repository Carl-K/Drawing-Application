package model.commandhistory;

import java.util.List;

import model.shapemanager.ShapeCollectionSingleton;
import model.shapes.AbstractShape;

class PasteCommand implements IExecutable {
	
	List<AbstractShape> pasted;
	
	PasteCommand(List<AbstractShape> pastedIn)
	{
		pasted = pastedIn;
	}

	@Override
	public void undo()
	{
		for (AbstractShape s : pasted)
		{
			ShapeCollectionSingleton.remove(s);
		}
	}

	@Override
	public void execute()
	{
		for (AbstractShape s : pasted)
		{
			ShapeCollectionSingleton.add(s);
		}
	}

}
