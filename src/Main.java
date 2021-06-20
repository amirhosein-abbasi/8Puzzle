
public class Main {

	public static void main(String[] args) {
		
		
		String init="120345678" ; // string of initial game state
		GameModel problem=new GameModel(init) ;
		
		//choose "dfs" or "astar" or "multidir"
		GameSolver solver=new GameSolver ("dfs");
		if(solver!=null) solver.solve();
	}

}
