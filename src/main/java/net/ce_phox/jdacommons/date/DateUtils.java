package net.ce_phox.jdacommons.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*****************************************************************************
 *                                                                           *
 *  Urheberrechtshinweis:                                                    *
 *   Copyright © Paul Stier, 2020                                            *
 *   Erstellt: 07.04.2020 / 10:19                                            *
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
    07.04.2020
    at
    10:19.
    
    Skype: psalm.sio
    Discord: ce_phox#1259
    Minecraft: ce_phox

*/


public class DateUtils {

    /**
     * Returns a date by a pattern e.g.
     * Pattern: dd.MM.yyyy
     * Date: 01.01.2020
     * <p>
     * Returns the date for 1. January of 2020
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Date parseDate(String date, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Returns a date by Pattern: dd.MM.yyyy
     * Same as above
     *
     * @param date
     * @return
     */
    public static Date parseDate(String date) {
        return parseDate(date, "dd.MM.yyyy");
    }
}
