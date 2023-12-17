package com.anti.CommandHandler;

import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class TNT implements Listener{

    // This will make TNT can't explode
    @EventHandler
    public void onEntityPlace(EntityExplodeEvent event) {
        if (event.getEntity() instanceof TNTPrimed) {
            event.setCancelled(true);
        }
    }
}
