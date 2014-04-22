
import java.util.*;

public class Fighter
{
	static Random r1 = new Random();
	Integer offense;
	Integer defense;
	Integer health;
	Integer skill;
	Integer luck;
	Integer team;
	Integer MapLocation;
	boolean activehuh = true;
	Integer level;
	
	public Fighter(Integer myteam){
		offense = 11;
		defense = 10;
		health = 100;
		skill = r1.nextInt(10);
		luck = 10 - skill;
		MapLocation = r1.nextInt(Main.TotalLocs);
		team = myteam;
	}

	public void printVars() {
		System.out.println("skill: " + skill.toString());
		System.out.println("luck: " + luck.toString());
	}
	
	public void printFinalState() {
		System.out.println("Location: " + this.MapLocation);
		System.out.println("  Team: " + this.team);
		System.out.println("  Health: " + this.health);
	}
	
	private void fight(Fighter foe) {
		Integer damage = (this.offense + this.skill + r1.nextInt(luck)) - 
		(foe.defense + foe.skill + foe.r1.nextInt(foe.luck));
		if (damage > 0) {
			foe.health = foe.health - damage;
		}
	}
	
	public void takeTurn(BattleGame bg, Map m) {
		for (Fighter f : bg.fighters){
			if((f.MapLocation == this.MapLocation) && (f.team != this.team) && (f.activehuh)) {
				this.fight(f);
				break;
			}
		}
		this.move(m);
	}
	
	private void move(Map m) {
		Location l = m.locations.get(MapLocation);
		this.MapLocation = l.paths.get(r1.nextInt(l.paths.size())).toValue;
	}

}
