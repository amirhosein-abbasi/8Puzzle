

import java.util.Vector;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class Problem_8puzzle {
	String input ;
	Vector<State> allStates ;
	
	Problem_8puzzle(String init){
		input = init ;
		allStates=new Vector<State>() ;
	}
	
	public State initial_state(){
		State initial = new State () ;
		initial.state =input ;
		allStates.add(initial) ;
		return initial;
	}
	

	public Vector<Action> actions (State state){
		int zeroIndex=state.state.indexOf("0") ;
		if(state.actions.isEmpty()){
			if(zeroIndex==0){
				Action action1=new Action() ;
				Action action2=new Action() ;
				action1.doAction="right" ;
				action2.doAction="down" ;
				state.actions.add(action1) ;
				state.actions.add(action2) ;
				return state.actions ;
			}
			else if(zeroIndex==1){
				Action action3=new Action() ;
				Action action4=new Action() ;
				Action action5=new Action() ;
				action3.doAction="right" ;
				action4.doAction="down" ;
				action5.doAction="left" ;
				state.actions.add(action5) ;
				state.actions.add(action3) ;
				state.actions.add(action4) ;
				return state.actions ;
			}
			else if(zeroIndex==2){
				Action action6=new Action() ;
				Action action7=new Action() ;
				action6.doAction="left" ;
				action7.doAction="down" ;
				state.actions.add(action6) ;
				state.actions.add(action7) ;	
				return state.actions ;
			}
			else if(zeroIndex==3){
				Action action8=new Action() ;
				Action action9=new Action() ;
				Action action10=new Action() ;
				action8.doAction="up" ;
				action9.doAction="right" ;
				action10.doAction="down" ;
				state.actions.add(action8) ;
				state.actions.add(action10) ;
				state.actions.add(action9) ;
				return state.actions ;
			}
			else if(zeroIndex==4){
				Action action11=new Action() ;
				Action action12=new Action() ;
				Action action13=new Action() ;
				Action action14=new Action() ;
				action11.doAction="left" ;
				action12.doAction="up" ;
				action13.doAction="right" ;
				action14.doAction="down" ;
				state.actions.add(action11) ;
				state.actions.add(action12) ;
				state.actions.add(action13) ;
				state.actions.add(action14) ;
				return state.actions ;
			}
			else if(zeroIndex==5){
				Action action15=new Action() ;
				Action action16=new Action() ;
				Action action17=new Action() ;
				action15.doAction="up" ;
				action16.doAction="left" ;
				action17.doAction="down" ;
				state.actions.add(action15) ;
				state.actions.add(action16) ;
				state.actions.add(action17) ;
				return state.actions ;
			}
			else if(zeroIndex==6){
				Action action18=new Action() ;
				Action action19=new Action() ;
				action18.doAction="up" ;
				action19.doAction="right" ;
				state.actions.add(action18) ;
				state.actions.add(action19) ;
				return state.actions ;
			}
			else if(zeroIndex==7){
				Action action20=new Action() ;
				Action action21=new Action() ;
				Action action22=new Action() ;
				action20.doAction="up" ;
				action21.doAction="left" ;
				action22.doAction="right" ;
				state.actions.add(action20) ;
				state.actions.add(action21) ;
				state.actions.add(action22) ;
				return state.actions ;
			}
			else if(zeroIndex==8){
				Action action23=new Action() ;
				Action action24=new Action() ;
				action23.doAction="up" ;
				action24.doAction="left" ;
				state.actions.add(action23) ;
				state.actions.add(action24) ;
				return state.actions ;
			}
			else
				return state.actions ;
			}
		return state.actions ;
		}
	
	 public State testState(String toAdd)
	{
		 for(State l : allStates){
			 if(l.state.equalsIgnoreCase(toAdd)){
				 return l ;
			 }
		 }
		return null ;
	}
	
	public State result (State state , Action action){
		
		int zeroIndex = state.state.indexOf("0") ;
		
		if(action.doAction.equalsIgnoreCase("up")){
			String nxtState ;
			nxtState=state.state.substring(0,zeroIndex-3)+
					"0"+
					state.state.substring(zeroIndex-2,zeroIndex)+
					state.state.charAt(zeroIndex-3)+
					state.state.substring(zeroIndex+1) ;
			if(testState(nxtState)==null){
			action.actionResult=new State() ;
			action.actionResult.state=nxtState ;
			action.actionResult.parentNode=state.state ;
			action.actionResult.level=state.level+1 ;
			}else
				action.actionResult=testState(nxtState) ;
		}
		else if(action.doAction.equalsIgnoreCase("left")){
			String nxtState ;
			nxtState=state.state.substring(0,zeroIndex-1)+
					"0"+
					state.state.charAt(zeroIndex-1)+
					state.state.substring(zeroIndex+1) ;
			if(testState(nxtState)==null){
				action.actionResult=new State() ;
				action.actionResult.state=nxtState ;
				action.actionResult.parentNode=state.state ;
				action.actionResult.level=state.level+1 ;
				}else
					action.actionResult=testState(nxtState) ;
		}
		else if(action.doAction.equalsIgnoreCase("right")){
			String nxtState ;
			nxtState=state.state.substring(0,zeroIndex)+
					state.state.charAt(zeroIndex+1)+
					"0"+
					state.state.substring(zeroIndex+2) ;
			if(testState(nxtState)==null){
				action.actionResult=new State() ;
				action.actionResult.state=nxtState ;
				action.actionResult.parentNode=state.state ;
				action.actionResult.level=state.level+1 ;
				}else
					action.actionResult=testState(nxtState) ;
		}
		else if(action.doAction.equalsIgnoreCase("down")){
			String nxtState ;
			nxtState=state.state.substring(0,zeroIndex)+
					state.state.charAt(zeroIndex+3)+
					state.state.substring(zeroIndex+1,zeroIndex+3)+
					"0"+
					state.state.substring(zeroIndex+4) ;
			if(testState(nxtState)==null){
				action.actionResult=new State() ;
				action.actionResult.state=nxtState ;
				action.actionResult.parentNode=state.state ;
				action.actionResult.level=state.level+1 ;
				}else
					action.actionResult=testState(nxtState) ;
		}
		return action.actionResult ;
		}
		
	public boolean goal_test(State state){
		if(state.state.equalsIgnoreCase("012345678"))
			return true ;
		else
		return false;	
	}
	public int action_cost(State state , Action action){
		return 1 ;
	}
	public int path_cost (State state,  Action action){
	return state.pathCost+1 ; 
	}
	public int heuristic_cost(State state){
		int zeroIndex=state.state.indexOf("0") ;
		if(zeroIndex==0)
			return 0 ;
		if(zeroIndex==1)
			return 1 ;
		if(zeroIndex==2)
			return 2 ;
		if(zeroIndex==3)
			return 1 ;
		if(zeroIndex==4)
			return 2 ;
		if(zeroIndex==5)
			return 3 ;
		if(zeroIndex==6)
			return 2 ;
		if(zeroIndex==7)
			return 3 ;
		if(zeroIndex==8)
			return 4 ;
		else 
			return 0 ;
	}

	
}
