import java.util.Scanner;

public class Driver {
	
	private static IHeuristic chooseHeuristic(PuzzleState pz) {
		
		System.out.println("Enter your choice of algorithm:\n"
				+ "1: Uniform Cost Search\n"
				+ "2: A* with the Misplaced Tile heuristic\n"
				+ "3: A* with the Manhattan distance heuristic\n");
		
		int userInput = sc.nextInt();
		
		switch (userInput) {
		
		case 2:
			return new MisplacedTileHeuristic(pz, false);
		case 3:
			return new ManhattanDistHeuristic(pz, false);
		case 1:
		default:
			return new UniCostHeuristic();	
		}
	}

	private static PuzzleState chooseStartingState() {
		
		System.out.println("Welcome to RyanVillenaUCR's 8-puzzle solver.\n"
				+ "Type \"1\" to use \"Trivial\",\n"
				+ "\"2\" to use \"Very Easy\",\n"
				+ "\"3\" to use \"Easy\",\n"
				+ "\"4\" to use \"Doable\",\n"
				+ "\"5\" to use \"Oh Boy\",\n"
				+ "or \"6\" to enter your own puzzle.");
		
		int choice = sc.nextInt();
		
		switch (choice) {
		
		case 1:	// Trivial
			return new PuzzleState(new int[][] {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 0 }
			});
		
		case 2:	// Very Easy
			return new PuzzleState(new int[][] {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 0, 8 }
			});
			
		case 3:	// Easy
			return new PuzzleState(new int[][] {
				{ 1, 2, 0 },
				{ 4, 5, 3 },
				{ 7, 8, 6 }
			});
			
		case 4:	// Doable
			return new PuzzleState(new int[][] {
				{ 0, 1, 2 },
				{ 4, 5, 3 },
				{ 7, 8, 6 }
			});
			
		case 5:	// Oh Boy
			return new PuzzleState(new int[][] {
				{ 8, 7, 1 },
				{ 6, 0, 2 },
				{ 5, 4, 3 }
			});
		
		}
		
		return new PuzzleState(); // Asks user for input
		
		
	}
	
	private static void run() {
		
		PuzzleState startingState = chooseStartingState();
		IHeuristic heuristic = chooseHeuristic(startingState);

		Problem p = new Problem(startingState, heuristic);
		
		System.out.println(p.solve() ? "" : "No solution found.");
	}
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
//		System.out.println("Hello world!");
		
//		Tester.doTests();
		
		run();
		
		sc.close();
	}
	
	public static Scanner sc;

}
