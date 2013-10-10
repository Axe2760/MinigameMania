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
	
	public void setName(String name){
		this.name = name;
	}

	/*
	 * Not to be confused with init()
	 */
	public void initializeStuff(){
		handlers.add(this);
	}
	
	public void setAuthor(String name){
		this.author = name;
	}
	
	public void setDescription(String desc){
		this.description = desc;
	}
	
	public void setPrefix(String p){
		this.prefix = p;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getPrefix(){
		return prefix;
	}
	
	public List<CommandHandler> getHandlers(){
		return handlers;
	}
	
	
}
