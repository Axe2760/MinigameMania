package us.axe2760.minigamemania.arenas;

import org.bukkit.Bukkit;

public class GameArena extends Arena {

	@Override
	public void kickAll() {
		for (String player : this.getPlayers()){
			if (Bukkit.getPlayer(player) != null){
				Bukkit.getPlayer(player).teleport(ArenaManager.getGlobalLobby().getSpawns().get(0));
				Bukkit.getPlayer(player).sendMessage("You have been kicked from this arena and sent to the global lobby!");
			}
		}
	}

}
