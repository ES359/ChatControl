package me.ES359.ChatControl;

import me.ES359.ChatControl.Report.GetReports;
import me.ES359.ChatControl.Report.Report;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by ES359 on 4/7/15.
 */
public class ChatControl extends JavaPlugin{

    public PluginDescriptionFile pdfFile = this.getDescription();

    public ChatEvent chat;

    public void onEnable()
    {
        this.chat = new ChatEvent();

        this.getCommand("chat").setExecutor(new ChatCommand(this));
        this.getCommand("chat-report").setExecutor(new Report());
        this.getCommand("chat-reports").setExecutor(new GetReports());
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(chat,this);
    }

}
