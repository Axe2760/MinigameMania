package us.axe2760.minigamemania.minigame;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;
import org.bukkit.configuration.file.YamlConfiguration;

import us.axe2760.minigamemania.Mania;
import us.axe2760.minigamemania.exceptions.InvalidMinigameYamlException;

public class MinigameLoader {
	
	@SuppressWarnings("deprecation")
	public static List<Minigame> loadMinigames(File pathtodir){
		List<Minigame> mg = new ArrayList<Minigame>();
		for (File entry : pathtodir.listFiles()){
			String ext = entry.getPath().substring(entry.getPath().lastIndexOf('.'));
			if (ext.equals("jar") && ext.equals("zip")){
				ZipFile zf = null;
				try{
					zf = new ZipFile(entry);
					
					if (zf.getEntry("minigame.yml") != null){
						InputStream is = zf.getInputStream(zf.getEntry("minigame.yml"));
						StringWriter sw = new StringWriter();
						IOUtils.copy(is, sw);
						String out = sw.toString();
						
						YamlConfiguration yml = new YamlConfiguration();
						yml.load(out);
						
						if (yml.contains("main") && yml.contains("name") && yml.contains("author") && yml.contains("prefix") && yml.contains("description")){
							String main = yml.getString("main");
							String name = yml.getString("name");
							String author = yml.getString("author");
							String prefix = yml.getString("prefix");
							String description = yml.getString("description");
							
							ClassLoader l = URLClassLoader.newInstance(new URL[]{entry.toURL()});	
							Class<?> cl= l.loadClass(main);
							if (cl.getSuperclass().equals(Minigame.class)){
								//all right to load
								Minigame m = (Minigame)cl.newInstance();
								m.setAuthor(author);
								m.setName(name);
								m.setDescription(description);
								m.setPrefix(prefix);
								
								m.initializeStuff();
								mg.add(m);
								//all done
							}
							else{
								throw new InvalidMinigameYamlException("Could not find main class!");
							}
						}
						else{
							throw new InvalidMinigameYamlException("Invalid minigame.yml!");
						}
					}
				}catch(Exception e){
					//TODO: Throw exception
				}finally{
					try {
						zf.close();
					} catch (IOException e) {
						Mania.getInstance().getLogger().log(Level.SEVERE, "Error while disabling minigames.. disabling plugin!");
						Mania.getInstance().getServer().getPluginManager().disablePlugin(Mania.getInstance());
					}
				}
			}
		}
		return mg;
	}
	
}
