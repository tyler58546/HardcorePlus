package tyler58546.hardcoreplus;




import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.PluginManager;

import com.connorlinfoot.titleapi.TitleAPI;

import net.md_5.bungee.api.ChatColor;

public class DeathListener implements org.bukkit.event.Listener
{
  MainClass configGetter;
  
  public DeathListener(MainClass plugin)
  {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
    configGetter = plugin;
  }
  
  @org.bukkit.event.EventHandler
  public void onEvent(PlayerRespawnEvent e)
  {
    Player player = e.getPlayer();
    




    if (!configGetter.config.contains(player.getName())) {
      configGetter.getConfig().set(player.getName(), Integer.valueOf(0));
    }
    
    int playerDeaths = configGetter.getConfig().getInt(player.getName());
    
    configGetter.getConfig().set(player.getName(), Integer.valueOf(playerDeaths + 1));
    configGetter.saveConfig();
    




    if (playerDeaths > 4) {
    	
      player.setGameMode(GameMode.SPECTATOR);
      
      player.sendMessage(org.bukkit.ChatColor.RED + "Sorry, but you are all out of lives.");
      int twenty = 20;
      int hundred = 100;
      TitleAPI.sendTitle(player,twenty,hundred,twenty,ChatColor.RED + "Game Over!",ChatColor.WHITE + "You Are All Out Of Lives!");

    }
    else
    {
      int playerLives = 4 - playerDeaths;
      player.sendMessage("You have " + org.bukkit.ChatColor.GREEN + playerLives + org.bukkit.ChatColor.WHITE + " lives remaining");
    }
  }
}
