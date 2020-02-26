import java.util.PriorityQueue;
import java.util.Queue;

public class Tester {

	public static void testGrid() {
		
		PuzzleState notGoal = new PuzzleState(

			new int[][] {
				{ 1, 2, 3 },
				{ 4, 8, 0 },
				{ 7, 6, 5 }
			});
		
		System.out.println("notGoal:\n"
				+ notGoal + "\n"
				+ "notGoal at 0, 2: " + notGoal.get(0, 2) + "\n"
				+ "Is this a goal state? " + notGoal.isGoal() + "\n");
		
		PuzzleState goal = new PuzzleState(

			new int[][] {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 0 }
			});
		
		System.out.println("goal:\n"
				+ goal + "\n"
				+ "goal at 0, 2: " + goal.get(0, 2) + "\n"
				+ "Is this a goal state? " + goal.isGoal() + "\n");
	}
	
	public static void testGridIterator() {
		
		PuzzleState p1 = new PuzzleState(new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 0 }
		});
		
		for (Integer i : p1)
			System.out.println(i + " ");
		
		System.out.println("hashcode: " + p1.hashCode());
	}
	
	public static void testManhattanDist() {
		
		// To enable all tests,
		// turn ManhattanDistHeuristic.getManhattanSum() public, or
		// turn ManhattanDistHeuristic.getElementManhattanDist() public
		
		// Expected Manhattan distance: 10 w/o empty tile, 12 with
		PuzzleState p1 = new PuzzleState(new int[][] {
			{ 8, 1, 3 },
			{ 4, 0, 2 },
			{ 7, 6, 5 }
		});
		IHeuristic mdh1 = new ManhattanDistHeuristic(p1, false);
	
//		int testElement = 0;
		
//		System.out.println("Testing Manhattan distance for grid\n" + p1
//				+ "for element " + Integer.toString(testElement) + ": "
//				+ "MhtnDist(" + Integer.toString(testElement) + "): "
//				+ mdh1.getElementManhattanDist(testElement));
		
		System.out.println("Testing Manhattan distance for grid\n" + p1);
		System.out.println("Manhattan distance: " + mdh1.getHeuristic());
		
		
		
		PuzzleState p2 = new PuzzleState(new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 0 }
		});
		IHeuristic mdh2 = new ManhattanDistHeuristic(p2, false);
		
		System.out.println("Testing Manhattan distance for grid\n" + p2);
		System.out.println("Manhattan distance: " + mdh2.getHeuristic());
		
//		int testElement = 0;
////		
//		System.out.println("Testing Manhattan distance for grid\n" + p2
//				+ "for element " + Integer.toString(testElement) + ": "
//				+ "MhtnDist(" + Integer.toString(testElement) + "): "
//				+ mdh2.getElementManhattanDist(testElement));
	}

	public static void testMisplacedTile() {
		
		PuzzleState p1 = new PuzzleState(new int[][] {
			{ 8, 1, 3 },
			{ 4, 0, 2 },
			{ 7, 6, 5 }
		});
		IHeuristic mpth1 = new MisplacedTileHeuristic(p1, false);
		
		System.out.println("Testing Misplaced tile for grid\n" + p1);
		System.out.println("Misplaced tile: " + mpth1.getHeuristic());
		
		
		
		PuzzleState p2 = new PuzzleState(new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 0 }
		});
		IHeuristic mpth2 = new MisplacedTileHeuristic(p2, false);
		
		System.out.println("Testing Misplaced tile for grid\n" + p2);
		System.out.println("Misplaced tile: " + mpth2.getHeuristic());
	}

	public static void testGetPuzzleFromUser() {
		
		new PuzzleState();
	}

	public static void testNode() {
		
		PuzzleState unsolved = new PuzzleState(
				new int[][] {
					{ 8, 1, 3 },
					{ 4, 0, 2 },
					{ 7, 6, 5 }});
		
		Node unsolvedNode = new Node(unsolved, null, new ManhattanDistHeuristic(unsolved, false));
		
		System.out.println(unsolvedNode);
		System.out.println("Cost: " + unsolvedNode.getCost());
	}
	
	public static void testPriorityQueue() {
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		PuzzleState solved = new PuzzleState(
				new int[][] {
					{ 1, 2, 3 },
					{ 4, 5, 6 },
					{ 7, 8, 0 }});
		
		PuzzleState unsolved = new PuzzleState(
				new int[][] {
					{ 1, 2, 3 },
					{ 4, 8, 0 },
					{ 7, 6, 5 }});
		
		Node solvedNode   = new Node(solved,   null, new ManhattanDistHeuristic(solved, false));
		Node unsolvedNode = new Node(unsolved, null, new ManhattanDistHeuristic(unsolved, false));
		
		System.out.println("solvedNode.cost():   " + solvedNode.getCost());
		System.out.println("unsolvedNode.cost(): " + unsolvedNode.getCost());
		
//		pq.add(solvedNode);	// test out of order
		pq.add(unsolvedNode);
		pq.add(solvedNode);
		
		System.out.println("Popping...\n" + pq.remove());
		System.out.println("Popping...\n" + pq.remove());
	}
	
	public static void doTests() {
		
//		testGrid();
		
//		testManhattanDist();
		
//		testGridIterator();
		
//		testMisplacedTile();
		
//		testGetPuzzleFromUser();
		
//		testNode();
		
		testPriorityQueue();
	}

}
