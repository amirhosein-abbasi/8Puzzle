import java.util.Vector;

public class State {

	String state ;
	String parentNode ;
	int level ;
	int pathCost;
	boolean visited ;
	Vector<Action> actions ;
	
	State(){
		visited=false ;
		level=0 ;
		actions=new Vector<Action>() ;
	}
	
}
