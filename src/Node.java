import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Node implements Comparable<Node> {

	public Node(PuzzleState p, Node parent, IHeuristic heuristic) {
		
		data = p;
		this.parent = parent;
		this.heuristic = heuristic;
		depth = (parent == null ? 0 : parent.depth + 1);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("-------------\n");
		sb.append((parent == null ? "Root node\n" : "Not a root node\n"));
		sb.append("Depth: " + depth + "\n");
		sb.append("Heuristic: " + heuristic.getClass().getSimpleName() + "\n");
		sb.append(data);
		sb.append("-------------\n");
		
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (!(o instanceof Node)) return false;
		
		Node other = (Node) o;
		
		return this.data.equals(other.data)
				&& this.parent == other.parent
				&& this.depth == other.depth
				&& this.heuristic.getClass() == other.heuristic.getClass();
	}

	@Override
	public int hashCode() {
		
		return data.hashCode() + this.heuristic.getClass().toString().hashCode()
				- (depth * 31) - (parent == null? 31 : 0);
	}
	
	Set<Node> generateChildren() {
		
		Set<PuzzleState.Command> cmds = data.possibleCommands();
		Set<Node> children = new HashSet<Node>();
		
		for (PuzzleState.Command thisCmd : cmds) {
			
			PuzzleState newP = new PuzzleState(this.data);
			newP.slide(thisCmd);
			
			IHeuristic newH = (IHeuristic) this.heuristic.clone();
			newH.setPuzzleState(newP);
			
			children.add(new Node(newP, this, newH));

		}
		
		return children;	
	}
	
	@Override
	public int compareTo(Node other) {
		
		return (int) Math.signum(this.getCost() - other.getCost());
	}
	
	public int getCost() {
		
		return depth + heuristic.getHeuristic();
	}
	
	public Stack<Node> stackTrace() {
		
		return stackTrace(new Stack<Node>());
	}
	
	public boolean isGoal() {
		
		return data.isGoal();
	}
	
	public int getDepth() {
		
		return depth;
	}
	
	public int getHeuristicValue() {
		
		return heuristic.getHeuristic();
	}
	
	public PuzzleState getPuzzleState() {
		
		return data;
	}
	
	private Stack<Node> stackTrace(Stack<Node> existingStack) {
		
		if (parent == null) {
			
			existingStack.push(this);
			return existingStack;
		}
		
		existingStack.push(this);
		return parent.stackTrace(existingStack);
	}
	
	
	
	private PuzzleState data;
	private Node parent;
	private IHeuristic heuristic;
	private int depth;

}
