import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PuzzleState {

	public PuzzleState(int[][] grid) {
		
		if (grid == null)
			throw new NullPointerException();
		
		this.grid = grid;
		
		assert(verify()) : "Bad input, dude";
	}

	private boolean verify() {
		
		// Check non-empty grid
		if (grid.length == 0 || grid[0].length == 0)
			return false;
		
		// Check that the grid is square
		if (grid.length != grid[0].length)
			return false;
		
		// Check values
		Set<Integer> values = new HashSet<Integer>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				
				// If the value is out of bounds, return false
				if (grid[i][j] < 0 ||
					grid[i][j] >= Math.pow(grid.length, 2)) {
					
					return false;
				}
				
				// If duplicate value, return false
				if (values.contains(grid[i][j]))
					return false;
				else
					values.add(grid[i][j]);
			}
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for (int y = 0; y < grid.length; y++)
			sb.append(Arrays.toString(grid[y]) + '\n');
		
		return sb.toString();
	}
	
	public void set(int x, int y, int value) {
		
		grid[y][x] = value;
	}
	
	public int get(int x, int y) {
		
		return grid[y][x];
	}
	
	public boolean isGoal() {
		
		int i = 1;
		
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid.length; x++) {
				
				// If at the lower right corner of the grid,
				// we made it
				if (y == grid.length - 1 && x == grid.length - 1)
					return true;
				
				// If at any point we skip a digit while counting,
				// we're not the goal state
				if (this.get(x,y) != i) return false;
				i++;
			}
		}
		
		// Should be unreachable
		assert(false) : "Reached unreachable code at PuzzleState.isGoal()\n";
		return true;
	}
	
	private int[][] grid;
	
}
