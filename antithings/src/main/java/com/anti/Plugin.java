package com.anti;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.anti.CommandHandler.Creeper;
import com.anti.CommandHandler.TNT;

/*
 * antithings java plugin
 */
public class Plugin extends JavaPlugin implements Listener {
  private static final Logger LOGGER = Logger.getLogger("antithings");

  private TNT tnt;
  private Creeper creeper;

  public void onEnable()
  {
    tnt = new TNT();
    creeper = new Creeper();

    getServer().getPluginManager().registerEvents(tnt, this);
    getServer().getPluginManager().registerEvents(creeper, this);
    LOGGER.info("A.N.T.I enabled");
  }

  public void onDisable() {
    LOGGER.info("A.N.T.I disabled");
  }
}
