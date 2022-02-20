/*
 ================================ Bredth First Serach ================================
 In the code below I have used adjacency list to create a simple graph rather than 
 using the mainstarem adjacency matrix approach. The traversal done here is in level
 order manner of the graph instantiated in the "main" function of "BFS" class.

 "node" is intermediary datastructure created to represent the vertex of the graph 
 which have certain property viz., value that it holds, boolean to assert wheather 
 it has been visited or not and a vector of "node" objects which are adjacent to it.

 "graph" class handles the chaos of instantiating a adjacency list, mainitaining it 
 and providing a neat implementation of traversal process in level order fashion.
 =====================================================================================

 Authored By : TensorNd


*/

import java.util.*;

class node{
	int value;
	boolean visited;
	Vector<node> neighbours=new Vector<node>();
	node(int val){
		this.value=val;
		this.visited=false;
	}
	int getValue(){
		return(this.value);
	}
	void addNeighbour(node newNode){
		this.neighbours.add(newNode);
	}
	void show(){
		System.out.print(this.value + " -> ");
		for(node n: this.neighbours){
			System.out.print(" "+ n.getValue()+ " ");
		}
		System.out.println();
	}
	void setVisitedStatus(boolean val){
		this.visited=val;
	}
	boolean getVisitedStatus(){
		return(this.visited);
	}
	Vector<node> getNeighbours(){
		return(this.neighbours);
	}
	void init(){
		this.visited=false;
	}
}

class graph{
	Vector<node> GRAPH_ADJACENCY_LIST = new Vector<node>();
	void createGraph(node newNode){
		this.GRAPH_ADJACENCY_LIST.add(newNode);
	}
	void show(){
		System.out.println("Adjacency List of the graph is :");
		for(node n: this.GRAPH_ADJACENCY_LIST){
			n.show();
		}
	}
	Vector<node> traverse(){
		Vector<node> result=new Vector<node>();
		Queue<node> visited=new LinkedList<node>();
		node current=new node(-1);
		if(this.GRAPH_ADJACENCY_LIST.size()==0){
                        System.out.println("Nothing to traverse!");
                        return(result);
                }
		visited.add(this.GRAPH_ADJACENCY_LIST.get(0));
		this.GRAPH_ADJACENCY_LIST.get(0).setVisitedStatus(true);
		while(visited.size()!=0){
			current=visited.remove();
			result.add(current);
			for(node n : current.getNeighbours()){
				if(n.getVisitedStatus()==false){
					visited.add(n);
					n.setVisitedStatus(true);
				}
			}
		}
		// wrapup the changes made to our nodes.
		for(node n : this.GRAPH_ADJACENCY_LIST){
			n.init();
		}
		return(result);
	}

}

public class BFS{
	public static void main(String args[]){
		graph g=new graph();
		Vector<node> traversal=new Vector<node>();
		node n1=new node(10);
		node n2=new node(40);
		node n3=new node(30);
		node n4=new node(20);
		n1.addNeighbour(n2);
		n1.addNeighbour(n3);
		n2.addNeighbour(n1);
		n2.addNeighbour(n4);
		n3.addNeighbour(n1);
		n3.addNeighbour(n4);
		n4.addNeighbour(n3);
		n4.addNeighbour(n2);
		g.createGraph(n1);
		g.createGraph(n2);
		g.createGraph(n3);
		g.createGraph(n4);
		g.show();
		traversal=g.traverse();
		System.out.print("\nTraversal of above graph is : ");
		for(node n : traversal){
			System.out.print(" "+n.getValue()+" ");
		}
		System.out.println();
	}
}
