package us.axe2760.minigamemania.minigame;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.Listener;

public abstract class Minigame implements Listener, CommandHandler{
	
	private String name;
	private String author;
	private String description;
	private String prefix;
	
	private List<CommandHandler> handlers = new ArrayList<>();
	

	/*
	 * Called when the plugin is loaded.
	 */
	public void init(){}
	
	/*
	 *Called when the minigame is loaded. (Game start) 
	 */
	public void load(){}
	/*
	 * Not to be confused with init()
	 */
	
	/*
	 * Set the name of the plugin.
	 * @param name name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/*
	 * Set author of the plugin.
	 * @param name author
	 */
	public void setAuthor(String name){
		this.author = name;
	}
	
	/*
	 * Set the description of the plugin.
	 * @param desc Description
	 */
	public void setDescription(String desc){
		this.description = desc;
	}
	
	/*
	 * Set the prefix of the plugin.
	 * @param p prefix
	 */
	public void setPrefix(String p){
		this.prefix = p;
	}
	
	/*
	 * Get the name of plugin
	 * @return name 
	 */
	public String getName(){
		return name;
	}
	
	/*
	 * Get the author of the plugin
	 * @return author
	 */
	public String getAuthor(){
		return author;
	}
	
	/*
	 * Get the description of the plugin
	 * @return description
	 */
	public String getDescription(){
		return description;
	}
	
	/*
	 * Get the prefix of the plugin
	 * @return prefix
	 */
	public String getPrefix(){
		return prefix;
	}
	
	public List<CommandHandler> getHandlers(){
		return handlers;
	}
	
	
}
