package us.axe2760.minigamemania;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import us.axe2760.minigamemania.commands.CommandMinigame;
import us.axe2760.minigamemania.minigame.Minigame;
import us.axe2760.minigamemania.minigame.MinigameLoader;


public class Mania extends JavaPlugin{
	
	private static List<Minigame> games = new ArrayList<>();
	private static Mania instance;
	
	/*
	 * (non-Javadoc)
	 * @see org.bukkit.plugin.java.JavaPlugin#onEnable()
	 */
	public void onEnable(){
		
		instance = this;
		
		//load from the minigames folder
		
		/*
		 * Create data folder
		 */
		if (!this.getDataFolder().exists()){
			this.getDataFolder().mkdir();
		}
		
		File minigameFolder = new File(this.getDataFolder(), "minigames");
		
		/*
		 * Create minigames folder
		 */
		if (!minigameFolder.exists()){
			minigameFolder.mkdir();
		}
		
		/*
		 * Load minigames.
		 */
		games = MinigameLoader.loadMinigames(minigameFolder);
		
		/*
		 * Commands
		 */
		getCommand("minigame").setExecutor(new CommandMinigame());
		getCommand("mg").setExecutor(new CommandMinigame());
		
		/*
		 * Initialize minigames
		 */
		for (Minigame m : games){
			m.init();
		}
	}
	
	/*
	 * Gets the instance of the plugin.
	 */
	public static Mania getInstance(){
		return instance;
	}
	
	/*
	 * Returns loaded minigames.
	 */
	public static List<Minigame> getGames(){
		return games;
	}
	
	/*
	 * Returns a minigame based on the name. Returns null if minigame doesn't exist.
	 * @param name Name of the minigame to get
	 */
	public static Minigame getMinigame(String name){
		for (Minigame m : games){
			if (m.getName().equalsIgnoreCase(name)){
				return m;
			}
		}
		return null;
	}
}
