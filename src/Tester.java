
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
			{ 7, 0, 8 }
		});
		
		for (Integer i : p1)
			System.out.println(i + " ");
		
		System.out.println("hashcode: " + p1.hashCode());
	}
	
	public static void testManhattanDist() {
		
		// To enable these tests,
		// turn ManhattanDistHeuristic.getManhattanSum() public, or
		// turn ManhattanDistHeuristic.getElementManhattanDist() public
		
		// Expected Manhattan distance: 10 w/o empty tile, 12 with
//		PuzzleState p1 = new PuzzleState(new int[][] {
//			{ 8, 1, 3 },
//			{ 4, 0, 2 },
//			{ 7, 6, 5 }
//		});
//		ManhattanDistHeuristic mdh1 = new ManhattanDistHeuristic(p1, false);
//	
//		int testElement = 0;
		
//		System.out.println("Testing Manhattan distance for grid\n" + p1
//				+ "for element " + Integer.toString(testElement) + ": "
//				+ "MhtnDist(" + Integer.toString(testElement) + "): "
//				+ mdh1.getElementManhattanDist(testElement));
		
//		System.out.println("Testing Manhattan distance for grid\n" + p1);
//		System.out.println("Manhattan distance: " + mdh1.getManhattanSum());
		
		
		
//		PuzzleState p2 = new PuzzleState(new int[][] {
//			{ 1, 2, 3 },
//			{ 4, 5, 6 },
//			{ 7, 8, 0 }
//		});
//		ManhattanDistHeuristic mdh2 = new ManhattanDistHeuristic(p2);
//		
//		System.out.println("Testing Manhattan distance for grid\n" + p2);
//		System.out.println("Manhattan distance: " + mdh2.getManhattanSum());
		
//		int testElement = 0;
////		
//		System.out.println("Testing Manhattan distance for grid\n" + p2
//				+ "for element " + Integer.toString(testElement) + ": "
//				+ "MhtnDist(" + Integer.toString(testElement) + "): "
//				+ mdh2.getElementManhattanDist(testElement));
	}
}
