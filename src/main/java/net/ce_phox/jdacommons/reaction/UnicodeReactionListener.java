package net.ce_phox.jdacommons.reaction;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

/*****************************************************************************
 *                                                                           *
 *  Urheberrechtshinweis:                                                    *
 *   Copyright © Paul Stier, 2020                                            *
 *   Erstellt: 06.04.2020 / 17:43                                            *
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
    17:43.
    
    Skype: psalm.sio
    Discord: ce_phox#1259
    Minecraft: ce_phox

*/


public class UnicodeReactionListener extends ListenerAdapter {

    private long messageId, textChannelId;
    private String unicode;
    private ReactionState trigger;

    public UnicodeReactionListener(String unicode, long messageId, ReactionState trigger) {
        this.messageId = messageId;
        this.unicode = unicode;
        this.trigger = trigger;
    }

    /**
     * Triggering the ReactionState.reactionAdded Event if the correct Emote has been reacted
     *
     * @param event
     */
    @Override
    public void onGuildMessageReactionAdd(@Nonnull GuildMessageReactionAddEvent event) {
        try {
            if (event.getReactionEmote().getName().equalsIgnoreCase(unicode) && !event.getMember().getUser().equals(event.getJDA().getSelfUser())) {
                if (event.getMessageIdLong() == messageId) {
                    this.trigger.reactionAdded(event);
                    textChannelId = event.getChannel().getIdLong();
                }
            }
        } catch (Exception ex) {
        }
    }

    /**
     * Triggering the ReactionState.reactionRemoved Event if the correct Emote has been unreacted
     *
     * @param event
     */
    @Override
    public void onGuildMessageReactionRemove(@Nonnull GuildMessageReactionRemoveEvent event) {
        try {
            if (event.getReactionEmote().getName().equalsIgnoreCase(unicode) && !event.getMember().getUser().equals(event.getJDA().getSelfUser())) {
                if (event.getMessageIdLong() == messageId) {
                    this.trigger.reactionRemoved(event);
                    textChannelId = event.getChannel().getIdLong();
                }
            }
        } catch (Exception ex) {
        }
    }

    /**
     * Removing the reaction while leaving the guild
     *
     * @param event
     */
    @Override
    public void onGuildMemberLeave(@Nonnull GuildMemberLeaveEvent event) {
        try {
            Member member = event.getMember();
            Guild guild = event.getGuild();
            TextChannel channel = guild.getTextChannelById(textChannelId);
            channel.removeReactionById(messageId, unicode, member.getUser()).queue();
        } catch (Exception ex) {
        }
    }

    public interface ReactionState {
        void reactionAdded(GuildMessageReactionAddEvent event);

        void reactionRemoved(GuildMessageReactionRemoveEvent event);
    }

}
