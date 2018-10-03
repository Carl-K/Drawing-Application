package model.selection;

import java.util.List;
import java.util.function.Consumer;

import model.shapes.AbstractShape;

public interface ISelected
{
	public List<AbstractShape> getSelectedShapes();
	public void setSelectedShapes(List<AbstractShape> selectedShapesIn);
	public void operateOnSelection(Consumer<? super AbstractShape> consumerIn);
	public void deleteSelected();
	public void copySelected();
}
