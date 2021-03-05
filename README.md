# 2D Array Challenge

This repo contains the source code for the 2D Array Challenge assignment as well as our reflections.

## Usage:

For convenience, we've already compiled the code and put it in `Project.jar`

1. Run the program with the following arguments to create a new, random matrix:
	```bash
	java -jar Project.jar gen mat.txt
	```
2. Solve the generated matrix (find the shortest path) with the following command:
	```bash
	java -jar Project.jar solve mat.txt
	```

## UML diagram

## `FileGenerator`
![FileGenerator](uml\filegenerator.jpg)

## `StringToArray`
![StringToArray](uml\stringtoarray.jpg)

## `TileStepper`
![TileStepper](uml\tilestepper.jpg)

## `TxtLoader`
![TxtLoader](uml\txtloader.jpg)