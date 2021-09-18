package me.chainsawninja.chainlobby;

import java.io.*;
import java.util.*;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Join implements Listener {

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
        ProxiedPlayer p = (ProxiedPlayer) event.getPlayer();

        int name_ran = (int) (Math.random() * 16);

        for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {

            String name = "the server";

            switch (name_ran) {
                case 1:
                    name = "the server or whatever";
                    break;
                case 2:
                    name = "this weird network";
                    break;
                case 3:
                    name = "The Chainsaw Newkids";
                    break;
                case 4:
                    name = "the dungeon";
                    break;
                case 5:
                    name = "the clubhouse";
                    break;
                case 6:
                    name = "our treehouse §f(no girls allowed)";
                    break;
                case 7:
                    name = "ChainsawNinja's cardboard box";
                    break;
                case 8:
                    name = "a cult";
                    break;
                case 9:
                    name = "Buff Men";
                    break;
                case 10:
                    name = "our cult";
                    break;
                default :
                    name = "§fthe §6ChainsawNinja Network";
                    break;
            }

            player.sendMessage(new TextComponent("Welcome! §3" + event.getPlayer().getName() + "§f joined §6" + name));

            if(player == p){
                p.sendMessage(new TextComponent("§fuse §b/dueltnt §fto find a game of Duel TNT §7(/dtnt shortcut)"));
                p.sendMessage(new TextComponent("§fuse §b/rogues §fto find a game of Rogues 2 §7(/r2 shortcut)"));
                p.sendMessage(new TextComponent("§fuse §b/lobby §fto return to lobby"));
            }
        }
    }

}