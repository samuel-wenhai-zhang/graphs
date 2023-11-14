//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class ShortestPathMazeRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("maze2.dat"));
		while(file.hasNext())
		{
			int rc = file.nextInt();
			int[][] maze = new int[rc][rc];
			file.nextLine();

			for(int r= 0; r < rc; r++)
			{
				for(int c =0; c < rc; c++)
				{
					maze[r][c]=file.nextInt();
				}
				file.nextLine();
			}

			ShortestPathMaze test = new ShortestPathMaze(maze);
			test.checkForExitPath(0,0,1);
			
			out.print(test);
			int shortPath = test.getShortestPath();
			out.println(shortPath==Integer.MAX_VALUE?"no path\n":"shortest path of " + shortPath+"\n\n\n");
		}
	}
}