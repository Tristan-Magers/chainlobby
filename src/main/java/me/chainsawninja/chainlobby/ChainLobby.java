package me.chainsawninja.chainlobby;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.ProxyServer;

public class ChainLobby extends Plugin {
    @Override
    public void onEnable() {
        getLogger().info("!! ChainLobby loaded !!");
        getProxy().getPluginManager().registerListener(this, new Join());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ComLobby());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ComDtnt());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ComRogues());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ComDueltnt());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ComPing());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ComGame());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ComHelp());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ComTest());
    }
}