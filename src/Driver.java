import java.util.Scanner;

public class Driver {
	
	private static PuzzleState getPuzzleFromUser() {
		
		Scanner sc = new Scanner(System.in);
		
		return null; // @TODO
	}

	private static void run() {
		
		System.out.println("Welcome to RyanVillenaUCR's 8-puzzle solver.\n"
				+ "Type \"1\" to use a default puzzle, or \"2\" to enter your own puzzle.");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		PuzzleState p;
		
		if (choice == 1) {
			
			int[][] defaultP = new int[][] {
				{ 1, 2, 3 },
				{ 4, 8, 0 },
				{ 7, 6, 5 }
			};
			
			p = new PuzzleState(defaultP);
			
		}
//		} else {
//			
//			p = getPuzzleFromUser();
//		}
		
		System.out.println("Enter your choice of algorithm:\n"
				+ "1: Uniform Cost Search\n"
				+ "2: A* with the Misplaced Tile heuristic\n"
				+ "3: A* with the Manhattan distance heuristic\n");
		choice = sc.nextInt();
		
		
		
		IHeuristic heuristic;
		switch (choice) {
		
		case 2:
			heuristic = new MisplacedTileHeuristic();
			break;
		case 3:
			heuristic = new ManhattanDistHeuristic();
		case 1:
		default:
			heuristic = new UniCostHeuristic();	
		}
		
		
		
		
		
		
		
		sc.close();
	}
	
	private static void testGrid() {
		
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		
//		testGrid();
		
//		run();
	}

}
