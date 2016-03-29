import java.util.ArrayList;

public interface State
{
	// determine if current state is goal
	boolean isGoal();

	// generate successors to the current state
	ArrayList<State> genSuccessors();

	// determine cost from initial state to THIS state
	double findCost();

	// print the current state
	public void printState();

	// compare the actual state data
	public boolean equals(State s);
}
