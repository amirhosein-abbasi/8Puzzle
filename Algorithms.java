import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Stream;




public class Algorithms {

	
	
	public static void DFS(Problem_8puzzle problem) {
		
		int node_visited=0 ;
		int node_extended=0 ;
		
		int max_memory_used=0 ;
		int memory_using=0 ;
		int path_cost = 0 ;
		
		Stack<State> stack=new Stack() ;
		Stack<State> path_stack=new Stack() ;
		State currentState=null ;
		Vector<Action> acts ;
		
		State initialState=problem.initial_state() ;
		stack.add(initialState) ;
		path_stack.add(initialState) ;
		memory_using++ ;
		initialState.visited=true ;
		
		
		while(!stack.isEmpty()) {
					currentState = (State) stack.pop() ;
					memory_using-- ;
					path_stack.add(currentState) ;
					memory_using++ ;
					
					acts =problem.actions(currentState) ;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(currentState.state);
					currentState.visited=true ;
		
					
					
					if(problem.goal_test(currentState))
					{
						System.err.println("path cost is : "+path_cost);
						System.err.println("node visited is : "+node_visited);
						System.err.println("node extende is : "+node_extended);
						System.err.println("max memory used is "+max_memory_used);
						return ;
					}
					
					
				for(Action act : acts){
						if(problem.result(currentState,act).visited!=true && problem.result(currentState,act)!=null)
						{
								problem.result(currentState,act).parentNode=currentState.state ;
								stack.add(problem.result(currentState,act)) ;
								problem.result(currentState,act).visited=true ;
								
								memory_using++ ;
								node_visited++ ;
						}
					}
				
					node_extended++ ;
					
			if(memory_using>max_memory_used)
				max_memory_used=memory_using ;
			}
		}
	
	public void A_star(Problem_8puzzle problem) {
		
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
	
	
	public void multiDirectional(Problem_8puzzle initSearch) {
		
		Problem_8puzzle goalSearch=new Problem_8puzzle ("012345678") ;
		
		Stack visitedNodes=new Stack<State>() ;
		int turn = 0;
			
		int node_visited=0 ;
		int node_extended=0 ;
		
		int max_memory_used=0 ;
		int memory_using=0 ;
		
		int path_cost = 0 ;
		
		State initialState=initSearch.initial_state() ;
		State finalState=goalSearch.initial_state() ;
		
		Queue<State> startQueue = new LinkedList<State>() ;
		Queue<State> finalQueue = new LinkedList<State>() ;
		startQueue.add(initialState) ;
		finalQueue.add(finalState) ;
		memory_using++ ;	
		memory_using++ ;	
		Stack<State> startPath = new Stack<State>() ;
		Stack<State> finalPath = new Stack<State>() ;
	
		Stack<State> commonStates=new Stack<State>() ;
			while(true){
				commonStates=startPath ;
				commonStates.retainAll(finalPath) ;
			if(commonStates.isEmpty())
			 searchStep( initSearch ,startQueue,startPath, memory_using, max_memory_used, node_visited, node_extended) ;
			commonStates=startPath ;
			commonStates.retainAll(finalPath) ;
			if(commonStates.isEmpty())
			 searchStep( goalSearch ,finalQueue,finalPath, memory_using, max_memory_used, node_visited, node_extended) ;
			commonStates=startPath ;
			commonStates.retainAll(finalPath) ;
			if(!commonStates.isEmpty()){
				for(State s:startPath)
					System.err.println(s.state);
				for(State f:finalPath)
					System.err.println(f.state);
				return ;
			}
			}
		
		
	}
	public void searchStep(Problem_8puzzle problem , Queue<State> queue ,Stack<State> path,int memory_using,int max_memory_used,int node_visited,int node_extended){
			if(!queue.isEmpty()){
				State currentState = (State) queue.remove() ;
				 memory_using-- ;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(currentState.state);
				path.add(currentState) ;			
				Vector<Action> actions ;
				actions=problem.actions(currentState) ;
				
				for(Action act :actions){	
				  queue.add(problem.result(currentState,act)) ;
				  memory_using++ ;
				  node_visited++ ;
				}
				if (memory_using>max_memory_used)
				{
					max_memory_used = memory_using ;
				}
				node_extended++ ;	
			}
	}
	
}
