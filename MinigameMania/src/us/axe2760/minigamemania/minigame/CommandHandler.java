package us.axe2760.minigamemania.minigame;

import java.util.List;

import org.bukkit.command.CommandSender;

public interface CommandHandler {
	public void command(CommandSender sender, List<String> args);
}
