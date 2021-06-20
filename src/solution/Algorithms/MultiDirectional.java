import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Stream;


public class MultiDirectional {

    public void solve(GameModel initSearch) {
		GameModel goalSearch=new GameModel ("012345678") ;
		
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
