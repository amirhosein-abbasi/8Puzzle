public interface GameInterface {
    public State initial_state();
    public Vector<Action> actions (State state);
    public State testState(String toAdd);
    public State result (State state , Action action);
    public boolean goal_test(State state);
    public int action_cost(State state , Action action);
    public int path_cost (State state,  Action action);
    public int heuristic_cost(State state);
}
