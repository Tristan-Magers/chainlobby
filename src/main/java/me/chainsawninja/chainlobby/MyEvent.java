package me.chainsawninja.chainlobby;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.Event;

public class MyEvent extends Event {
    private final String message;

    public MyEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
