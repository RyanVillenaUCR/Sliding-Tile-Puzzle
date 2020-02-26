import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PuzzleState implements Iterable<Integer> {

	public enum Command {
		SLIDE_UP, SLIDE_DOWN,
		SLIDE_LEFT, SLIDE_RIGHT
	}
	
	/**
	 * A constructor which takes input from the console.
	 */
	public PuzzleState() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How wide should your square matrix be?");
		int width = Math.abs(sc.nextInt());
		
		System.out.println("Please fill in your grid one at a time,\n"
				+ "using 0 as the blank space.");
		
		this.grid = new int[width][width];
		
		while (true) {
			
			for (int y = 0; y < width; y++) {
				for (int x = 0; x < width; x++) {
					
					System.out.println("Enter a number at { " + x + ", " + y + " }");
					this.set(x, y, sc.nextInt());
					
					System.out.println(this);
				}
			}
			
			if (verify())
				break;
			
			System.out.println("Try again.");
			this.grid = new int[width][width];
		}

		
		
		sc.close();
	}
	
	/**
	 * A constructor which takes input from within the program
	 * @param grid 2D grid; must be valid (see verify())
	 */
	public PuzzleState(int[][] grid) {
		
		if (grid == null)
			throw new NullPointerException();
		
		this.grid = grid;
		
		assert(verify()) : "Bad input, dude";
		
		zero = lookForZero();
	}

	/**
	 * False if invalid; duplicate values, nonsquare matrix, etc. True otherwise
	 * @return True if a valid puzzle state, false otherwise
	 */
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
					
					System.err.println("ERROR: Out-of-bounds value " + grid[i][j] +
							" at coords { " + i + ", " + j + " }");
					return false;
				}
				
				// If duplicate value, return false
				if (values.contains(grid[i][j])) {
					System.err.println("ERROR: Value " + grid[i][j] +
							" appeared twice at coords { " + i + ", " + j + " }");
					return false;
				}
					
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
	
	@Override
	public boolean equals(Object other) {
		
		// Check class
		if (!(other instanceof PuzzleState)) {
			return false;
		}
		PuzzleState otherPS = (PuzzleState) other;
		
		// Check boundaries
		if (this.grid.length != otherPS.grid.length ||
				this.grid[0].length != otherPS.grid[0].length)
			return false;
		
		// Check elements
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				
				if (this.grid[i][j] != otherPS.grid[i][j])
					return false;
			}
		}
		
		return true;
	}
	
	@Override
	public int hashCode() { // outsource hashing to string
		
		StringBuilder sb = new StringBuilder();
		
		for (Integer i : this)
			sb.append(i);
		
		return sb.toString().hashCode();
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
	
	private int[] lookForZero() {
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				
				if (this.get(i, j) == 0) // uses [ x, y] ] notation
					return new int[] { i, j };
			}
		}
		
		assert(false) : "Zero was nowhere to be found...";
		return null;
	}
	
	public void slide(Command move) {
		
		switch (move) {
		
		case SLIDE_DOWN:
			slideDown(); break;
		case SLIDE_UP:
			slideUp(); break;
		case SLIDE_LEFT:
			slideLeft(); break;
		case SLIDE_RIGHT:
			slideRight(); break;
		}
	}
	
	private void slideDown() { // Only slide() calls this
		
		assert(zero[1] != 0); // check bounds
		
		int slidyboi = get(zero[0], zero[1] - 1);
		
		set(zero[0], zero[1],     slidyboi);
		set(zero[0], zero[1] - 1, 0);
		
		zero[1]--;
	}
	
	private void slideUp() { // Only slide() calls this
		
		assert(zero[1] != grid.length - 1); // check bounds
		
		int slidyboi = get(zero[0], zero[1] + 1);
		
		set(zero[0], zero[1],     slidyboi);
		set(zero[0], zero[1] + 1, 0);
		
		zero[1]++;
	}
	
	private void slideLeft() { // Only slide() calls this
		
		assert(zero[0] != grid.length - 1);
		
		int slidyboi = get(zero[0] + 1, zero[1]);
		
		set(zero[0],     zero[1], slidyboi);
		set(zero[0] + 1, zero[1], 0);
		
		zero[0]++;
	}
	
	private void slideRight() { // Only slide() calls this
		
		assert(zero[0] != 0);
		
		int slidyboi = get(zero[0] - 1, zero[1]);
		
		set(zero[0],     zero[1], slidyboi);
		set(zero[0] - 1, zero[1], 0);
		
		zero[0]--;
	}
	
	Set<Command> possibleCommands() {
		
		int x = zero[0];
		int y = zero[1];
		Set<Command> possible = new HashSet<Command>();
		
		if (x != 0)
			possible.add(Command.SLIDE_DOWN);
		
		if (x != grid.length - 1)
			possible.add(Command.SLIDE_UP);
		
		if (y != 0)
			possible.add(Command.SLIDE_RIGHT);
		
		if (y != grid.length - 1)
			possible.add(Command.SLIDE_LEFT);
		
		return possible;		
	}
	
	@Override
	public Iterator<Integer> iterator() {

		return new PuzzleStateIterator(this);
	}
	
	public int gridWidth() {
		
		return grid.length;
	}
	
	public class InvalidCommandException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
	}
	
	private int[][] grid;
	private int[] zero;	// zero[0] is x, zero[1] is y

	
}
