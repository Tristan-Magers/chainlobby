package me.chainsawninja.chainlobby;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ComR2 extends Command {

    public ComR2() {
        super("r2");
    }

    public void execute(CommandSender sender, String[] args) {
        if ((sender instanceof ProxiedPlayer)) {
            new GoGame(sender, "rogues", args);
        }
    }
}
