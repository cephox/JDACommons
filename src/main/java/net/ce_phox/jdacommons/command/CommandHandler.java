package net.ce_phox.jdacommons.command;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.regex.Pattern;

/*****************************************************************************
 *                                                                           *
 *  Urheberrechtshinweis:                                                    *
 *   Copyright © Paul Stier, 2020                                            *
 *   Erstellt: 06.04.2020 / 17:58                                            *
 *                                                                           *
 *   Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.        *
 *   Das Urheberrecht liegt, soweit noch ausdrücklich anders gekennzeichnet, *
 *   bei Paul Stier. Alle Rechte vorbehalten.                                *
 *                                                                           *
 *   Jede Art von Vervielfältigung, Verbreitung, Vermietung, Verleihung,     *
 *   öffentliche Zugänglichmachung, Veränderung oder andere Nutzung          *
 *   bedarf der ausdrücklichen, schriftlichen Zustimmung von Paul Stier.     *
 *                                                                           *
 *****************************************************************************/

/*

    Class created by ce_phox on
    06.04.2020
    at
    17:58.
    
    Skype: psalm.sio
    Discord: ce_phox#1259
    Minecraft: ce_phox

*/


public class CommandHandler extends ListenerAdapter {

    private HashMap<String, CommandBase> commands;
    private String prefix;

    private boolean useBots, useWebhooks;

    public CommandHandler(String prefix, boolean useBots, boolean useWebhooks) {
        commands = new HashMap<>();
        this.prefix = prefix;
        this.useBots = useBots;
        this.useWebhooks = useWebhooks;
    }

    /**
     * Handling command execution via {@link GuildMessageReceivedEvent}
     *
     * @param event
     */
    public void handle(GuildMessageReceivedEvent event) {

        // Splitting the message by spaces and removing the command prefix
        String[] split = event.getMessage().getContentRaw()
                .replaceFirst("(?i)" + Pattern.quote(prefix), "")
                .split(" ");

        // Getting the invoke
        String invoke = split[0].toLowerCase();

        // Executing command
        if (commands.containsKey(invoke)) {
            CommandBase base = commands.get(invoke);

            if (base instanceof Command) {

                String[] args = Arrays.copyOfRange(split, 1, split.length);
                ((Command) base).execute(event, args);

            }

        }

    }

    /**
     * Adding a command to the hashmap if not already in use
     *
     * @param command
     */
    public void addCommand(CommandBase command) {
        if (!commands.containsKey(command.getInvoke()))
            commands.put(command.getInvoke(), command);
    }

    /**
     * Getting a command from it's invoke
     * If not there, returning null
     *
     * @param invoke
     * @return
     */
    public CommandBase getCommand(String invoke) {
        if (commands.containsKey(invoke))
            return commands.get(invoke);
        return null;
    }

    /**
     * Getting all commands as a collection
     *
     * @return
     */
    public Collection<CommandBase> getCommands() {
        return commands.values();
    }

    /**
     * Triggering command execution handling, depending of bot using / webhook using booleans
     *
     * @param event
     */
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        if (!event.getMessage().getContentRaw().startsWith(prefix))
            return;

        if (useBots && event.getAuthor().isBot()) {
            handle(event);
            return;
        } else if (useWebhooks && event.isWebhookMessage()) {
            handle(event);
            return;
        }

        if (!event.getAuthor().isBot() && !event.isWebhookMessage())
            handle(event);

    }

    /**
     * Getters and Setters
     */
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean isUseBots() {
        return useBots;
    }

    public void setUseBots(boolean useBots) {
        this.useBots = useBots;
    }

    public boolean isUseWebhooks() {
        return useWebhooks;
    }

    public void setUseWebhooks(boolean useWebhooks) {
        this.useWebhooks = useWebhooks;
    }
}