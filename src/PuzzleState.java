import java.util.Arrays;

public class PuzzleState {

	public PuzzleState(int[][] grid) {
		
		this.grid = grid;
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
