
import java.util.*;


public class Map
{
	ArrayList<Location> locations = new ArrayList<Location>();
	static HashMap<Integer, Location> hashLocs = new HashMap<Integer, Location>();
	public Map() {
		
	}
	
	public Map(Integer TotalLocations){
		for (int i = 0; i < TotalLocations; i++) {
			locations.add(i, new Location(i));
		}
		for (Location l : locations){
			hashLocs.put(l.MapId, l);
		}
		for (Location loc : locations) {
			loc.MapPaths(5, locations);
		}
		
	}
	
	public void PrintAll(){
		for (Location loc : locations) {
			System.out.println("Location Id: " + loc.MapId.toString());
			for (Path p : loc.paths) {
				System.out.println("     C: " + p.toValue.toString());
			}
		}
	}
}

class Path {
	Integer toValue;
	
	public Path(Integer i) {
		toValue = i;
	}
	
}

class Location {
	Integer MapId;
	ArrayList<Path> paths = new ArrayList<Path>();
	
	public Location(Integer myMapId){
		MapId = myMapId;
	}
	
	public void MapPaths(Integer MaxPaths, ArrayList<Location> locs) {
		Random r1 = new Random();
		ArrayList<Location> tmploc = new ArrayList<Location>();
		tmploc.addAll(locs);
		tmploc.remove(this);
		for (int i = 0; i < MaxPaths; i++){
			Location tmpOneLoc = tmploc.get(r1.nextInt(tmploc.size()-1));
			Integer MapIdTo = tmpOneLoc.MapId;
			paths.add(new Path(MapIdTo));
			tmpOneLoc.paths.add(new Path(this.MapId));
			tmploc.remove(tmpOneLoc);
		}
	}
}
