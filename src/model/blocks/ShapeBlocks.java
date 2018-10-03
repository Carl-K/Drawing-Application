package model.blocks;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.function.Consumer;
import java.util.function.Predicate;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.shapes.AbstractShape;

public class ShapeBlocks
{
	public static Predicate<? super AbstractShape> ellipsePredicate()
	{
		Predicate<? super AbstractShape> predicate = 
		(shapeIn) ->
		{
			return shapeIn.getShapeType() == ShapeType.ELLIPSE;
		};
				
		return predicate;
	}
	
	public static Predicate<? super AbstractShape> ellipseCollisionPredicate(Point topLeftIn, Point bottomRightIn)
	{
		Predicate<? super AbstractShape> predicate = 
		(shapeIn) ->
		{
			if (shapeIn.getShapeType() != ShapeType.ELLIPSE)
			{
				return false;
			}
			
			return ellipseCollision(shapeIn, topLeftIn, bottomRightIn);
		};
		
		return predicate;
	}
	
	private static boolean ellipseCollision(AbstractShape shapeIn, Point topLeftIn, Point bottomRightIn)
	{
		Shape ellipse = new Ellipse2D.Float((float)shapeIn.getUpperLeftHandCornerPoint().getX(), (float)shapeIn.getUpperLeftHandCornerPoint().getY(), (float)shapeIn.getWidth(), (float)shapeIn.getHeight());
		Rectangle2D selection = new Rectangle2D.Float((float)topLeftIn.getX(), (float)topLeftIn.getY(), (float)(bottomRightIn.getX() - topLeftIn.getX()), (float)(bottomRightIn.getY() - topLeftIn.getY()));
		Area ellipseArea = new Area(ellipse);
		
		return ellipseArea.intersects(selection);
	}
	
	//--------------------------
	//--------------------------
	//--------------------------
	
	public static Predicate<? super AbstractShape> rectanglePredicate()
	{
		Predicate<? super AbstractShape> predicate = 
		(shapeIn) ->
		{
			return shapeIn.getShapeType() == ShapeType.RECTANGLE;
		};
		
		return predicate;
	}
	
	public static Predicate<? super AbstractShape> rectangleCollisionPredicate(Point topLeftIn, Point bottomRightIn)
	{
		Predicate<? super AbstractShape> predicate = 
		(shapeIn) ->
		{
			if (shapeIn.getShapeType() != ShapeType.RECTANGLE)
			{
				return false;
			}
			
			return rectangleCollision(shapeIn, topLeftIn, bottomRightIn);
		};
		
		return predicate;
	}
	
	private static boolean rectangleCollision(AbstractShape shapeIn, Point topLeftIn, Point bottomRightIn)
	{
		Shape rectangle = new Rectangle2D.Float((float)shapeIn.getUpperLeftHandCornerPoint().getX(), (float)shapeIn.getUpperLeftHandCornerPoint().getY(), (float)shapeIn.getWidth(), (float)shapeIn.getHeight());
		Rectangle2D selection = new Rectangle2D.Float((float)topLeftIn.getX(), (float)topLeftIn.getY(), (float)(bottomRightIn.getX() - topLeftIn.getX()), (float)(bottomRightIn.getY() - topLeftIn.getY()));
		Area rectangleArea = new Area(rectangle);
		
		return rectangleArea.intersects(selection);
	}
	
	//--------------------------
	//--------------------------
	//--------------------------
	
	public static Predicate<? super AbstractShape> trianglePredicate()
	{
		Predicate<? super AbstractShape> predicate = 
		(shapeIn) ->
		{
			return shapeIn.getShapeType() == ShapeType.TRIANGLE;
		};
				
		return predicate;
	}
	
	public static Predicate<? super AbstractShape> triangleCollisionPredicate(Point topLeftIn, Point bottomRightIn)
	{
		Predicate<? super AbstractShape> predicate = 
		(shapeIn) ->
		{
			if (shapeIn.getShapeType() != ShapeType.TRIANGLE)
			{
				return false;
			}
			
			return triangleCollision(shapeIn, topLeftIn, bottomRightIn);
		};
		
		return predicate;
	}
	
	private static boolean triangleCollision(AbstractShape shapeIn, Point topLeftIn, Point bottomRightIn)
	{
		int[] arrX = new int[]{
		  		 (int)shapeIn.getUpperLeftHandCornerPoint().getX(),
		  		 (int)shapeIn.getUpperLeftHandCornerPoint().getX() + (int)(shapeIn.getWidth() / 2.0),
		  		 (int)shapeIn.getUpperLeftHandCornerPoint().getX() + (int)(shapeIn.getWidth())
		 		};

		int[] arrY = new int[]{
				 (int)shapeIn.getUpperLeftHandCornerPoint().getY() + (int)(shapeIn.getHeight()),
				 (int)shapeIn.getUpperLeftHandCornerPoint().getY(),
				 (int)shapeIn.getUpperLeftHandCornerPoint().getY() + (int)(shapeIn.getHeight())
	 			};
		
		Polygon triangle = new Polygon(arrX, arrY, 3);
		Rectangle2D selection = new Rectangle2D.Float((float)topLeftIn.getX(), (float)topLeftIn.getY(), (float)(bottomRightIn.getX() - topLeftIn.getX()), (float)(bottomRightIn.getY() - topLeftIn.getY()));
		Area triangleArea = new Area(triangle);
		
		return triangleArea.intersects(selection);
	}
	
	//--------------------------
	//--------------------------
	//--------------------------
	
	public static Predicate<? super AbstractShape> collisionPredicate(Point topLeftIn, Point bottomRightIn)
	{
		Predicate<? super AbstractShape> predicate = 
		(shapeIn) ->
		{
			switch (shapeIn.getShapeType())
			{
			case ELLIPSE:
				return ellipseCollision(shapeIn, topLeftIn, bottomRightIn);
			case RECTANGLE:
				return rectangleCollision(shapeIn, topLeftIn, bottomRightIn);
			case TRIANGLE:
				return triangleCollision(shapeIn, topLeftIn, bottomRightIn);
			default:
				throw new Error("MISSING COLLSION DETECTION");
			}
		};
		
		return predicate;
	}
	
	//--------------------------
	//--------------------------
	//--------------------------
	
	public static Consumer<? super AbstractShape> moveShape(Point startIn, Point endIn)
	{
		double widthChange = endIn.getX() - startIn.getX();
		double heightChange = endIn.getY() - startIn.getY();
		
		Consumer<? super AbstractShape> consumer =
		(shapeIn) ->
		{
			Point p = new Point((int)(shapeIn.getUpperLeftHandCornerPoint().getX() + widthChange), (int)(shapeIn.getUpperLeftHandCornerPoint().getY() + heightChange));
			shapeIn.setUpperLeftHandCornerPoint(p);
		};
		
		return consumer;
	}
	
	//--------------------------
	//--------------------------
	//--------------------------
	
	public static Consumer<? super AbstractShape> updateShapeShadingType(ShapeShadingType shadingTypeIn)
	{
		Consumer<? super AbstractShape> consumer =
		(shapeIn) ->
		{
			shapeIn.setShadingType(shadingTypeIn);
		};
		
		return consumer;
	}
	
	public static Consumer<? super AbstractShape> updatePrimaryColor(ShapeColor primaryColorIn)
	{
		Consumer<? super AbstractShape> consumer =
		(shapeIn) ->
		{
			shapeIn.setPrimaryColor(primaryColorIn);
		};
		
		return consumer;
	}
	
	public static Consumer<? super AbstractShape> updateSecondaryColor(ShapeColor secondaryColorIn)
	{
		Consumer<? super AbstractShape> consumer =
		(shapeIn) ->
		{
			shapeIn.setSecondaryColor(secondaryColorIn);
		};
		
		return consumer;
	}
}
