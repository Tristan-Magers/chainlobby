package me.chainsawninja.chainlobby;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Collection;

import net.md_5.bungee.api.score.Objective;
import net.md_5.bungee.api.score.Scoreboard;
import net.md_5.bungee.protocol.DefinedPacket;

public class ComTest extends Command {

    static int test = 0;
    //Collection<ProxiedPlayer> f_players = new Collection<ProxiedPlayer>();

    public ComTest() {
        super("test");
    }

    public void execute(CommandSender sender, String[] args) {
        if ((sender instanceof ProxiedPlayer)) {
            ProxiedPlayer p = (ProxiedPlayer) sender;

            test++;
            p.sendMessage(new TextComponent("Test : " + test));

            //Scoreboard scoreb = p.getScoreboard();
            //Objective newob = new Objective("test", "Test", "integer");
            //p.unsafe().sendPacket();
        }
    }
}
