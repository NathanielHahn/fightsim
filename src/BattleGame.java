

import java.util.*;

public class BattleGame
 {
	ArrayList<Fighter> fighters = new ArrayList<Fighter>();
	public BattleGame(){
		initializeFighters(50, 15);
	}

	public void go() {
		runGame();
		endPrint();
	}

	private void initializeFighters(Integer fperteam, Integer teams){
		for (int i = 0; i < teams; i++){
			for (int j = 0; j < fperteam; j++){
				fighters.add(new Fighter(i+1));
			}
		}

	}

	private void runGame(){
		Integer turn = 1;
		while(multipleTeams() && (turn < 5000)){
			for (Fighter f : fighters) {
				if (f.health < 0){
					f.activehuh = false;
					f.MapLocation = -1;
				}
			}
			for (Fighter f : fighters) {
				if (f.activehuh) {
					f.takeTurn(this, Main.MyMap);
				}
				}
			System.out.println("Turn: " + turn.toString());
			System.out.println("Fighters: " + this.countFighters().toString());
			turn++;
			}
			
		}
	
	
	private void endPrint(){
		for (Fighter f : fighters){
			if(f.activehuh){
			f.printFinalState();
			}
		}
	}
	
	private Integer countFighters(){
		int i = 0;
		for (Fighter f : fighters) {
			if(f.activehuh){
				i++;
			}
		}
		return i;
	}
	
	private boolean multipleTeams(){
		int prevteam = -1;
	
		for (Fighter f : fighters) {
			if (f.activehuh){
				if(prevteam == -1) {
					prevteam = f.team;
				}
				if(f.team != prevteam) {
					return true;
				}
			
			}
		}
		return false;
	}

	private void oneBattle(Fighter f1, Fighter f2){
		Integer dmg1 = ((f2.offense + f2.skill + f2.r1.nextInt(f2.luck)) -
			(f1.defense + f1.skill + f1.r1.nextInt(f1.luck) ));
		if (dmg1 > 0) {
			f1.health = f1.health - dmg1;
		}

		Integer dmg2 = ((f1.offense + f1.skill + f1.r1.nextInt(f1.luck)) -
			(f2.defense + f2.skill + f2.r1.nextInt(f2.luck) ));
		if(dmg2 > 0) {
			f2.health = f2.health - dmg2;
		}
	}
}
