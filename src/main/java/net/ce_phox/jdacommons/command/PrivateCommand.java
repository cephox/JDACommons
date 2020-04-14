package net.ce_phox.jdacommons.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/*****************************************************************************
 *                                                                           *
 *  Urheberrechtshinweis:                                                    *
 *   Copyright © Paul Stier, 2020                                            *
 *   Erstellt: 14.04.2020 / 12:45                                            *
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
    14.04.2020 12:45.
    
    Discord: ce_phox#1259

*/


public interface PrivateCommand extends CommandBase {

    /**
     * Executing the command
     *
     * @param event
     * @param args
     */
    void execute(MessageReceivedEvent event, String[] args);

}
