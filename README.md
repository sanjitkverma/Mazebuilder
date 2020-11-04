# Maze Builder
In this lab I create a program that can create random mazes using java. The user can specify maze dimensions, has entery/exits points and can change colors when clicked on to build the maze.

### Lab Description
A maze consists of a series of walls and paths with an entrance and exit. We can represent a maze with zeros and ones where a zero indicates a position/tile in the maze containing a wall and a one represents part of the walkable pathway. The maze has a single entry point and a single exit point represented by the characters 'S' and 'E' respectively. You are going to write an application that will facilitate the creation of new mazes graphically. The user will first specify the maze dimensions (e.g. 25 x 25) and you will present an initial board containing a matrix of buttons matching the dimensions of the maze. The user can then click the buttons/tiles and change the color from the wall color to the path color. Once the maze is complete, the user can then save the maze to a file containing zeros, ones and the entry and exit characters. The following shows a 10x10 maze along with its text file representation.

### GUI Example

![Maze Builder GUI](https://github.com/NCATCS/images/blob/master/Figure9-1.png)

### Output File Example

```
10 10
00S0000000
0110010010
0011111010
0000101110
0111111000
0100101100
011010011E
0011110000
0110011110
0000000000
```

### Output File Description

The output file of your maze builder should have the row and column dimensions on the first line represented as integers. The next rows and columns should then match the dimensions of the maze where zeros represent walls and ones represent paths. The entrance should be marked by an 'S' and the exit by an 'E'. The entry and exit should be the only non-wall tiles on the maze edges.

Save your output file to the file chosen by the user with a [JavaFX FileChooser](http://tutorials.jenkov.com/javafx/filechooser.html).

### Input

You should prompt the user for the number of rows and columns in the maze using a [JavaFX Dialog](http://code.makery.ch/blog/javafx-dialogs-official/).

### Commands

Your application should provide Save and Exit commands. The Save command should write out the maze file according to the output file format specified in the Output File section above. The Exit command should also ask the user if a Save should be performed before exiting.

### Tiles/Buttons

You are free to use the four colors of your choice in the maze: walls, path, entry and exit. When a user clicks a tile/button, it should toggle from wall to path to entry to exit and then back to wall on successive clicks. You do not have to error check your maze (e.g. making sure that there is only one entry and exit). Again, all tiles on the maze edges should be walls except the entry and exit squares.


