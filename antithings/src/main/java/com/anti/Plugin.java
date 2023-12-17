package com.anti;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.anti.CommandHandler.CommandHandler;

/*
 * antithings java plugin
 */
public class Plugin extends JavaPlugin implements Listener {
  private static final Logger LOGGER = Logger.getLogger("antithings");

  private CommandHandler ban;

  public void onEnable()
  {
    ban = new CommandHandler();

    getServer().getPluginManager().registerEvents(ban, this);
    LOGGER.info("antithings enabled");
  }

  public void onDisable() {
    ban.removeBannnedItems();
    LOGGER.info("antithings disabled");
  }
}
