package us.axe2760.minigamemania.arenas;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class ArenaManager{
  //TODO: finish this class up, comment it
  private static LobbyArena global_lobby;
  private static HashMap<ArenaID, Arena> arenas = new HashMap<>();
  public static LobbyArena getGlobalLobby(){
    return global_lobby;
  }
  
  public static void setGlobalLobby(LobbyArena lobby){
    global_lobby = lobby;
  }
  
  public static List<Arena> getArenas(){
	  @SuppressWarnings("unchecked")
	  List<Arena> list = (List<Arena>)(List<?>)Arrays.asList(arenas.values().toArray());
	  return list;
  }
  
  public static void setArenas(HashMap<ArenaID, Arena> arenas){
	  ArenaManager.arenas = arenas;
  }
  
  public static Arena getArena(String name){
	  for (Arena a : (Arena[])arenas.entrySet().toArray()){
		  if (a.getName().equals(name)){
			  return a;
		  }
	  }
	  return null;
  }
  
  public static void addArena(Arena a, ArenaID id){
	  arenas.put(id, a);
  }
  
  public static void loadArenas(File file){
	  
	  try{
		  YamlConfiguration config = new YamlConfiguration();
		  config.load(file);
		  
		  ConfigurationSection cs = config.getConfigurationSection("arenas");
		  if (cs == null){
			  config.createSection("arenas");
		  }
		  
		  for (String key : cs.getKeys(false)){
			  String entry = cs.getString(key);
			  
			  String[] ss = entry.split(" ");
			  
			  String type = ss[0];
			  //TODO: finish this
		  }
		  
	  }catch(Exception e){
		  
	  }
	  
  }
  
  public static void saveArenas(){
	  
  }
  static{
    global_lobby = new LobbyArena();
    arenas = new HashMap<>();
  }
}