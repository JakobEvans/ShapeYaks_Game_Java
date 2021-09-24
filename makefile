ShapeYaksP2.jar : main.txt Equilateral.class Right.class Scalene.class Triangle.class Square.class Rectangle.class Quadrilateral.class Circle.class GShape.class Block.class Hole.class GameBoard.class Data.class Proj2.class Buttons.class ShapePanel.class ShapeDialog.class SelectedPanel.class ColorPanel.class Palette.class yak.png
	jar cmf main.txt ShapeYaksP2.jar *.class *.png

Equilateral.class : Equilateral.java
	javac Equilateral.java
Right.class : Right.java
	javac Right.java
Scalene.class : Scalene.java
	javac Scalene.java
Triangle.class : Triangle.java
	javac Triangle.java
Square.class : Square.java
	javac Square.java
Rectangle.class : Rectangle.java
	javac Rectangle.java
Quadrilateral.class : Quadrilateral.java
	javac Quadrilateral.java
Circle.class : Circle.java
	javac Circle.java
GShape.class : GShape.java
	javac GShape.java

Block.class : Block.java
	javac Block.java
Hole.class : Hole.java
	javac Hole.java
GameBoard.class : GameBoard.java
	javac GameBoard.java
Data.class : Data.java
	javac Data.java
Proj2.class : Proj2.java
	javac Proj2.java
Buttons.class: Buttons.java
	javac Buttons.java
ShapePanel.class : ShapePanel.java
	javac ShapePanel.java
SelectedPanel.class : SelectedPanel.java
	javac SelectedPanel.java
ShapeDialog.class : ShapeDialog.java
	javac ShapePanel.java
Palette.class : Palette.java
	javac Palette.java
ColorPanel.class : ColorPanel.java
	javac ColorPanel.java
clean :
	rm *.class Proj2.jar
