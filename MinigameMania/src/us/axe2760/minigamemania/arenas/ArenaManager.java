package us.axe2760.minigamemania.arenas;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ArenaManager{
  //TODO: finish this class up, comment it
  private static LobbyArena global_lobby;
  private static List<Arena> arenas;
  
  public static LobbyArena getGlobalLobby(){
    return global_lobby;
  }
  
  public static void setGlobalLobby(LobbyArena lobby){
    global_lobby = lobby;
  }
  
  public static List<Arena> getArenas(){
	  return arenas;
  }
  
  public static void setArenas(List<Arena> arenas){
	  ArenaManager.arenas = arenas;
  }
  
  public static Arena getArena(String name){
	  for (Arena a : arenas){
		  if (a.getName().equals(name)){
			  return a;
		  }
	  }
	  return null;
  }
  
  public static void addArena(Arena a){
	  arenas.add(a);
  }
  
  public static void loadArenas(File file){
	  
  }
  
  public static void saveArenas(){
	  
  }
  static{
    global_lobby = new LobbyArena();
    arenas = new ArrayList<>();
  }
}