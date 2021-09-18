package me.chainsawninja.chainlobby;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ComPing extends Command{

    public ComPing() {
        super("ping");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(sender instanceof ProxiedPlayer){
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if(args.length == 0){
                sender.sendMessage(new TextComponent("Your ping is : " + + player.getPing()));
            }else{
                sender.sendMessage(new TextComponent("§cTEST FAILED!"));
            }
        }else{
            sender.sendMessage(new TextComponent("§cMust be used by player!"));
        }

    }

}