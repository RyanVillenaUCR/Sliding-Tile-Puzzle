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
	
	private int[][] grid;
	
}
