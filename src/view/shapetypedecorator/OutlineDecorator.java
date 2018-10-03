package view.shapetypedecorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

public class OutlineDecorator implements IShadingTypeDecorator {
	private IShadingTypeDecorator shadingTypeDecorator;
	private Color color;
	private Graphics2D context;
	
	public OutlineDecorator(IShadingTypeDecorator shapeTypeDecoratorIn, Color colorIn, Graphics2D contextIn)
	{
		shadingTypeDecorator = shapeTypeDecoratorIn;
		color = colorIn;
		context = contextIn;
	}
	
	public Shape draw()
	{
		Shape s = shadingTypeDecorator.draw();
		
		context.setColor(color);
		
		context.draw(s);
		
		return s;
	}

}
