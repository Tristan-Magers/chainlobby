package me.chainsawninja.chainlobby;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ComRogues extends Command {

    public ComRogues() {
        super("rogues");
    }

    public void execute(CommandSender sender, String[] args) {
        if ((sender instanceof ProxiedPlayer)) {
            new GoGame(sender, "rogues", args);
        }
    }
}
