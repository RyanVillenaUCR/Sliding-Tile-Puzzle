import java.util.Scanner;

public class Driver {
	
	private static IHeuristic chooseHeuristic(int input) {
		
		switch (input) {
		
		case 2:
			return new MisplacedTileHeuristic(null, false);
		case 3:
			return new ManhattanDistHeuristic(null, false);
		case 1:
		default:
			return new UniCostHeuristic();	
		}
	}

	private static void run() {
		
		System.out.println("Welcome to RyanVillenaUCR's 8-puzzle solver.\n"
				+ "Type \"1\" to use a default puzzle, or \"2\" to enter your own puzzle.");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		PuzzleState p;
		
		if (choice == 2) {
			
			p = new PuzzleState();
			
		} else {
			
			int[][] defaultP = new int[][] {
				{ 1, 2, 3 },
				{ 4, 8, 0 },
				{ 7, 6, 5 }
			};
			
			p = new PuzzleState(defaultP);
		}
		
		System.out.println("Enter your choice of algorithm:\n"
				+ "1: Uniform Cost Search\n"
				+ "2: A* with the Misplaced Tile heuristic\n"
				+ "3: A* with the Manhattan distance heuristic\n");
		choice = sc.nextInt();
		IHeuristic heuristic = chooseHeuristic(choice);

		
		
		
		
		
		
		
		sc.close();
	}
	
	private static void testStuff() {
		
//		Tester.testGrid();
		
//		Tester.testManhattanDist();
		
//		Tester.testGridIterator();
		
//		Tester.testMisplacedTile();
		
		Tester.testGetPuzzleFromUser();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		
		testStuff();
		
//		run();
	}

}
