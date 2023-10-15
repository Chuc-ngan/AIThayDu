package Lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeUtils {
	public static List<String> printPath(Node node) {
		if (node != null) {
			List<String> result = new ArrayList<String>();
			result.add(node.getLabel());
			Node tmp;
			while ((tmp = node.getParent()) != null) {

				result.add(tmp.getLabel());
				node = tmp;
			}
			Collections.reverse(result);
			return result;
		} else
			return new ArrayList<String>();
	}
	public static void print(Node node) {
		if (node == null) {
			System.out.println("null\n");
			return;
		}
		List<String> path = printPath(node);
		StringBuilder builder = new StringBuilder();
		for (String str : path)
			builder.append(str + " —> ");
		System.out.println(builder.substring(0, builder.length() - 4));
		System.out.println(node.getPathCost() + "\n");
	}
	
}
