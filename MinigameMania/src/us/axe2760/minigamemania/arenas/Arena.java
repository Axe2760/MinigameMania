package us.axe2760.minigamemania.arenas;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import us.axe2760.minigamemania.Gamemode;
import us.axe2760.minigamemania.minigame.Minigame;

public abstract class Arena {
	
	private List<Location> spawns = new ArrayList<>();
	private List<String> players = new ArrayList<>();
	private Gamemode gametype;
	private Minigame minigame;
	private String name;
	
	/*
	 * Set the list of spawns for the arena.
	 * @param spawns Spawns with which to use
	 */
	public void setSpawns(List<Location> spawns){
		this.spawns = spawns;
	}
	
	/*
	 * Adds a spawn to the list of spawns.
	 * @param spawn Spawn to add to the list of spawns
	 */
	public void addSpawn(Location spawn){
		spawns.add(spawn);
	}
	
	/*
	 * Get the spawns for the arena
	 */
	public List<Location> getSpawns(){
		return spawns;
	}
	
	/*
	 * Set the players in the arena.
	 * @param players Players to be in the arena. (Names)
	 */
	public void setPlayers(List<String> players){
		this.players = players;
	}
	
	/*
	 * Adds a player to the arena.
	 * @param player Player to add (name)
	 */
	public void addPlayer(String player){
		players.add(player);
	}
	
	/*
	 * Get all players in the arena.
	 */
	public List<String> getPlayers(){
		return players;
	}
	
	/*
	 * Set the game type for this arena. Should only be called when the arenas are initiliazed
	 * @param type Type of arena to set it to
	 */
	public void setArenaGame(Gamemode type){
		this.gametype = type;
	}

	/*
	 * Get the gamemode the arena is playing in.
	 * @return gamemode
	 */
	public Gamemode getArenaGame(){
		return gametype;
	}
	/*
	 * Kick all players from the arena.
	 */
	public abstract void kickAll();

	/*
	 * Default: seralizes spawns into a single string
	 */
	public String serialize(){
		StringBuilder out = new StringBuilder();
		
		for (Location spawn : spawns){
			out.append(spawn.getWorld().getName());
			out.append(",");
			out.append(String.valueOf(spawn.getX()));
			out.append(",");
			out.append(String.valueOf(spawn.getY()));
			out.append(",");
			out.append(String.valueOf(spawn.getZ()));
			out.append(";");
		}
		
		//remove the last ;
		out.deleteCharAt(out.length() - 1);
		
		return out.toString();
	}
	
	/*
	 * Deserializes a given string and uses the data from it.
	 * @param in String of data 
	 */
	public void deserialize(String in){
		List<Location> out = new ArrayList<>();
		
		for (String temp : in.split(";")){
			String[] temps = temp.split(",");
			Location loc = new Location(Bukkit.getWorld(temps[0]), Double.parseDouble(temps[1]), Double.parseDouble(temps[2]), Double.parseDouble(temps[3]));
			out.add(loc);
		}
		
		this.setSpawns(out);
	}
	
	/*
	 * Sets the minigame for the arena.
	 * @param m Minigame
	 */
	public void setMinigame(Minigame m){
		this.minigame = m;
	}
	
	/*
	 * Gets the minigame for the arena
	 * @return minigame
	 */
	public Minigame getMinigame(){
		return minigame;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
