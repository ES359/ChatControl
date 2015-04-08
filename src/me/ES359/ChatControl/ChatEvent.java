package me.ES359.ChatControl;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.PluginDescriptionFile;

/**
 * Created by ES359 on 4/7/15.
 */
public class ChatEvent implements Listener {

    //private ChatFunctions function = new ChatFunctions();


    private boolean enabled;

    public void setStatus(boolean chat) {
        this.enabled = chat;
    }

    public boolean getStatus() {
        return this.enabled;
    }

    @EventHandler
    public void chat(AsyncPlayerChatEvent event) {

      //  boolean test = false;

        Player p = event.getPlayer();

        String name = p.getName();

        String uuid = ""+p.getUniqueId();

        if(this.getStatus()) {
            event.setCancelled(true);
            p.sendMessage(ChatColor.RED+" Chat has been disabled by an Administrator.");
        }else {
            event.setCancelled(false);
        }
    }
}