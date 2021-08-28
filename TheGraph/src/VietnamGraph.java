/**
 * Jessica Cheng
 * CS 310
 * Lab 3
 */

import java.io.*;
import java.util.*;

public class VietnamGraph {

	public static void main(String[] args) {
		try {
			readCSV(args);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void readCSV(String[] args) throws FileNotFoundException {
		String vietnamCities = args[0];
		Scanner readFile = new Scanner(new File(vietnamCities));
		List<String> city = new ArrayList<>();

		while (readFile.hasNext()) {
			Scanner reader = new Scanner(readFile.nextLine());
			reader.useDelimiter("\n");

			while (reader.hasNext()) {
				city.add(reader.next());
			}

			reader.close();

		}

		readFile.close();
		
		createGraph(city);
		
	}
	
	
	private static void createGraph(List<String> city) {

		String v1;
		String v2;
		int cost;

		Graph graph = new Graph();

		for (int i = 0; i < city.size(); i++) {
			String line = city.get(i);

			if (line.contains(",")) {
				v1 = line.substring(0, line.indexOf(","));
				v2 = line.substring(line.indexOf(",") + 1, line.lastIndexOf(","));
				cost = Integer.parseInt(line.substring(line.lastIndexOf(",") + 1));
				graph.addVertex(v1);
				graph.addVertex(v2);
				graph.addEdge(v1, v2, cost);
			} else {
				v1 = line.substring(0);
				graph.addVertex(v1);

			}
			

		}
		
		graph.outbound();
		graph.inbound();
		graph.heaviestEdge();
		System.out.println("Number of vertices: " + graph.getCountVertices());
		System.out.println("Vertices with zero inbound edges: " + graph.getInbound());
		System.out.println("Vertices with zero outbound edges: " + graph.getOutbound());
		System.out.println("Vertices with self edges: " + graph.getSelfEdge());
		
		
		System.out.println("Heaviest Weight: ");
		for(int i = 0; i < graph.getV1().size(); i++) {
			System.out.println(graph.getV1().get(i) + " to " + graph.getV2().get(i) + " - " + graph.getHeaviestWeight());
		}
		
	}

	

}
