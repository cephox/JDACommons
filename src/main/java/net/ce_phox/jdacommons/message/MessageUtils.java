package net.ce_phox.jdacommons.message;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;
import java.util.List;

/*****************************************************************************
 *                                                                           *
 *  Urheberrechtshinweis:                                                    *
 *   Copyright © Paul Stier, 2020                                            *
 *   Erstellt: 06.04.2020 / 17:17                                            *
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
    17:17.
    
    Discord: ce_phox#1259

*/


public class MessageUtils {

    /**
     * Deletes the amount of lastest messages in a TextChannel
     *
     * @param channel
     * @param amount
     */
    public static void deleteMessages(TextChannel channel, int amount) {
        channel.purgeMessages(getMessages(channel, amount));
    }

    /**
     * Deletes the latest message in a TextChannel
     *
     * @param channel
     */
    public static void deleteLastMessage(TextChannel channel) {
        deleteMessages(channel, 1);
    }

    /**
     * Getting a List of Messages, pinned messages excluded
     *
     * @param channel
     * @param messageAmount
     * @return
     */
    public static List<Message> getMessages(TextChannel channel, int messageAmount) {
        return getMessages(channel, messageAmount, false);
    }

    /**
     * Getting a list of Messages
     *
     * @param channel
     * @param messageAmount
     * @param includePinned supposes whether pinned messages are included or not, default=false
     * @return
     */
    public static List<Message> getMessages(TextChannel channel, int messageAmount, boolean includePinned) {
        List<Message> messages = new ArrayList<>();
        int i = messageAmount;
        for (Message message : channel.getIterableHistory().cache(false)) {

            if (!message.isPinned()) messages.add(message);
            else if (message.isPinned() && includePinned) messages.add(message);

            if (--i <= 0) break;
        }
        return messages;
    }

}
