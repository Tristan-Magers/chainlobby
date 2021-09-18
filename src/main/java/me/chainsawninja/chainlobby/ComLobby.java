package me.chainsawninja.chainlobby;

import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;

import java.util.Collection;

public class ComLobby extends Command {

    public ComLobby() {
        super("Lobby");
    }

    public void execute(CommandSender sender, String[] args) {
        if ((sender instanceof ProxiedPlayer)) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            Collection<ProxiedPlayer> p_list = p.getServer().getInfo().getPlayers();

            if (p.getServer().getInfo().getName().equalsIgnoreCase("lobby")) {
                p.sendMessage(new ComponentBuilder("You are already connected to the Hub!").color(ChatColor.RED).create());
                return;
            }
            else{
                for (ProxiedPlayer player_t : p_list) {
                    if(player_t != p) player_t.sendMessage(new TextComponent("§7" + p.getName() + "§f went to the §6Lobby"));
                }
            }

            p.sendMessage(new ComponentBuilder("Connecting you to the lobby!").color(ChatColor.GOLD).create());

            p.connect(ProxyServer.getInstance().getServerInfo("lobby"));
        }
    }
}
