
public class Problem {

	public Problem(PuzzleState initialState, IHeuristic heuristic) {
		
		this.initialState = initialState;
		this.heuristic = heuristic;
	}
	
	public boolean solve() {
		
		return false; // TODO
	}
	
	private PuzzleState initialState;
	private IHeuristic heuristic;
	
}
