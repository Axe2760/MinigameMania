package us.axe2760.minigamemania;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class Mania extends JavaPlugin{
	
	public void onEnable(){
		
		//load from the minigames folder
		
		if (!this.getDataFolder().exists()){
			this.getDataFolder().mkdir();
		}
		
		File minigameFolder = new File(this.getDataFolder(), "minigames");
		
		if (!minigameFolder.exists()){
			minigameFolder.mkdir();
		}
	}
	
}
