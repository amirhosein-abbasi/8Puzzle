public class GameSolver {
    GameSolver (string algorithm){
        if(algorithm == "astar")
            return new AStar();
        if(algorithm == "dfs")
            return new DepthFirstSearch();
        if(algorithm == "multidir")
            return new MultiDirectional();
        return null;
    }
}
