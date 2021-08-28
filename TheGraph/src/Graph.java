/**
 * Jessica Cheng
 * CS 310
 * Lab 3
 */
import java.util.*;

public class Graph {

	private Map<String, Map<String, Integer>> mapViet = new HashMap<>();
	private List<String> city1 = new ArrayList<>();
	private List<String> city2 = new ArrayList<>();
	private List<Integer> edgeWeight = new ArrayList<>();
	private List<String> inbound = new ArrayList<>();
	private List<String> outbound = new ArrayList<>();
	private List<String> selfEdge = new ArrayList<>();
	private List<String> v1 = new ArrayList<>();
	private List<String> v2 = new ArrayList<>();
	private int countVertices = 0;
	private int heaviestWeight;

	public Graph() {

	}
	
 
	protected boolean addEdge(String source, String destination, int cost) {
		if (contains(source, destination)) {
			mapViet.get(source).put(destination, cost);
		}

		if (source.equals(destination)) {
			selfEdge.add(source);
		}

		
		return false;

	}

	protected boolean removeEdges(String source, String destination) {
		if (contains(source, destination)) {
			mapViet.get(source).remove(destination);
		}
		return false;

	}

	protected void addVertex(String name) {
		if (!contains(name)) {
			mapViet.put(name, new HashMap<>());
			countVertices++;
		}

	}

	protected boolean removeVertex(String name) {
		if (contains(name)) {
			mapViet.get(name).clear();
		}
		return false;

	}

	protected boolean contains(String name) {
		if (mapViet.containsKey(name)) {
			return true;
		}

		return false;

	}

	protected boolean contains(String source, String destination) {
		if (mapViet.containsKey(source) || mapViet.containsKey(destination)) {
			return true;
		}

		return false;
	}

	protected void outbound() {
		for (Map.Entry<String, Map<String, Integer>> out : mapViet.entrySet()) {
			if (out.getValue().isEmpty()) {
				outbound.add(out.getKey());
			}
		}
	}

	protected void inbound() {
		for (Map.Entry<String, Map<String, Integer>> in : mapViet.entrySet()) {
			for (Map.Entry<String, Integer> in2 : in.getValue().entrySet()) {
				city1.add(in2.getKey());
			}
		}

		for (Map.Entry<String, Map<String, Integer>> inbounds : mapViet.entrySet()) {
			city2.add(inbounds.getKey());
		}

		for (int i = 0; i < city2.size(); i++) {
			if (!city1.contains(city2.get(i))) {
				inbound.add(city2.get(i));
			}
		}

	}

	protected void heaviestEdge() {
		for (Map.Entry<String, Map<String, Integer>> edge : mapViet.entrySet()) {
			for (Map.Entry<String, Integer> edge2 : edge.getValue().entrySet()) {
				edgeWeight.add(edge2.getValue());
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < edgeWeight.size(); i++) {
			if (edgeWeight.get(i) > max) {
				setHeaviestWeight(edgeWeight.get(i));
				max = getHeaviestWeight();
			}
		
		}

		for (Map.Entry<String, Map<String, Integer>> edgeCity : mapViet.entrySet()) {
			for (Map.Entry<String, Integer> edgeCity1 : edgeCity.getValue().entrySet()) {
				if (edgeCity1.getValue() == max) {
					v1.add(edgeCity.getKey());
					v2.add(edgeCity1.getKey());
				}

			}
		}

	}

	/*
	 * getters and setters
	 */
	public List<String> getSelfEdge() {
		return selfEdge;
	}

	public void setSelfEdge(List<String> selfEdge) {
		this.selfEdge = selfEdge;
	}

	public void setCountVertices(int countVertices) {
		this.countVertices = countVertices;
	}

	public int getCountVertices() {
		return countVertices;
	}

	public List<String> getInbound() {
		return inbound;
	}

	public void setInbound(List<String> inbound) {
		this.inbound = inbound;
	}

	public List<String> getOutbound() {
		return outbound;
	}

	public void setOutbound(List<String> outbound) {
		this.outbound = outbound;
	}

	public int getHeaviestWeight() {
		return heaviestWeight;
	}

	public void setHeaviestWeight(int heaviestWeight) {
		this.heaviestWeight = heaviestWeight;
	}

	public List<String> getV1() {
		return v1;
	}

	public void setV1(List<String> v1) {
		this.v1 = v1;
	}

	public List<String> getV2() {
		return v2;
	}

	public void setV2(List<String> v2) {
		this.v2 = v2;
	}

}
