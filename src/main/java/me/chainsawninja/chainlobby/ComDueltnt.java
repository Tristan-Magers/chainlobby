package me.chainsawninja.chainlobby;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ComDueltnt extends Command {

    public ComDueltnt() {
        super("dueltnt");
    }

    public void execute(CommandSender sender, String[] args) {
        if ((sender instanceof ProxiedPlayer)) {
            new GoGame(sender, "dtnt", args);
        }
    }
}
