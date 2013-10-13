package us.axe2760.minigamemania.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import us.axe2760.minigamemania.Mania;
import us.axe2760.minigamemania.minigame.CommandHandler;
import us.axe2760.minigamemania.minigame.Minigame;

/*
 * Command for /minigame or /mg
 */

public class CommandMinigame implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("minigame") || cmd.getName().equalsIgnoreCase("mg")){
			if (args.length == 0){
				/*
				 * Return list of minigames.
				 */
				StringBuilder buffer = new StringBuilder();
				int amount = 0;
				for (Minigame m : Mania.getGames()){
					buffer.append(m.getName());
					amount++;
				}
				
				sender.sendMessage(ChatColor.GOLD + "[" +String.valueOf(amount) + " Minigames]: "+ ChatColor.BLUE + buffer.toString());
			}
			else if (args.length >= 1){
				if (sender.hasPermission("mania.admin")){
					/*
					 * Do minigame command.
					 */
					Minigame m = Mania.getMinigame(args[0]);
					
					if (m != null){
						/*
						 * Get list of arguments.
						 */
						List<String> list = Arrays.asList(args);
						list.remove(0);
						
						/*
						 * Call the command handlers.
						 */
						for (CommandHandler handler : m.getHandlers()){
							handler.command(sender, list);
						}
					}
				}else{
					/*
					 * Return list of minigames.
					 */
					StringBuilder buffer = new StringBuilder();
					int amount = 0;
					for (Minigame m : Mania.getGames()){
						buffer.append(m.getName());
						amount++;
					}
					
					sender.sendMessage(ChatColor.GOLD + "[" +String.valueOf(amount) + "Minigames]: "+ ChatColor.BLUE + buffer.toString());
				}
			}
		}
		return false;
	}
}
