package com.anti.CommandHandler;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class Creeper implements Listener{
    @EventHandler
    public void onCreatureSpawnEvent(CreatureSpawnEvent event) {
        if (event.getEntity() instanceof Creeper) {
            event.setCancelled(true);
        }
    }
}
