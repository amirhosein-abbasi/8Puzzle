# 8Puzzle
AI-based 8puzzle player in Java


**The problem.** The 8-puzzle problem is a puzzle invented and popularized by Noyes Palmer Chapman in the 1870s. It is played on a 3-by-3 grid 
with 8 square blocks labeled 1 through 8 and a blank square. Your goal is to rearrange the blocks so that they are in order, using as 
few moves as possible. You are permitted to slide blocks horizontally or vertically into the blank square. The following shows a sequence 
of legal moves from an initial board (left) to the goal board (right) (thanks to description from [this repo](https://github.com/jdvalera/8puzzle)).

```
    1  3        1     3        1  2  3        1  2  3        1  2  3
 4  2  5   =>   4  2  5   =>   4     5   =>   4  5      =>   4  5  6
 7  8  6        7  8  6        7  8  6        7  8  6        7  8 

 initial        1 left          2 up          5 left          goal
 ```

![game](./imgs/puzzle.gif)

 # Algorithms

 ## Depth-First Search
![dfs-img](./imgs/dfs.gif)
 ## A-Star
![astar-img](./imgs/a-star.png)
 ## Multi-Directional Search
![multidir-img](./imgs/multidir.png)

