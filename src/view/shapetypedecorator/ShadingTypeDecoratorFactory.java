package view.shapetypedecorator;

import java.awt.Color;
import java.awt.Graphics2D;

public class ShadingTypeDecoratorFactory
{
	public static IShadingTypeDecorator createFilledDecorator(IShadingTypeDecorator shapeTypeDecoratorIn, Color colorIn, Graphics2D contextIn)
	{
		IShadingTypeDecorator filledDecorator = new FilledDecorator(shapeTypeDecoratorIn, colorIn, contextIn);
		return filledDecorator;
	}
	
	public static IShadingTypeDecorator createOutlineDecorator(IShadingTypeDecorator shapeTypeDecoratorIn, Color colorIn, Graphics2D contextIn)
	{
		IShadingTypeDecorator filledDecorator = new OutlineDecorator(shapeTypeDecoratorIn, colorIn, contextIn);
		return filledDecorator;
	}
}
