package net.ce_phox.jdacommons.command;

/*****************************************************************************
 *                                                                           *
 *  Urheberrechtshinweis:                                                    *
 *   Copyright © Paul Stier, 2020                                            *
 *   Erstellt: 06.04.2020 / 18:20                                            *
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
    18:20.
    
    Skype: psalm.sio
    Discord: ce_phox#1259
    Minecraft: ce_phox

*/


public class CommandHandlerBuilder {

    private CommandHandler handler;

    /**
     * Constructor Stuff
     */
    public CommandHandlerBuilder(String prefix) {
        handler = new CommandHandler(prefix, false, false);
    }

    public CommandHandlerBuilder(String prefix, boolean useBots) {
        this(prefix);
        handler.setUseBots(useBots);
    }

    public CommandHandlerBuilder(String prefix, boolean useBots, boolean useWebhooks) {
        this(prefix, useBots);
        handler.setUseWebhooks(useWebhooks);
    }

    /**
     * Setting prefix
     *
     * @param prefix
     * @return
     */
    public CommandHandlerBuilder setPrefix(String prefix) {
        handler.setPrefix(prefix);
        return this;
    }

    /**
     * Setting boolean, whether Bots can use Commands
     *
     * @param useBots
     * @return
     */
    public CommandHandlerBuilder setUseBots(boolean useBots) {
        handler.setUseBots(useBots);
        return this;
    }

    /**
     * Setting boolean, whether Webhooks can use Commands
     *
     * @param useWebhooks
     * @return
     */
    public CommandHandlerBuilder setUseWebhooks(boolean useWebhooks) {
        handler.setUseWebhooks(useWebhooks);
        return this;
    }

    /**
     * Adding a Command to the command hashmap in {@link CommandHandler}
     *
     * @param command
     * @return
     */
    public CommandHandlerBuilder addCommand(Command command) {
        handler.addCommand(command);
        return this;
    }

    /**
     * Getting the CommandHandler
     *
     * @return
     */
    public CommandHandler build() {
        return handler;
    }

}
