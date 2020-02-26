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
	
	Set<Node> generateChildren() {
		
		Set<PuzzleState.Command> cmds = data.possibleCommands();
		Set<Node> children = new HashSet<Node>();
		
		for (PuzzleState.Command thisCmd : cmds) {
			
			PuzzleState newP = new PuzzleState(this.data);
			newP.slide(thisCmd);
			
			try {
				
				children.add(new Node(newP, this, (IHeuristic) this.heuristic.clone()));
				
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				// this... should never get here lol
				e.printStackTrace();
			}
		}
		
		return children;	
	}
	
	@Override
	public int compareTo(Node other) {
		
		return (int) Math.signum((this.depth + this.heuristic.getHeuristic())
			- (other.depth + other.heuristic.getHeuristic()));
	}
	
	public Stack<Node> stackTrace() {
		
		return stackTrace(new Stack<Node>());
	}
	
	private Stack<Node> stackTrace(Stack<Node> existingStack) {
		
		if (parent == null) {
			
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
