// File: Triangle.java
// Author: Dr. Watts
// Contents: This file contains the description and implementation
// of a class called Triangle.

import static java.lang.Math.*;
import java.awt.*;
import java.util.*;

public class Triangle extends GShape
{
	protected int [] vertexX = new int [3]; // integer X coordinates for drawing
	protected int [] vertexY = new int [3]; // integer Y coordinates for drawing
	//protected Polygon polygon;		// Java polygon for drawing

	Triangle ()
	{
		radius = new double [3];
		theta = new double [3];
	}

	public void setCenterX (int X)
	{
		centerX = X;
		setPosition ();
	}

	public void setCenterY (int Y)
	{
		centerY = Y;
		setPosition ();
	}

	public void setAngleR (double A)
	{
		angle = A;
		setRadiusTheta ();
	}

	public void setAngleD (double A)
	{
		angle = Math.toRadians(A);
		setRadiusTheta ();
	}

	public String getName ()
	{
		return "Triangle";
	}

	public void paintComponent (Graphics2D g2)
	{
		g2.setPaint (color);
		g2.fillPolygon (vertexX, vertexY, 3);
		if (isSelected)
			g2.setPaint (Color.WHITE);
		g2.drawPolygon (vertexX, vertexY, 3);
		//g2.setPaint (Color.BLACK);
		//g2.fillOval (centerX-1, centerY-1, 2, 2); // Draw the center point
	}

	protected void setPosition ()
	{
		for (int i = 0; i < 3; i++)
		{
			vertexX[i] = (int) Math.round (radius[i] * cos (theta[i]) + centerX);
			vertexY[i] = (int) Math.round (radius[i] * sin (theta[i]) + centerY);
		}
		polygon = new Polygon (vertexX, vertexY, 3);
	}

	public boolean isIn (int X, int Y)
	{
		return polygon.contains (X, Y);
	}
	public int [] LargestV(){
	int [] largest = new int[2];
	for (int x = 0; x < 3;  x++){
		if(vertexX[x] > largest[0]){
			 largest[0] = vertexX[x];
		}
		if(vertexY[x] > largest[1]){
			 largest[1] = vertexY[x];
		}
	}
	return largest;
}
	public void rotate (double A)
	{
		angle += A;
		for (int i = 0; i < 3; i++)
			theta[i] += A;
		setPosition ();
	}

	int changeXby (int X, int max)
	{
		if (X < 0)
		{
			int remaining = vertexX[0];
			for (int i = 1; i < 3; i++)
				if (vertexX[i] < remaining)
					remaining = vertexX[i];
			if (remaining < -X)
				return X + remaining;
		}
		else if (X > 0)
		{
			int remaining = (max - vertexX[0]);
			for (int i = 1; i < 3; i++)
				if ((max - vertexX[i]) < remaining)
					remaining = (max - vertexX[i]);
			if (remaining < X)
				return X - remaining;
		}
		return 0;
	}

	int changeYby (int Y, int max)
	{
		if (Y < 0)
		{
			int remaining = vertexY[0];
			for (int i = 1; i < 3; i++)
				if (vertexY[i] < remaining)
					remaining = vertexY[i];
			if (remaining < -Y)
				return Y + remaining;
		}
		else if (Y > 0)
		{
			int remaining = (max - vertexY[0]);
			for (int i = 1; i < 3; i++)
				if ((max - vertexY[i]) < remaining)
					remaining = (max - vertexY[i]);
			if (remaining < Y)
				return Y - remaining;
		}
		return 0;
	}
}
