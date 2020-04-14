package net.ce_phox.jdacommons;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.sharding.ShardManager;

/*****************************************************************************
 *                                                                           *
 *  Urheberrechtshinweis:                                                    *
 *   Copyright © Paul Stier, 2020                                            *
 *   Erstellt: 08.04.2020 / 11:47                                            *
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
    08.04.2020
    at
    11:47.
    
    Discord: ce_phox#1259

*/


public class JDACommons {

    /**
     * Getting the Amount of guilds your JDA is in
     *
     * @param jda
     * @return
     */
    public static int getAmountOfGuildsIn(JDA jda) {
        return jda.getGuilds().size();
    }

    /**
     * Getting the Amount of guild your shards are in combined
     *
     * @param shardManager
     * @return
     */
    public static int getAmountOfGuildsIn(ShardManager shardManager) {
        return shardManager.getShards().stream().mapToInt(JDACommons::getAmountOfGuildsIn).sum();
    }

    /**
     * Shutting down the Shardmanager and his Shards
     *
     * @param shardManager
     */
    public static void shutdown(ShardManager shardManager) {
        new Thread(() -> {
            if (shardManager != null) {
                shardManager.setStatus(OnlineStatus.OFFLINE);
                shardManager.getShards().forEach(JDA::shutdown);
                shardManager.shutdown();
            }
        }).start();
    }
}
