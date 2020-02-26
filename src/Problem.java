import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Problem {

	public Problem(PuzzleState initialState, IHeuristic heuristic) {
		
		init(initialState, heuristic, true, true);
	}
	
	public Problem(PuzzleState initialState, IHeuristic heuristic,
			boolean enableStackTrace, boolean enableExpansionTree) {
		
		init(initialState, heuristic, enableStackTrace, enableExpansionTree);
	}
	
	private void init(PuzzleState initialState, IHeuristic heuristic,
			boolean enableStackTrace, boolean enableExpansionTree) {
		
		this.initialState = initialState;
		this.heuristic = heuristic;
		this.enableStackTrace = true;
		this.enableExpansionTrace = true;
	}
	
	public boolean solve() {
		

		
		// Init the root node as the given PuzzleState
		Node root = new Node(initialState, null, (IHeuristic) heuristic.clone());
		
		// Account for the trivial case
		if (root.isGoal()) {
			
			printStackTrace(root);
			printEndStats(0, 0);
			return true;
		}
		

		
		// Prepare local variables for the loop
		Queue<Node> frontier = new PriorityQueue<Node>();
		frontier.addAll(root.generateChildren());
		
		int maxFrontierSize = frontier.size();
		int nodesExpanded = 0;
		
		Set<PuzzleState> explored = new HashSet<PuzzleState>();
		explored.add(initialState); // should this be empty?
		
		if (enableExpansionTrace)
			System.out.println("Starting at initial state\n" + root);
		
		
		
		// Only exit this loop upon finding a solution,
		// or exhausting all possibilities
		while (!frontier.isEmpty()) {
			
			// This draws on g(n) and h(n)
			// See Node.compareTo() for proof
			Node leaf = frontier.remove();
			
			// If we've found the solution, we're done
			if (leaf.isGoal()) {
				
				printStackTrace(leaf);
				printEndStats(maxFrontierSize, nodesExpanded);
				return true;
			}
			
			
			
			// Else, we need to expand
			explored.add(leaf.getPuzzleState());
			
			if (enableExpansionTrace)
				System.out.println("Expanding this leaf,\n" +
						"with g(n) = " + leaf.getDepth() + 
						" and h(n) = " + leaf.getHeuristicValue() + "\n" + leaf);
	
			// Add children to frontier,
			// if they're not in explored or frontier already
			Set<Node> leafChildren = leaf.generateChildren();
			for (Node thisChild : leafChildren) {
				
				if (!explored.contains(thisChild.getPuzzleState())
						&& !frontier.contains(thisChild)) // do we really need to check the frontier?
					
					frontier.add(thisChild);
					
			}
			
			// Account for end stats before executing loop again
			if (frontier.size() > maxFrontierSize)
				maxFrontierSize = frontier.size();
			
			nodesExpanded++;
			
		}
		
		// If you're here, there was no solution
		printEndStats(maxFrontierSize, nodesExpanded);
		return false;
	}
	
	private void printEndStats(int maxFrontierSize, int nodesExpanded) {
		
		System.out.println("This algorithm expanded a total of "
				+ nodesExpanded + " times.");
		System.out.println("The maximum number of nodes in the queue at any one time was "
				+ maxFrontierSize + ".");
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
	private boolean enableExpansionTrace;
	
}
