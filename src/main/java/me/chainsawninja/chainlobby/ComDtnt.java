package me.chainsawninja.chainlobby;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class ComDtnt extends Command {

    public ComDtnt() {
        super("dtnt");
    }

    public void execute(CommandSender sender, String[] args) {
        if ((sender instanceof ProxiedPlayer)) {
            new GoGame(sender, "dtnt", args);
        }
    }

}
