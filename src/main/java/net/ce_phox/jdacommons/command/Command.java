package net.ce_phox.jdacommons.command;

/*****************************************************************************
 *                                                                           *
 *  Urheberrechtshinweis:                                                    *
 *   Copyright © Paul Stier, 2020                                            *
 *   Erstellt: 06.04.2020 / 17:53                                            *
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
    17:53.
    
    Skype: psalm.sio
    Discord: ce_phox#1259
    Minecraft: ce_phox


*/

public interface Command {

    /**
     * Getting the invoke of the Command e.g. "help"
     *
     * @return
     */
    String getInvoke();

    /**
     * Getting the help of a command e.g. for a possible help-command
     *
     * @return
     */
    String getHelp();

    /**
     * Executing the command
     *
     * @param event
     * @param args
     */
    void execute(CommandExecutedEvent event, String[] args);

}
