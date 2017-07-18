
public class Main {

	public static void main(String[] args) {
		
		String init="120345678" ;
		Algorithms algorithms=new Algorithms() ;
		Problem_8puzzle problem=new Problem_8puzzle(init) ;

			//algorithms.DFS(problem);
			//algorithms.multiDirectional(problem);
			algorithms.A_star(problem) ;
	}

}
