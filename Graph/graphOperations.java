import java.util.*;
public class graph {
	int vertices;
	LinkedList<Integer> Graph[];
	
	//---Constructor for creating Graph ----
	public graph(int v)
	{
		this.vertices=v;
		Graph=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			Graph[i]=new LinkedList<>();
		}
	}
	
	//---Adding Edge (v->u) to the Graph  ---------
	void addEdge(int v,int u)
	{
		if(v<this.vertices&&u<this.vertices)
			Graph[v].add(u);
	}
	
	//-----Removing the edge (v->u) from the Graph
	void removeEdge(int v,int u)
	{
		if(v<this.vertices&&u<this.vertices)
			Graph[v].remove((Integer)u);
	}

	
	//---Printing Adjacency list Representation of Graph---
	void printGraph()
	{
		for(int i=0;i<vertices;i++)
		{
			System.out.print("Vertex "+i+" : "+i);
			for(Integer j:Graph[i])
			{
				System.out.print("->"+j);
			}
			System.out.println();
		}
	}
	
	 // ---Breadth First Traversal of the graph----
	 void BFS(int start)
	{
		Queue<Integer>queue=new LinkedList<Integer>();
		int visited[]=new int[vertices];
		queue.add(start);
		System.out.print("BFS traversal : ");
		while(!queue.isEmpty()){
			int k=queue.remove();
			visited[k]=1;
			for(int m:Graph[k]){
				if(visited[m]!=1){
					queue.add(m);
					visited[m]=1;
				}
			}
			System.out.print(k+" ");
		}
		System.out.println();
	}
	 
	 // ---Depth First Traversal of the graph ----
	 void DFS(int start)
		{
			Stack<Integer>stack=new Stack<Integer>();
			int visited[]=new int[vertices];
			stack.add(start);
			System.out.print("DFS traversal : ");
			while(!stack.isEmpty()){
				int k=stack.pop();
				visited[k]=1;
				for(int m:Graph[k]){
					if(visited[m]!=1){
						stack.add(m);
						visited[m]=1;
					}
					
				}
				System.out.print(k+" ");
			}
			System.out.println();
		}
	 
	 //----- printing nodes at given height-----
	 void nodesAtHeight(int start,int height)
	 {
		 Queue<Integer>queue=new LinkedList<Integer>();
			int visited[]=new int[vertices];
			int heightofNode[]=new int [vertices];
			queue.add(start);
			heightofNode[start]=0;
			System.out.print("Nodes at height "+height+" : ");
			if(height>=vertices)
				return;
			if(height==0){
				System.out.print(0);
				return;
			}
			while(!queue.isEmpty()){
				int k=queue.remove();
				visited[k]=1;
				for(int m:Graph[k]){
					if(visited[m]!=1){
						queue.add(m);
						visited[m]=1;
						heightofNode[m]=heightofNode[k]+1;
						if(heightofNode[m]==height)
							System.out.print(m+" ");
					}
				}
			}
			System.out.println();
	 }
	 
	public static void main(String[] args)
	{
		graph g1=new graph(9);
		g1.addEdge(0, 3);
		g1.addEdge(0, 2);
		g1.addEdge(3, 0);
		g1.addEdge(2, 0);
		g1.addEdge(1, 3);
		g1.addEdge(1, 4);
		g1.addEdge(2, 4);
		g1.addEdge(2, 6);
		g1.addEdge(3, 8);
		g1.addEdge(4, 7);
		g1.addEdge(4, 3);
		g1.addEdge(5, 6);
		g1.addEdge(5, 3);
		g1.addEdge(6, 4);
		g1.addEdge(7, 5);
		g1.addEdge(7, 6);
		g1.addEdge(8, 1);
		g1.addEdge(8, 0);
		g1.addEdge(8, 3);
		g1.removeEdge(8, 3);
		
		g1.printGraph();
		g1.BFS(3);
		g1.DFS(3);
		g1.nodesAtHeight(3,2);
	
	}

}
