import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Problem {

	public Problem(PuzzleState initialState, IHeuristic heuristic) {
		
		this.initialState = initialState;
		this.heuristic = heuristic;
		this.enableStackTrace = true;
	}
	
	public boolean solve() {
		
		Node root = new Node(initialState, null, (IHeuristic) heuristic.clone());
		
		if (root.isGoal()) {
			
			printStackTrace(root);
			return true;
		}
		
		Queue<Node> frontier = new PriorityQueue<Node>();
		frontier.addAll(root.generateChildren());
		
		Set<PuzzleState> explored = new HashSet<PuzzleState>();
		explored.add(initialState); // should this be empty?
		
		System.err.println("Starting at initial state\n" + root);
		
		while (!frontier.isEmpty()) {
			
			Node leaf = frontier.remove();
			
			System.err.println("Expanding this leaf:\n" + leaf);
			
			if (leaf.isGoal()) {
				
				printStackTrace(leaf);
				return true;
			}
			
			explored.add(leaf.getPuzzleState());
			
			// Add children to frontier,
			// if they're not in explored or frontier already
			Set<Node> leafChildren = leaf.generateChildren();
			for (Node thisChild : leafChildren) {
				
				if (!explored.contains(thisChild.getPuzzleState())
						&& !frontier.contains(thisChild)) // do we need to check the frontier?
					
					frontier.add(thisChild);
					
			}
			
		}
		return false;
	}
	
	private void printStackTrace(Node goalNode) {
		
		assert(goalNode.isGoal());
		
		if (!enableStackTrace) return;
		
		System.out.println("STACK TRACE BEGIN\n==============\n");
		
		Stack<Node> stackTrace = goalNode.stackTrace();
		
		while (!stackTrace.empty()) {
			
			System.out.println(stackTrace.pop());
		}
		
		System.out.println("STACK TRACE END\n================\n");
	}
	
	private PuzzleState initialState;
	private IHeuristic heuristic;
	private boolean enableStackTrace;
	
}
