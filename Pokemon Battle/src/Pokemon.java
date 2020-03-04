
import java.util.Random;

//parent class: All other Pokemon are going to inherit from this class

public abstract class Pokemon {
	int hp, defense, spDefense,attack,spAttack,speed;
	String name, type1, type2;
	String moves [];
	Random r = new Random();
	public Pokemon(String name, int hp, int attack, int defense, int spAttack, int spDefense, int speed, String type1, String type2)
	{
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
		this.speed = speed;
		this.type1 = type1;
		this.type2 = type2;
		moves = new String[4];
		
	}
	
	//prints out moves list

	void printMoves()
	{
		for(int i = 0; i < 4; i++)
		{
			System.out.println((i + 1) + ". " +moves[i]);
		}
	}
	
	// calculate the damage
	
	void calculateDamage(Pokemon poke, int move)
	{
		
		double damage = 0;
		double miss = Math.random()*100; 
		double normalDamage = r.nextInt(101 - 80) + 80;
		double specialDamage = r.nextInt(151 - 100) + 80;
		
		
		if (miss > normalDamage)
		{
				System.out.println("Attack Missed");
			} else {
			
			if (move == 2 || move == 3)
			{
				damage = (spAttack * specialDamage) / poke.spDefense;
			}
			else
			{
				damage = (attack * normalDamage) / poke.defense;
			}
			System.out.println("Dealt " + (int) damage + " to " + poke.name);
			poke.hp = hp - (int)(damage);
		}
	}
	
	
}//end of class