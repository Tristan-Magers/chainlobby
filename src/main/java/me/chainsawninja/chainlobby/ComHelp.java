package me.chainsawninja.chainlobby;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ComHelp  extends Command {

    public ComHelp() {
        super("help");
    }

    public void execute(CommandSender sender, String[] args) {
        if ((sender instanceof ProxiedPlayer)) {
            ProxiedPlayer p = (ProxiedPlayer) sender;

            p.sendMessage(new ComponentBuilder("Welcome to the ChainsawNinja network. Let me help you.").color(ChatColor.GOLD).create());
            p.sendMessage(new TextComponent("§fuse §b/game (game) [#] §fto queue for a game"));
            p.sendMessage(new TextComponent("§fuse §b/dtnt [#] §fto find a game of Duel TNT"));
            p.sendMessage(new TextComponent("§fuse §b/lobby §fto return to lobby"));
        }
    }
}
