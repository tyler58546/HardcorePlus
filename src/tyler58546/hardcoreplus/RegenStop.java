package tyler58546.hardcoreplus;





import org.bukkit.event.entity.EntityRegainHealthEvent;

public class RegenStop implements org.bukkit.event.Listener
{
  MainClass configGetter;
  
  public RegenStop(MainClass plugin)
  {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
    configGetter = plugin;
  }
  
  @org.bukkit.event.EventHandler
  public void onEvent(EntityRegainHealthEvent e)
  {
	  e.setCancelled(true);
    /*Player player = e.getPlayer();
    




    if (!configGetter.config.contains(player.getName())) {
      configGetter.getConfig().set(player.getName(), Integer.valueOf(0));
    }
    
    int playerDeaths = configGetter.getConfig().getInt(player.getName());
    
    configGetter.getConfig().set(player.getName(), Integer.valueOf(playerDeaths + 1));
    configGetter.saveConfig();
    




    if (playerDeaths > 4) {
    	
      player.setGameMode(GameMode.SPECTATOR);
      
      player.sendMessage(org.bukkit.ChatColor.RED + "Sorry, but you are all out of lives.");

    }
    else
    {
      int playerLives = 5 - playerDeaths;
      player.sendMessage("You have " + org.bukkit.ChatColor.GREEN + playerLives + org.bukkit.ChatColor.WHITE + " lives remaining");
    }*/
  }
}
