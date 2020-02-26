
public class MisplacedTileHeuristic implements IHeuristic {

	public MisplacedTileHeuristic(PuzzleState p, boolean accountForEmptyTile) {
		
		this.p = p;
		this.accountForEmptyTile = accountForEmptyTile;
	}
	
	@Override
	public int getHeuristic() {
		
		return getMisplacedTileHeuristic();
	}
	
	private int getMisplacedTileHeuristic() {
		
		int sum = 0;
		
		for (Integer i : p)
	
			if (i != 0 || accountForEmptyTile) {
				sum += getElementMisplacedTileHeuristic(i);
			}

		return sum;
	}
	
	private int getElementMisplacedTileHeuristic(Integer element) {
		
		// Code copied from ManhattanDistHeuristic
		// (I wrote that too, no plagiarism here dw)
		int expectedX;
		int expectedY;
		
		if (element == 0)
			expectedX = expectedY = p.gridWidth() - 1;
			
		else {
			
			expectedX = (element - 1) % p.gridWidth();
			expectedY = (element - 1) / p.gridWidth();
		}
		
		// Doesn't check for duplicate tiles in p,
		// this should be handled by p
		return p.get(expectedX, expectedY) == element ? 0 : 1;
	}
	
	private PuzzleState p;
	boolean accountForEmptyTile;

}
