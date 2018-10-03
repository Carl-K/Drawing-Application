package view.graphicmanager;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import model.color.ColorSet;
import model.color.IAWTColor;
import view.interfaces.IPaintCanvas;
import view.shape.AbstractShapeGraphic;
import view.shapetypedecorator.IShadingTypeDecorator;
import view.shapetypedecorator.ShadingTypeDecoratorFactory;

public class Drawer implements IShapeGraphicCollectionObservers {
	
	Graphics2D context;
	
	ArrayList<AbstractShapeGraphic> shapeGraphics;
	
	public Drawer(IPaintCanvas paintCanvasIn)
	{
		context = paintCanvasIn.getGraphics2D();
		
		shapeGraphics = new ArrayList<AbstractShapeGraphic>();
	}
	
	private void draw(AbstractShapeGraphic shapeGraphicIn)
	{
		IShadingTypeDecorator shadingTypeDecorator = null;
		switch(shapeGraphicIn.getShapeShadingType())
		{
		case FILLED_IN:
			shadingTypeDecorator = ShadingTypeDecoratorFactory.createFilledDecorator(shapeGraphicIn, shapeGraphicIn.getPrimaryColor(), context);
			break;
		case OUTLINE:
			shadingTypeDecorator = ShadingTypeDecoratorFactory.createOutlineDecorator(shapeGraphicIn, shapeGraphicIn.getPrimaryColor(), context);
			break;
		case OUTLINE_AND_FILLED_IN:
			IShadingTypeDecorator filledDecorator = ShadingTypeDecoratorFactory.createFilledDecorator(shapeGraphicIn, shapeGraphicIn.getSecondaryColor(), context);
			shadingTypeDecorator = ShadingTypeDecoratorFactory.createOutlineDecorator(filledDecorator, shapeGraphicIn.getPrimaryColor(), context);
			break;
		default:
			throw new Error("MISSING DECORATOR");
		}
		
		shadingTypeDecorator.draw();
	}
	
	private void redraw()
	{
		Shape rect = new Rectangle2D.Float(0, 0, 10000, 10000);
		IAWTColor color = ColorSet.getWhite();
		context.setColor(color.getAWTColor());
		context.fill(rect);
		
		for (AbstractShapeGraphic s : shapeGraphics)
		{
			draw(s);
		}
	}
	
	//-----------------------------------
    //-----------------------------------
  	//ShapeGraphicCreatedObserver METHODS
  	//-----------------------------------
    //-----------------------------------

	@Override
	public void receiveShapeGraphicCreatedMessage(AbstractShapeGraphic shapeGraphicIn)
	{
		shapeGraphics.add(shapeGraphicIn);
		
		draw(shapeGraphicIn);
	}
	
	//-----------------------------------
    //-----------------------------------
  	//ShapeGraphicUpdatedObserver METHODS
  	//-----------------------------------
    //-----------------------------------

	@Override
	public void receiveShapeGraphicUpdatedMessage(AbstractShapeGraphic shapeIn)
	{
		redraw();
	}
	
	//-----------------------------------
    //-----------------------------------
  	//ShapeGraphicRemovedObserver METHODS
  	//-----------------------------------
    //-----------------------------------

	@Override
	public void receiveShapeGraphicRemovedMessage(AbstractShapeGraphic shapeGraphicIn)
	{
		shapeGraphics.remove(shapeGraphicIn);
		redraw();
	}

}

/*
package view.shapemanager;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import model.color.ColorSet;
import model.color.IAWTColor;
import view.interfaces.IPaintCanvas;
import view.shape.AbstractShapeGraphic;
import view.shapetypedecorator.IShadingTypeDecorator;
import view.shapetypedecorator.ShadingTypeDecoratorFactory;

public class PaintCanvasDrawer implements IShapeGraphicCollectionObservers {
	
	IPaintCanvas paintCanvas;
	
	ArrayList<AbstractShapeGraphic> shapeGraphics;
	
	public PaintCanvasDrawer(IPaintCanvas paintCanvasIn)
	{
		paintCanvas = paintCanvasIn;
		
		shapeGraphics = new ArrayList<AbstractShapeGraphic>();
	}
	
	private void draw(AbstractShapeGraphic shapeGraphicIn)
	{
		IShadingTypeDecorator shadingTypeDecorator = null;
		switch(shapeGraphicIn.getShapeShadingType())
		{
		case FILLED_IN:
			shadingTypeDecorator = ShadingTypeDecoratorFactory.createFilledDecorator(shapeGraphicIn, shapeGraphicIn.getSecondaryColor().getAWTColor(), paintCanvas.getGraphics2D());
			break;
		case OUTLINE:
			shadingTypeDecorator = ShadingTypeDecoratorFactory.createOutlineDecorator(shapeGraphicIn, shapeGraphicIn.getPrimaryColor().getAWTColor(), paintCanvas.getGraphics2D());
			break;
		case OUTLINE_AND_FILLED_IN:
			IShadingTypeDecorator filledDecorator = ShadingTypeDecoratorFactory.createFilledDecorator(shapeGraphicIn, shapeGraphicIn.getSecondaryColor().getAWTColor(), paintCanvas.getGraphics2D());
			shadingTypeDecorator = ShadingTypeDecoratorFactory.createOutlineDecorator(filledDecorator, shapeGraphicIn.getPrimaryColor().getAWTColor(), paintCanvas.getGraphics2D());
			break;
		default:
			throw new Error("MISSING DECORATOR");
		}
		
		shadingTypeDecorator.draw();
	}
	
	private void redraw()
	{
		Shape rect = new Rectangle2D.Float(0, 0, 10000, 10000);
		IAWTColor color = ColorSet.getOrange();
		System.out.println(color.getAWTColor());
		paintCanvas.getGraphics2D().setColor(color.getAWTColor());
		paintCanvas.getGraphics2D().setBackground(color.getAWTColor());
		paintCanvas.getGraphics2D().fill(rect);
		
		for (AbstractShapeGraphic s : shapeGraphics)
		{
			draw(s);
		}
	}
	
	//-----------------------------------
    //-----------------------------------
  	//ShapeGraphicCreatedObserver METHODS
  	//-----------------------------------
    //-----------------------------------

	@Override
	public void receiveShapeGraphicCreatedMessage(AbstractShapeGraphic shapeGraphicIn)
	{
		shapeGraphics.add(shapeGraphicIn);
		
		draw(shapeGraphicIn);
	}
	
	//-----------------------------------
    //-----------------------------------
  	//ShapeGraphicUpdatedObserver METHODS
  	//-----------------------------------
    //-----------------------------------

	@Override
	public void receiveShapeGraphicUpdatedMessage(AbstractShapeGraphic shapeIn)
	{
		redraw();
	}
	
	//-----------------------------------
    //-----------------------------------
  	//ShapeGraphicRemovedObserver METHODS
  	//-----------------------------------
    //-----------------------------------

	@Override
	public void receiveShapeGraphicRemovedMessage(AbstractShapeGraphic shapeGraphicIn)
	{
		shapeGraphics.remove(shapeGraphicIn);
		redraw();
	}

}
*/
