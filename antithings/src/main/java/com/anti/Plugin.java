package com.anti;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * antithings java plugin
 */
public class Plugin extends JavaPlugin
{
  private static final Logger LOGGER=Logger.getLogger("antithings");

  public void onEnable()
  {
    LOGGER.info("antithings enabled");
  }

  public void onDisable()
  {
    LOGGER.info("antithings disabled");
  }
}
