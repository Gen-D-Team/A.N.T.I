package com.anti.CommandHandler;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;


public class CommandHandler implements CommandExecutor, Listener {
    // Created a stored for ban items
    private  Set<Material> bannedItems = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("banid")) {
            // check if user is has provided the items to ban
            if (args.length == 1) {
                // Take materials name
                Material material = Material.getMaterial(args[0].toUpperCase());
                // check if  the material is available
                if (material != null) {
                    bannedItems.add(material);
                }
            }
        }
        return false;
    }
    
    public void removeBannnedItems() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.getInventory().forEach(itemStack -> {
                if (itemStack != null && bannedItems.contains(itemStack.getType())) {
                    player.getInventory().remove(itemStack);
                }
            });
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (bannedItems.contains(event.getBlock().getType())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + " You cannot place " + event.getBlock().getType().name());
        }
    }

    @EventHandler
    public void onEntityPlace(EntityExplodeEvent event) {
        if (event.getEntity() instanceof TNTPrimed && bannedItems.contains(Material.TNT)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onCreatureSpawnEvent(CreatureSpawnEvent event) {
        if (event.getEntity() instanceof Creeper) {
            event.setCancelled(true);
        }
    }
}
