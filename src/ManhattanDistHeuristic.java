import java.util.HashMap;
import java.util.Map;

public class ManhattanDistHeuristic implements IHeuristic {

	public ManhattanDistHeuristic(PuzzleState p, boolean accountForEmptyTile) {
		
		this.p = p;
		this.accountForEmptyTile = accountForEmptyTile;
		
		locations = new HashMap<Integer, int[]>();
				
		// First, map tiles to their destinations
		for (int y = 0; y < p.gridWidth(); y++) {
			for (int x = 0; x < p.gridWidth(); x++) {
				
				locations.put(p.get(x, y), new int[] { x, y });
			}
		}
	}
	
	@Override
	public Object clone() /*throws CloneNotSupportedException*/ {
		
		System.out.println("In ManhattanDistance.clone(), p[2][1] is " + p.get(2, 1));
		
		PuzzleState duplicatePS = new PuzzleState(p);
		
		return new ManhattanDistHeuristic(duplicatePS, accountForEmptyTile);
	}
	
	@Override
	public int getHeuristic() {

		return getManhattanSum();
	}
	
	private int getManhattanSum() {
		// Pseudocode adapted from this online explanation:
		// https://www.cs.princeton.edu/courses/archive/spring18/cos226/assignments/8puzzle/index.html
		
		int sum = 0;
		
		for (Integer i : p) {
			
			if (i != 0 || accountForEmptyTile)	// comment out to include empty tile placement
				sum += getElementManhattanDist(i);
			
			System.out.println("m_dist(" + i + "): " + getElementManhattanDist(i));
		}
		
		return sum;
	}
	
	private int getElementManhattanDist(int element) {
		
		assert(element >= 0 && element < Math.pow(p.gridWidth(), 2))
			: "Invalid element " + Integer.toString(element);
		assert(locations.containsKey(element))
			: "Element " + Integer.toString(element) + " not found in locations";
		
		int expectedX;
		int expectedY;
		
		if (element == 0)
			expectedX = expectedY = p.gridWidth() - 1;
			
		else {
			
			expectedX = (element - 1) % p.gridWidth();
			expectedY = (element - 1) / p.gridWidth();
		}
		
		
		int actualX = locations.get(element)[0];
		int actualY = locations.get(element)[1];
		
		return Math.abs(actualX - expectedX)
				+ Math.abs(actualY - expectedY);
	}
	
	private PuzzleState p;
	Map<Integer, int[]> locations;
	boolean accountForEmptyTile;
	
}
