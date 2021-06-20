import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Stream;


public class AStar implements GameSolverInterface {

    public void solve(GameModel problem) {
		
		int node_visited=0 ;
		int node_extended=0 ;
		
		int max_memory_used=0 ;
		int memory_using=0 ;
		
		int path_cost = 0 ;
		int totalCost=0 ;
		int stepCost=0 ;
		
		Stack<State> pathStack=new Stack<State>() ;
		State currentState=new State() ;
		
		
		State initialState=problem.initial_state() ;
		currentState=initialState ;
		pathStack.add(initialState);
		memory_using++ ;
		
		while(!problem.goal_test(currentState)){
			currentState=pathStack.pop() ;
			memory_using-- ;
			System.out.println(currentState.state);
			currentState.visited=true ;
			
			Vector<Action> actions=new Vector<Action>() ;
			actions=problem.actions(currentState) ;
			totalCost=Integer.MAX_VALUE ;
			State selectedCity = null ;
			int selectedCityStepCost=0 ;
			
			for(Action act : actions){
				int pathToSelected=0 ;
				int heuristic_action=problem.heuristic_cost(problem.result(currentState, act)) ;
				pathToSelected=path_cost+problem.action_cost(currentState, act) ;
				if(pathToSelected+ heuristic_action < totalCost && problem.result(currentState, act).visited!=true ){
					totalCost = pathToSelected+ heuristic_action ;
					selectedCity=problem.result(currentState, act) ;
					selectedCityStepCost=problem.action_cost(currentState, act) ;
				}
				node_visited++ ;
			}
			node_extended++ ;
			pathStack.add(selectedCity) ;
			memory_using++ ;
			currentState=selectedCity ;
			path_cost=path_cost + selectedCityStepCost ;
			if(memory_using>max_memory_used)
				max_memory_used=memory_using ;
		}
		if(memory_using>max_memory_used)
			max_memory_used=memory_using ;
		currentState=pathStack.pop() ;
		
		System.out.println(currentState.state);
		currentState.visited=true ;
		System.out.println("The Total Path Cost Is : "+path_cost);
		System.out.println("The Number Of Node Visited Is : "+node_visited);
		System.out.println("The Number Of Node Extended Is : "+node_extended);
		System.out.println("The Maximum Memory Used By Nodes Is : "+max_memory_used);
		
	}
}
