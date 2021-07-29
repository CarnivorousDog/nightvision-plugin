package io.github.carnivorousdog.nightvision;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * NightVision Plugin
 * Simple Minecraft Server Plugin that toggles Nightvision mode.
 * @author Logan Brufatto
 */
public final class NightVision extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("nv")){

            //Checks if sender is a player.
            if(!(sender instanceof Player)){
                sender.sendMessage("Only players can turn on night vision.");
                return true;
            }

            Player player = (Player)sender;

            //Dis
            if(player.hasPotionEffect(PotionEffectType.NIGHT_VISION)){
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);       //Turns off NightVision if on.
                sender.sendMessage("NightVision off.");
            } else {
                player.addPotionEffect(
                        new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, false)      //Turns on Nightvision if off.
                );
                sender.sendMessage("NightVision on.");
            }
            return true;
        }
        return false;
    }
}
