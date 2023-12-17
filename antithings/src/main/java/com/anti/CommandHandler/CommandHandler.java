package com.anti.CommandHandler;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Material;


public class CommandHandler implements CommandExecutor {
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
}
