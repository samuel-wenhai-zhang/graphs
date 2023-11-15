//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Samuel Zhang

import java.util.Scanner;
import static java.lang.System.*;

public class ShortestPathMaze
{
   private int[][] maze;
   private int shortest;
   private int[][] shortestMaze;

	public ShortestPathMaze()
	{
	}

	public ShortestPathMaze(int[][] m)
	{
		maze = m;
		shortest = Integer.MAX_VALUE;
		shortestMaze = new int[maze.length][maze[0].length];
	}


	public void checkForExitPath(int r, int c, int path)
	{
		if (r >= 0 && r < maze.length && c >= 0 && c < maze[r].length && maze[r][c] == 1) {
			maze[r][c] = 2;
			if (c == maze[r].length - 1) {
				if (path < shortest) {
					shortest = path;
					for (int row = 0;  row < maze.length; row++) {
						for (int col = 0; col < maze[row].length; col++) {
							shortestMaze[row][col] = maze[row][col];
						}
					}
				}
			}
			else {
				checkForExitPath(r + 1, c, path + 1);
				checkForExitPath(r, c + 1, path + 1);
				checkForExitPath(r - 1, c, path + 1);
				checkForExitPath(r, c - 1, path + 1);
			}
			maze[r][c] = 1;
		}
	}
	
	public int getShortestPath()
	{
		return shortest;
	}

	public String toString()
	{
		String output="";
		for (int r = 0; r < shortestMaze.length; r++) {
			for (int c = 0; c < shortestMaze[r].length; c++) {
				if (shortestMaze[r][c] == 2) {
					output += "P ";
				}
				else {
					output += shortestMaze[r][c] + " ";
				}
			}
			output += "\n";
		}
		return output;
	}
}