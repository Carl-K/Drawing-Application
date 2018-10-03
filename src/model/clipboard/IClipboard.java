package model.clipboard;

import java.util.List;

import model.shapes.AbstractShape;

public interface IClipboard
{
	public void setClipboard(List<AbstractShape> shapesIn);
	public void paste();
}
