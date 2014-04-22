import java.util.*;

public class Main
{
	static Integer TotalLocs = 100;
	static BattleGame bg = new BattleGame();
	static Map MyMap = new Map(TotalLocs);
	
	public static void main(String[] args){
		System.out.println("hey");
		bg.go();
		MyMap.PrintAll();
		//Scanner input = new Scanner(System.in);
	}
	
	
}




