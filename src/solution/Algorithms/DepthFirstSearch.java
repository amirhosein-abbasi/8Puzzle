import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Stream;

public class DepthFirstSearch implements GameSolverInterface {
	public static void solve(GameModel problem) {
		
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



}