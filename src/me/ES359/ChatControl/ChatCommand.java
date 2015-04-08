package me.ES359.ChatControl;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by ES359 on 4/7/15.
 */
public class ChatCommand implements CommandExecutor{

    private ChatFunctions function = new ChatFunctions();

    private ChatControl main;

    public ChatCommand(ChatControl instance) {
        this.main = instance;
    }


    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED+"Sorry, the Console cannot use this yet!");
            return true;
        }

        Player p = (Player)sender;



        if(cmd.getName().equalsIgnoreCase("chat")) {
            if(!p.hasPermission("chatcontrol.cmd"))
            {
                p.sendMessage(function.noPermission());
            }else {
                if(args.length < 1)
                {
                    p.sendMessage(function.getArguments());
                }else if(args.length > 0) {
                    if(args[0].equalsIgnoreCase("clear"))
                    {
                        function.clear();

                        return true;
                        //function.clearChat(p);
                    }
                    if(args[0].equalsIgnoreCase("enabled"))
                    {
                        this.main.chat.setStatus(false);
                        p.sendMessage(this.function.getPrefix() + ChatColor.GREEN +"Chat has been enabled.");
                        return true;
                    }

                    if(args[0].equalsIgnoreCase("disabled")) {
                        this.main.chat.setStatus(true);
                        p.sendMessage(this.function.getPrefix() +ChatColor.RED+"Chat has been disabled. ");
                    }

                    if(args[0].equalsIgnoreCase("help"))
                    {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                "&b&l████████ &6&l████████ &b&l████████\n"
                                        +"&6Plugin, "+main.pdfFile.getName()+ChatColor.GREEN+" v" +main.pdfFile.getVersion()+" &ccreated by,"+main.pdfFile.getAuthors()+"\n"
                                        +"&cCommand usage: &e/chat < [enabled] || [disabled] || [clear]>\n"
                                        +"&6Permissions: &2chatcontrol.cmd\n"
                                        +"&cQuestions? &6Comments? &a&oBug reports?\n Use /chat-report to help out!"
                        ));
                    }
                }
            }
        }
        return true;
    }
}
