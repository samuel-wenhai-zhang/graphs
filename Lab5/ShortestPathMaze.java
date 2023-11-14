//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Samuel Zhang

import java.util.Scanner;
import static java.lang.System.*;

public class ShortestPathMaze
{
   private int[][] maze;
   private int shortest;

	public ShortestPathMaze()
	{
	}

	public ShortestPathMaze(int[][] m)
	{
		maze = m;
		shortest = Integer.MAX_VALUE;
	}


	public void checkForExitPath(int r, int c, int path)
	{
		if (r >= 0 && r < maze.length && c >= 0 && c < maze[r].length && maze[r][c] == 1) {
			maze[r][c] = 0;
			if (c == maze[r].length - 1) {
				return true;
			}
			else {
				return checkForExitPath(r + 1, c) || checkForExitPath(r, c + 1) || checkForExitPath(r - 1, c) || checkForExitPath(r, c - 1);
			}
		}
		return false;
	}
	
	public int getShortestPath()
	{
		return shortest;
	}

	public String toString()
	{
		String output="";
		return output;
	}
}