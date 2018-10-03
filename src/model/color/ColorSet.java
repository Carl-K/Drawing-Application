package model.color;

import model.ShapeColor;

public class ColorSet
{
	private static final AWTColorAdapter BLACK = new AWTColorAdapter(ShapeColor.BLACK);
	private static final AWTColorAdapter BLUE = new AWTColorAdapter(ShapeColor.BLUE);
	private static final AWTColorAdapter CYAN = new AWTColorAdapter(ShapeColor.CYAN);
	private static final AWTColorAdapter DARK_GRAY = new AWTColorAdapter(ShapeColor.DARK_GRAY);
	private static final AWTColorAdapter GRAY = new AWTColorAdapter(ShapeColor.GRAY);
	private static final AWTColorAdapter GREEN = new AWTColorAdapter(ShapeColor.GREEN);
	private static final AWTColorAdapter LIGHT_GRAY = new AWTColorAdapter(ShapeColor.LIGHT_GRAY);
	private static final AWTColorAdapter MAGENTA = new AWTColorAdapter(ShapeColor.MAGENTA);
	private static final AWTColorAdapter ORANGE = new AWTColorAdapter(ShapeColor.ORANGE);
	private static final AWTColorAdapter PINK = new AWTColorAdapter(ShapeColor.PINK);
	private static final AWTColorAdapter RED = new AWTColorAdapter(ShapeColor.RED);
	private static final AWTColorAdapter WHITE = new AWTColorAdapter(ShapeColor.WHITE);
	private static final AWTColorAdapter YELLOW = new AWTColorAdapter(ShapeColor.YELLOW);
	
	private ColorSet()
	{
		
	}
	
	public static IAWTColor getBlack()
	{
		return BLACK;
	}
	
	public static IAWTColor getBlue()
	{
		return BLUE;
	}
	
	public static IAWTColor getCyan()
	{
		return CYAN;
	}
	
	public static IAWTColor getDarkGray()
	{
		return DARK_GRAY;
	}
	
	public static IAWTColor getGray()
	{
		return GRAY;
	}
	
	public static IAWTColor getGreen()
	{
		return GREEN;
	}
	
	public static IAWTColor getLightGray()
	{
		return LIGHT_GRAY;
	}
	
	public static IAWTColor getMagenta()
	{
		return MAGENTA;
	}
	
	public static IAWTColor getOrange()
	{
		return ORANGE;
	}
	
	public static IAWTColor getPink()
	{
		return PINK;
	}
	
	public static IAWTColor getRed()
	{
		return RED;
	}
	
	public static IAWTColor getWhite()
	{
		return WHITE;
	}
	
	public static IAWTColor getYellow()
	{
		return YELLOW;
	}
	
	public static IAWTColor getColor(ShapeColor shapeColorIn)
	{
		switch (shapeColorIn)
		{
		case BLACK:
			return BLACK;
		case BLUE:
			return BLUE;
		case CYAN:
			return CYAN;
		case DARK_GRAY:
			return DARK_GRAY;
		case GRAY:
			return GRAY;
		case GREEN:
			return GREEN;
		case LIGHT_GRAY:
			return LIGHT_GRAY;
		case MAGENTA:
			return MAGENTA;
		case ORANGE:
			return ORANGE;
		case PINK:
			return PINK;
		case RED:
			return RED;
		case WHITE:
			return WHITE;
		case YELLOW:
			return YELLOW;
		default:
			throw new Error("MISSING COLOR IN COLORSET");
		}
	}
}
