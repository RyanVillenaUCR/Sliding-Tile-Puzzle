import java.util.Iterator;
import java.util.NoSuchElementException;

public class PuzzleStateIterator implements Iterator<Integer> {

	public PuzzleStateIterator(PuzzleState p) {
		
		this.p = p;
		x = -1;
		y = 0;
	}
	
	@Override
	public boolean hasNext() {
		
		return x != p.gridWidth() - 1 || y != p.gridWidth() - 1;
	}

	@Override
	public Integer next() {
		
		if (!hasNext())
			throw new NoSuchElementException();
		
		// Iterate through rows, if possible
		if (x < p.gridWidth() - 1)
			x++;
		
		// Else, iterate through columns
		else {
			x = 0;
			y++;
		}
		
		return p.get(x, y);
	}
	
	private PuzzleState p;
	private int x;
	private int y;

}
