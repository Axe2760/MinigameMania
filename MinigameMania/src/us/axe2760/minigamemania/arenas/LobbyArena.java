package us.axe2760.minigamemania.arenas;

import us.axe2760.minigamemania.arenas.Arena;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LobbyArena extends Arena{
  public void kickAll(){
    /*
     * kick all of the players
     */
     for (String player : this.getPlayers()){
       if (Bukkit.getPlayer(player) != null){
         Bukkit.getPlayer(player).kickPlayer("You have been kicked from this lobby/server");
       }
     }
  }
  
  /*
   *Checks if player is in lobby. used for signs, & stuff...
   *@param player Player to check
   */
  public boolean isPlayer(Player player){
    return this.getPlayers().contains(player);
  }
}