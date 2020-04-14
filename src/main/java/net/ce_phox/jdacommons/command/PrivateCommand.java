package net.ce_phox.jdacommons.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface PrivateCommand {

    /**
     * Executing the command
     *
     * @param event
     * @param args
     */
    void execute(MessageReceivedEvent event, String[] args);

}
