//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Samuel Zhang

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Graph
{
	private TreeMap<String, String> map;
	private boolean found;

	public Graph(String line)
	{
		map = new TreeMap<String, String>();
		found = false;

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

	public void check(String first, String second, String placesUsed)
	{
		if (map.get(first).contains(second)) {
			found = true;
		}
		else {
			for (int i = 0; i < map.get(first).length(); i++) {
				if (!placesUsed.contains(map.get(first).substring(i, i + 1))) {
					check(map.get(first).substring(i, i + 1), second, placesUsed + first);
				}
			}
		}
	}

	public String toString()
	{
		if (found) {
			return "yes";
		}
		return "no";
	}
}