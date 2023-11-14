//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Samuel Zhang

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class ShortestPathGraph
{
	private TreeMap<String, String> map;
	private boolean found;
	private int shortest;

	public ShortestPathGraph(String line)
	{
		map = new TreeMap<String, String>();
		found = false;
		shortest = -1;

		Scanner in = new Scanner(line);
		while (in.hasNext()) {
			String s = in.next();
			String one = s.substring(0, 1);
			String two = s.substring(1, 2);
			if (!map.containsKey(one)) {
				map.put(one, two);
			}
			else {
				map.put(one, map.get(one) + two);
			}
			if (!map.containsKey(two)) {
				map.put(two, one);
			}
			else {
				map.put(two, map.get(two) + one);
			}
		}
	}

	public boolean contains(String letter)
	{
		return map.containsKey(letter);
	}

	public void check(String first, String second, String placesUsed, int steps)
	{
		steps++;
		
		if (map.get(first).contains(second)) {
			found = true;
			if (shortest == -1 || steps < shortest) {
				shortest = steps;
			}
		}
		else {
			for (int i = 0; i < map.get(first).length(); i++) {
				if (!placesUsed.contains(map.get(first).substring(i, i + 1))) {
					check(map.get(first).substring(i, i + 1), second, placesUsed + first, steps);
				}
			}
		}
	}

	public String toString()
	{
		return found ? "yes in " + shortest + " steps" : "no";
	}
}