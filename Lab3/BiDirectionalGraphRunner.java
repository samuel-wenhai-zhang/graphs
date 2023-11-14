import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
import static java.lang.System.*;

public class BiDirectionalGraphRunner
{
	public static void main( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File("bidgraph.dat"));
		int howManyTimes = file.nextInt();
		file.nextLine();
		for(int x=0; x<howManyTimes; x++)
		{
			BiDirectionalGraph test = new BiDirectionalGraph(file.nextLine());
			String[] names = file.nextLine().split(" ");
			String start = names[0];
			String stop = names[1];

			boolean chk = false;
			if(test.contains(start)&&test.contains(stop))
			   test.check(start,stop,new TreeSet<String>());

			System.out.println(test);
		}
	}
}