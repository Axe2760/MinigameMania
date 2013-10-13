package us.axe2760.minigamemania.arenas;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import us.axe2760.minigamemania.Gamemode;

public abstract class Arena {
	private List<Location> spawns = new ArrayList<>();
	private List<String> players = new ArrayList<>();
	private Gamemode gametype;
	
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
	public abstract void kickAll(){}

}
