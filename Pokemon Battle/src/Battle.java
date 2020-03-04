import java.util.Scanner;

public class Battle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int player1;
		int player2;
		Pokemon p1 = null;
		Pokemon p2 = null;
		
		System.out.println("Welcome");
		System.out.println("Player 1: choose your Pokemon");
		System.out.println("1.Charizard \n2.Blastoise \n3.Venusaur");
		player1 = input.nextInt();
		
		
		switch(player1)
		{
		case 1: 
			p1 = new Charizard();
			break;
		case 2:
			p1 = new Blastoise();
			break;
		case 3:
			p1 = new Venusaur();
			break;
			default:
				System.out.println("Wrong Input.  Simulator will now close");
				System.exit(0);
				break;
		}
		
		System.out.println("Player 2: Choose your Pokemon");
		System.out.println("1.Charizard \n2.Blastoise \n3.Venusaur");
		player2 = input.nextInt();
		
		switch(player2)
		{
		case 1: 
			p2 = new Charizard();
			break;
		case 2:
			p2 = new Blastoise();
			break;
		case 3:
			p2 = new Venusaur();
			break;
			default:
				System.out.println("Wrong Input.  Simulator will now close");
				System.exit(0);
				break;
		}
		
		System.out.println("Let the fight begin");
		
		//highest speed goes first
		Pokemon first, second;
		
		if(p1.speed > p2.speed)
		{
			first = p1;
			second = p2;
		}
		else
		{
			first = p2;
			second = p1;
		}
		
		System.out.println("\n" + first.name + " starts");
		
		while(true)
		{
			//player one
			System.out.println("\n" + first.name + "\nHP: " + first.hp);
			System.out.println("Moves: ");
			first.printMoves();
			System.out.println("Choose a move");
			int m1 = input.nextInt();
			m1--;
			
			
			
			first.calculateDamage(second, m1);
			if(second.hp <= 0)
			{
				System.out.println(second.name + " is knocked out!\n" + first.name + " wins!");
				System.out.println("Thanks for Playing");
				System.exit(0);
			}
			
			//player two
			System.out.println("\n" + second.name + "\nHP: " + second.hp);
			System.out.println("Moves: ");
			second.printMoves();
			System.out.println("Choose a move");
			int m2 = input.nextInt();
			m2--;
			second.calculateDamage(first, m2);
			
			if(first.hp <= 0)
			{
				System.out.println(first.name + " is knocked out!\n" + second.name + " wins!");
				System.out.println("Thanks for Playing");
				System.exit(0);
			}
		}
		
		

	}

}