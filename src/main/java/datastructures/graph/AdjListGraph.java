package datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AdjListGraph implements Graph{
	int vertices;
	ArrayList<ArrayList<Integer>> adjList;
	
    public AdjListGraph(int v) {
		this.vertices = v;
		adjList = new ArrayList<ArrayList<Integer>>(this.vertices);
		for(int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
	}

	@Override
	public void addEdge(int u, int v) {
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}
	
	public int[] computeIndegree() {
		int[] inDegrees = new int[vertices];
		Arrays.fill(inDegrees, 0);
		for(ArrayList<Integer> list: adjList) {
			for(int v: list) {
				inDegrees[v]++;
			}
		}
		return inDegrees;
	}
	
	public int[] computeOutDegree() {
		int[] outDegrees = new int[vertices];
		Arrays.fill(outDegrees, 0);
		for(int i = 0; i < vertices; i++) {
			outDegrees[i] = adjList.get(i).size();
		}
		return outDegrees;
	}
	
	
	public ArrayList<Integer> BFSConnected(int source, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		visited[source] = true;
		q.add(source);
		while(!q.isEmpty()) {
			int u = q.poll();
			result.add(u);
			for(int v: adjList.get(u)) {
				if(visited[v] == false) {
					visited[v] = true;
					q.add(v);
				}
			}
		}
		return result;
	}
	
	public ArrayList<Integer> BFS(){
		boolean visited[] = new boolean[vertices + 1];
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < vertices; i++) {
			if(visited[i] == false) {
				result.addAll(BFSConnected(i,visited));
			}
		}
		return result;
	}
	
	
	public int countIslandsBFS(){
		boolean visited[] = new boolean[vertices + 1];
		int count = 0;
		for(int i = 0; i < vertices; i++) {
			if(visited[i] == false) {
				BFSConnected(i,visited);
				count++;
			}
		}
		return count;
		
	}
	
	void DFSRec(int source, boolean[] visited) {
		visited[source] = true;
		System.out.print(source + " ");
		for(int v: adjList.get(source)) {
			if(visited[v] == false) {
				DFSRec(v, visited);
			}
		}
	}
	
	void DFS(int source) {
		boolean[] visited = new boolean[vertices];
		DFSRec(source, visited);
		
	}
	
	void DFS() {
		boolean[] visited = new boolean[vertices];
		for(int i = 0 ; i < vertices; i++) {
			if(visited[i] == false) {
				DFSRec(i, visited);
			}
		}
	}
	
	int CountIslandsDFS() {
		boolean[] visited = new boolean[vertices];
		int count = 0;
		for(int i = 0 ; i < vertices; i++) {
			if(visited[i] == false) {
				DFSRec(i, visited);
				count++;
			}
		}
		return count;
	}
	
	
	int[] shortestPath(int source) {
		int[] dist = new int[vertices];
		boolean[] visited = new boolean[vertices];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		visited[source] = true;
		dist[source] = 0;
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v: adjList.get(u)) {
				if(visited[v] == false) {
					visited[v] = true;
					q.add(v);
					dist[v] = dist[u] + 1;
				}
			}
		}
		return dist;
	}
	
	public boolean isCyclicUndirected()
    {
		boolean[] visited = new boolean[vertices];
		for(int i = 0 ; i < vertices; i++) {
			if(visited[i] == false) {
				if(isCyclicUndirectedRec(i, visited, -1) == true){
					return true;
				}
			}
		}
		return false;
    }
	
	public boolean isCyclicUndirectedRec(int source, boolean[] visited, int parent)
    {
		visited[source] = true;
		for(int v: adjList.get(source)) {
			if(visited[v] == false) {
				if(isCyclicUndirectedRec(v, visited, source) == true) {
					return true;
				}
			}
			else if(v != parent) {
				return true;
			}
		}
       return false;
    }
	
	public boolean isCyclicdirected()
    {
		boolean[] visited = new boolean[vertices];
		boolean[] recStack = new boolean[vertices];
		for(int i = 0 ; i < vertices; i++) {
			if(visited[i] == false) {
				if(isCyclicdirectedRec(i, visited, recStack) == true){
					return true;
				}
			}
		}
		return false;
    }
	
	public boolean isCyclicdirectedRec(int source, boolean[] visited, boolean[] recStack)
    {
		visited[source] = true;
		recStack[source] = true;
		for(int v: adjList.get(source)) {
			if(visited[v] == false && isCyclicdirectedRec(v, visited, recStack) == true) {
				return true;
			}
			else if(recStack[v] == true) {
				return true;
			}
		}
	   recStack[source] = false;
       return false;
    }
	
	
	public int[] topoSort() {
		int[] inDegrees = computeIndegree();
		int[] topSorting = new int[vertices];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < inDegrees.length; i++) {
			if(inDegrees[i] == 0) {
				q.add(i);
			}
		}
		int index = 0;
		while(!q.isEmpty()) {
			int u = q.poll();
			topSorting[index] = u;
			index++;
			for(int v: adjList.get(u)) {
				inDegrees[v]--;
				if(inDegrees[v] == 0) {
					q.add(v);
				}
			}
			
		}
		return topSorting;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < adjList.size();i++) {
			sb.append(i);
			for(int j = 0; j < adjList.get(i).size();j++) {
				sb.append("->"+adjList.get(i).get(j));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	  
	
	
	public static void main(String[] args) {
		AdjListGraph graph = new AdjListGraph(5);
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(1, 2);
		graph.addEdge(0, 4);
		System.out.println(graph);

	}

}
