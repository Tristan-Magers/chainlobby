package me.chainsawninja.chainlobby;

import java.io.*;
import java.util.*;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.config.ServerInfo;

public class ComGame extends Command {

    public ComGame() {
        super("game");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer){
            String game = null;
            if(args.length > 0) {
                game = args[0];
                if(args.length > 1) new GoGame(sender, game, Arrays.copyOfRange(args, 1, args.length));
                else new GoGame(sender, game, new String[0]);
            }
            else{
                new GoGame(sender, game, new String[0]);
            }
        }
    }
}
