package com.github.marq21project.tb.command;

/**
 * Enumeration for {@link Command}'s.
 */
public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("not a command");

    private final String commandName;

    CommandName(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
