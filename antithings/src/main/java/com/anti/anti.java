package com.anti;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class anti implements Listener{
    
    // This will prevent tnt explosion events
    @EventHandler
    public void onEntityPlace(EntityExplodeEvent event) {
        if (event.getEntity() instanceof TNTPrimed) {
            event.setCancelled(true);
        }
    }

    // This will prevent creeper spawn events
    @EventHandler
    public void onCreatureSpawnEvent (CreatureSpawnEvent event) {
        if (event.getEntity() instanceof Creeper) {
            event.setCancelled(true);
        }
    }
    // Farm Protection Events
    @EventHandler
    public void onPlayerInteractEvent (PlayerInteractEvent event) {
        if (event.getAction() == Action.PHYSICAL) {
            Block block = event.getClickedBlock();
            if (block != null && block.getType() == Material.FARMLAND) {
                event.setCancelled(true);
            }
        }
    }
}
