package us.axe2760.minigamemania;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import us.axe2760.minigamemania.minigame.Minigame;
import us.axe2760.minigamemania.minigame.MinigameLoader;

public class Mania extends JavaPlugin{
	
	private List<Minigame> games = new ArrayList<>();
	
	public void onEnable(){
		
		//load from the minigames folder
		
		if (!this.getDataFolder().exists()){
			this.getDataFolder().mkdir();
		}
		
		File minigameFolder = new File(this.getDataFolder(), "minigames");
		
		if (!minigameFolder.exists()){
			minigameFolder.mkdir();
		}
		
		games = MinigameLoader.loadMinigames(minigameFolder);
	}
	
}
