package net.ce_phox.jdacommons.command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;

/*****************************************************************************
 *                                                                           *
 *  Urheberrechtshinweis:                                                    *
 *   Copyright © Paul Stier, 2020                                            *
 *   Erstellt: 06.04.2020 / 17:54                                            *
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
    17:54.
    
    Skype: psalm.sio
    Discord: ce_phox#1259
    Minecraft: ce_phox

*/


public class CommandExecutedEvent {

    private Message message;
    private Member member;
    private User author;
    private boolean webhookMessage;

    private TextChannel channel;
    private long messageIdLong;
    private String messageId;

    private Guild guild;

    private JDA jda;
    private long responseNumber;

    public CommandExecutedEvent(Message message, Member member, User author, boolean webhookMessage, TextChannel channel, long messageIdLong, String messageId, Guild guild, JDA jda, long responseNumber) {
        this.message = message;
        this.member = member;
        this.author = author;
        this.webhookMessage = webhookMessage;
        this.channel = channel;
        this.messageIdLong = messageIdLong;
        this.messageId = messageId;
        this.guild = guild;
        this.jda = jda;
        this.responseNumber = responseNumber;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public boolean isWebhookMessage() {
        return webhookMessage;
    }

    public void setWebhookMessage(boolean webhookMessage) {
        this.webhookMessage = webhookMessage;
    }

    public TextChannel getChannel() {
        return channel;
    }

    public void setChannel(TextChannel channel) {
        this.channel = channel;
    }

    public long getMessageIdLong() {
        return messageIdLong;
    }

    public void setMessageIdLong(long messageIdLong) {
        this.messageIdLong = messageIdLong;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Guild getGuild() {
        return guild;
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }

    public JDA getJDA() {
        return jda;
    }

    public void setJDA(JDA jda) {
        this.jda = jda;
    }

    public long getResponseNumber() {
        return responseNumber;
    }

    public void setResponseNumber(long responseNumber) {
        this.responseNumber = responseNumber;
    }
}
