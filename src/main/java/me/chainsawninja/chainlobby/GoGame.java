package me.chainsawninja.chainlobby;

import java.util.*;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Collection;
import java.util.Map;

public class GoGame {

    GoGame(CommandSender sender, String game, String[] args) {
        if(sender instanceof ProxiedPlayer){
            ProxiedPlayer player = (ProxiedPlayer) sender;
            String g = game;
            if(game == null){ //if no game sent
                sender.sendMessage(new TextComponent("Specify game (ex. /game dtnt [#])"));
            }else{
                ProxiedPlayer p = (ProxiedPlayer) sender;

                //establish strings to check
                String dueltnt = new String("dueltnt");
                String dtnt = new String("dtnt");

                //correct any alternative names
                if(g.equals(dueltnt)) g = "dtnt";

                //check if specific server number, and send to server
                if(args.length > 0){
                    String sp_server = g + args[0];
                    try
                    {
                        player.sendMessage(new ComponentBuilder("Finding a specific server").color(ChatColor.GOLD).create());
                        sender.sendMessage(new TextComponent("Specific server : " + sp_server));

                        Map<String,ServerInfo> allservers = ProxyServer.getInstance().getServers();
                        if(!allservers.containsKey(sp_server)) {
                            player.sendMessage(new ComponentBuilder("SERVER NOT FOUND").color(ChatColor.RED).create());
                            return;
                        }
                        Integer.parseInt(args[0]);

                        ServerInfo sp_info = ProxyServer.getInstance().getServerInfo(sp_server);
                        Collection<ProxiedPlayer> sp_players = sp_info.getPlayers();
                        sender.sendMessage(new TextComponent("Current players : " + sp_players));

                        TellLeave(sender,game);
                        p.connect(sp_info);
                        return;
                    }
                    catch (NumberFormatException e)
                    {

                    }
                }

                //If detect player name, set it for checks
                String p_search = null;
                if(args.length > 0){
                    p_search = args[0];
                }

                //Select message based on game
                boolean knowngame = false;

                if(g.equals(dtnt)){
                    player.sendMessage(new ComponentBuilder("Finding a Duel TNT match!").color(ChatColor.GOLD).create());
                    knowngame = true;
                }

                if(!knowngame) {
                    player.sendMessage(new ComponentBuilder("Finding a " + g + " match!").color(ChatColor.GOLD).create());
                }


                //Server find
                SelectServer(sender, g, p_search);
            }
        }
    }

    public void SelectServer(CommandSender sender, String game, String p_search) {

        //if(p_search != null) sender.sendMessage(new TextComponent("§6Finding player §f: " + p_search));
        Collection<ProxiedPlayer> f_players = ProxyServer.getInstance().getServerInfo("dtnt4").getPlayers();

        int tlength = 9;

        String[] gametest = new String[tlength];
        String[] success = new String[gametest.length];
        ProxiedPlayer p = (ProxiedPlayer) sender;
        Server myserver = p.getServer();

        int amount = 0;
        for(int i = 1 ; i <= gametest.length ; i++){
            gametest[i-1] = game + i;
            String server = gametest[i-1];
            int count = ServerPCount(server);
            if (count >= 0){
                success[amount] = server;
                amount++;

                //Collection<ProxiedPlayer> t_players = ProxyServer.getInstance().getServerInfo(server).getPlayers();
                //f_players.addAll(t_players);
            }
        }

        //if(p_search != null) sender.sendMessage(new TextComponent("§6Found players §f: " + f_players));
        //if(p_search != null && f_players.contains(p_search)) sender.sendMessage(new TextComponent("Success!!"));

        if(amount == 0){
            sender.sendMessage(new TextComponent("Game not found"));
            return;
        }

        String firstserver = "none";
        String minserver = "none";
        int minserverc = 3;

        for(int i = 0 ; i < amount ; i++){
            String server = success[i];
            int count = ServerPCount(server);
            //p.sendMessage(new TextComponent("Server " + server + " has player count : " + count));
            if(count > 0 && count < minserverc && ProxyServer.getInstance().getServerInfo(server) != myserver.getInfo()) {
                minserver = server;
                minserverc = ServerPCount(server);
            }
            else{
                if(minserver != server && count < 4 && firstserver == "none" && ProxyServer.getInstance().getServerInfo(server) != myserver.getInfo()) {
                    firstserver = server;
                }
            }
        }

        if(minserver != "none"){
            sender.sendMessage(new TextComponent("§7Server : " + minserver + " (ongoing game)"));
            TellLeave(sender,game);
            p.connect(ProxyServer.getInstance().getServerInfo(minserver));
        }else {
            if(firstserver != "none") {
                sender.sendMessage(new TextComponent("§7Server : " + firstserver + " (first player)"));
                TellLeave(sender,game);
                p.connect(ProxyServer.getInstance().getServerInfo(firstserver));
            }
            else{
                sender.sendMessage(new TextComponent("No servers available"));
            }
        }

    }

    public int ServerPCount(String server) {

        Map<String, ServerInfo> servers = ProxyServer.getInstance().getServers();
        if(servers.get(server) != null){
            Collection<ProxiedPlayer> players = ProxyServer.getInstance().getServerInfo(server).getPlayers();
            int size = players.size();
            return size;
        }
        else {
            return -1;
        }
    }

    public void TellLeave(CommandSender sender, String game) {
        ProxiedPlayer p = (ProxiedPlayer) sender;
        Collection<ProxiedPlayer> p_list = p.getServer().getInfo().getPlayers();

        String dtnt = new String("dtnt");
        String rogues = new String("rogues");

         if(game.equals(dtnt)) {
             for (ProxiedPlayer player_t : p_list) {
                 if(player_t != p) player_t.sendMessage(new TextComponent("§7" + p.getName() + "§f joined §6Duel TNT"));
             }
         }

        if(game.equals(rogues)) {
            for (ProxiedPlayer player_t : p_list) {
                if(player_t != p) player_t.sendMessage(new TextComponent("§7" + p.getName() + "§f joined §6Rogues 2"));
            }
        }

    }
}
