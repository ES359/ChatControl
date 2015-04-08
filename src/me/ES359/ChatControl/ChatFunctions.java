package me.ES359.ChatControl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by ES359 on 4/7/15.
 */
public class ChatFunctions {

    private String prefix =ChatColor.translateAlternateColorCodes('&',"&a[&bChatControl&a] ");

    private String permission = ChatColor.translateAlternateColorCodes('&',getPrefix()+"&eSorry, but you are not able to use this command.");

    private String arguments = ChatColor.translateAlternateColorCodes('&',getPrefix()+"&bYou may have used incorrect arguments. &cTry using /chat help");


    public String getPrefix() {
        return prefix;
    }

    public String noPermission() {
        return permission;
    }

    public String getArguments() {
        return arguments;
    }


    public void clearChat(Player player){
        for(int i=0; i < 100; i++) {
            for(Player p : Bukkit.getServer().getOnlinePlayers()) {

                p.sendMessage("");
            }
        }
        player.sendMessage(getPrefix() + ChatColor.GREEN +"Chat has been cleared.");
    }


    /**
     *
     * Clears the chat.
     */
    public void clear() {
          for(Player p :Bukkit.getServer().getOnlinePlayers()) {

              for(int i=0; i <100; i ++) {
                  p.sendMessage("");
              }
              p.sendMessage(getPrefix() + ChatColor.GOLD +"Chat has been cleared.");
          }
        //Bukkit.getServer().broadcastMessage("");
    }


}
