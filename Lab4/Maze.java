//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Samuel Zhang

import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
   private int[][] maze;

	public Maze()
	{
	}

	public Maze(int[][] m)
	{
		maze = m;
	}

	public boolean checkForExitPath(int r, int c)
	{
		if (r >= 0 && r < maze.length && c >= 0 && c < maze[r].length && maze[r][c] == 1) {
			if (c == maze[r].length - 1) {
				return true;
			}
			else {
				maze[r][c] = 0;
				return checkForExitPath(r + 1, c) || checkForExitPath(r, c + 1) || checkForExitPath(r - 1, c) || checkForExitPath(r, c - 1);
			}
		}
		return false;
	}

	public String toString()
	{
		String output="";
		for (int r = 0; r < maze.length; r++) {
			for (int c = 0; c < maze[r].length; c++) {
				output += maze[r][c] + " ";
			}
			output += "\n";
		}
		return output;
	}
}