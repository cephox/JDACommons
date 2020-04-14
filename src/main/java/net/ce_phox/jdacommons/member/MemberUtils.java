package net.ce_phox.jdacommons.member;

import net.dv8tion.jda.api.entities.*;

import java.util.concurrent.TimeUnit;

/*****************************************************************************
 *                                                                           *
 *  Urheberrechtshinweis:                                                    *
 *   Copyright © Paul Stier, 2020                                            *
 *   Erstellt: 06.04.2020 / 17:26                                            *
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
    17:26.
    
    Skype: psalm.sio
    Discord: ce_phox#1259
    Minecraft: ce_phox

*/


public class MemberUtils {

    /**
     * Sending a message (a String) to a Member
     *
     * @param member
     * @param message
     */
    public static void sendPM(Member member, String message) {
        member.getUser().openPrivateChannel().complete().sendMessage(message).queue();
    }

    /**
     * Sending a message (an embed) to a Member
     *
     * @param member
     * @param message
     */
    public static void sendPM(Member member, MessageEmbed message) {
        member.getUser().openPrivateChannel().complete().sendMessage(message).queue();
    }

    /**
     * Sending a message (a Message Object) to a Member
     *
     * @param member
     * @param message
     */
    public static void sendPM(Member member, Message message) {
        member.getUser().openPrivateChannel().complete().sendMessage(message).queue();
    }

    /**
     * Disconnects a member from a VoiceChannel
     *
     * @param member
     */
    public static void disconnectMember(Member member) {
        if (member.getVoiceState().inVoiceChannel()) member.getGuild().moveVoiceMember(member, null).queue();
    }

    /**
     * Moves a member into a VoiceChannel
     *
     * @param member
     * @param vc
     */
    public static void moveMember(Member member, VoiceChannel vc) {
        if (member.getVoiceState().inVoiceChannel()) vc.getGuild().moveVoiceMember(member, vc).queue();
    }

    /**
     * Adds a role to a member and later removes it
     *
     * @param role
     * @param member
     * @param unit
     * @param time
     */
    public static void addRoleTemporary(Member member, Role role, TimeUnit unit, int time) {
        Guild guild = role.getGuild();
        guild.addRoleToMember(member, role).queue();
        guild.removeRoleFromMember(member, role).queueAfter(time, unit);
    }

    /**
     * Adds a role to a member
     *
     * @param role
     * @param member
     */
    public static void addRole(Member member, Role role) {
        role.getGuild().addRoleToMember(member, role).queue();
    }

    /**
     * Removes a role from a member
     *
     * @param role
     * @param member
     */
    public static void removeRole(Member member, Role role) {
        role.getGuild().removeRoleFromMember(member, role).queue();
    }

    /**
     * Toggles a role for a member
     *
     * @param role
     * @param member
     */
    public static void toggleRole(Member member, Role role) {
        if (hasRole(member, role)) removeRole(member, role);
        else addRole(member, role);
    }

    /**
     * Check if the member has the role already
     *
     * @param member
     * @param role
     * @return
     */
    public static boolean hasRole(Member member, Role role) {
        return member.getRoles().contains(role);
    }
}
