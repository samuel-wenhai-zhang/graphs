import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class MazeRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("maze.dat"));
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

			Maze test = new Maze(maze);
			
			out.println(test + "" + (test.checkForExitPath(0,0)==true?"exit found\n\n":"exit not found\n\n"));
		}
	}
}