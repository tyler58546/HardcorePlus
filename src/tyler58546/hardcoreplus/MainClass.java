package tyler58546.hardcoreplus;

import org.bukkit.plugin.java.JavaPlugin;

import com.connorlinfoot.titleapi.TitleAPI;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MainClass extends JavaPlugin {
	
	  public void onEnable()
	  {
	    new DeathListener(this);
	    new RegenStop(this);
	  }
	  


	  public void onDisable() { saveConfig(); }
	  
	  FileConfiguration config = getConfig();
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if ((cmd.getName().equalsIgnoreCase("lives")) && ((sender instanceof Player)))
	    {

	      Player player = (Player)sender;
	      int playerDeaths = getConfig().getInt(player.getName());
	      int playerLives = 5 - playerDeaths;
	      String playerLivess = Integer.toString(playerLives);
	      if (playerLives < 1) {
	        player.sendMessage(org.bukkit.ChatColor.RED + "Sorry, but you are all out of lives.");
	        int twenty = 20;
	        int hundred = 100;
	        TitleAPI.sendTitle(player,twenty,hundred,twenty,ChatColor.RED + "Game Over!",ChatColor.WHITE + "You Are All Out Of Lives!");
	      } else {
	        player.sendMessage("You have " + org.bukkit.ChatColor.GREEN + playerLives + org.bukkit.ChatColor.WHITE + " lives remaining");

	      }
	      return true;
	    }
	    

	    return false;
	  }
}
