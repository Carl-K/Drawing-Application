package model.color;

import java.awt.Color;
import model.ShapeColor;

public class AWTColorAdapter implements IAWTColor 
{
	private Color color;
	
	AWTColorAdapter(ShapeColor shapeColorIn)
	{
		switch (shapeColorIn)
		{
			case BLACK:
				color = java.awt.Color.BLACK;
				break;
			case BLUE:
				color = java.awt.Color.BLUE;
				break;
			case CYAN:
				color = java.awt.Color.CYAN;
				break;
			case DARK_GRAY:
				color = java.awt.Color.DARK_GRAY;
				break;
			case GRAY:
				color = java.awt.Color.GRAY;
				break;
			case GREEN:
				color = java.awt.Color.GREEN;
				break;
			case LIGHT_GRAY:
				color = java.awt.Color.LIGHT_GRAY;
				break;
			case MAGENTA:
				color = java.awt.Color.MAGENTA;
				break;
			case ORANGE:
				color = java.awt.Color.ORANGE;
				break;
			case PINK:
				color = java.awt.Color.PINK;
				break;
			case RED:
				color = java.awt.Color.RED;
				break;
			case WHITE:
				color = java.awt.Color.WHITE;
				break;
			case YELLOW:
				color = java.awt.Color.YELLOW;
				break;
			default:
				throw new Error("MISSING COLOR IN COLORSET");
		}
	}

	@Override
	public Color getAWTColor() {
		return color;
	}

}
