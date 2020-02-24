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
		
		
		
		
		
		sc.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		
		run();
	}

}
