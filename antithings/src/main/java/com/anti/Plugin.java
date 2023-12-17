package com.anti;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


/*
 * antithings java plugin
 */
public class Plugin extends JavaPlugin implements Listener {
  private static final Logger LOGGER = Logger.getLogger("antithings");

  private anti an;

  public void onEnable()
  {
    an = new anti();

    getServer().getPluginManager().registerEvents(an, this);
    LOGGER.info("A.N.T.I enabled");
  }

  public void onDisable() {
    LOGGER.info("A.N.T.I disabled");
  }
}
