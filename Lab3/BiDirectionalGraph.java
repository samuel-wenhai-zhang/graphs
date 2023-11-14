//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Samuel Zhang

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;
import static java.lang.System.*;

public class BiDirectionalGraph
{
	private TreeMap<String, TreeSet<String>> map;
	private boolean found;

	public BiDirectionalGraph(String line)
	{
		map = new TreeMap<String, TreeSet<String>>();
		found = false;

		Scanner in = new Scanner(line);
		while (in.hasNext()) {
			String one = in.next();
			String two = in.next();
			if (!map.containsKey(one)) {
				TreeSet<String> set = new TreeSet<String>();
				set.add(two);
				map.put(one, set);
			}
			else {
				map.get(one).add(two);
			}
			if (!map.containsKey(two)) {
				TreeSet<String> set = new TreeSet<String>();
				set.add(one);
				map.put(two, set);
			}
			else {
				map.get(two).add(one);
			}
		}
	}

	public boolean contains(String name)
	{
		return map.containsKey(name);
	}

	public void check(String first, String second, TreeSet<String> placesUsed)
	{
		if (map.get(first).contains(second)) {
			found = true;
		}
		else {
			for (String s: map.get(first)) {
				if (!placesUsed.contains(s)) {
					placesUsed.add(first);
					check(s, second, placesUsed);
				}
			}
		}
	}

	public String toString()
	{
		return found ? "YAH" : "NAH";
	}
}