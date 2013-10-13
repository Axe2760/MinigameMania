package us.axe2760.minigamemania.arenas;

import us.axe2760.minigamemania.arenas.LobbyArena;

public class ArenaManager{
  
  private static LobbyArena global_lobby;
  
  public static LobbyArena getGlobalLobby(){
    return global_lobby;
  }
  
  public static void setGlobalLobby(LobbyArena lobby){
    global_lobby = lobby;
  }
  
  static{
    global_lobby = new LobbyArena();
  }
}