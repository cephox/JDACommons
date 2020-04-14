package net.ce_phox.jdacommons.lang;

/*****************************************************************************
 *                                                                           *
 *  Urheberrechtshinweis:                                                    *
 *   Copyright © Paul Stier, 2020                                            *
 *   Erstellt: 06.04.2020 / 17:16                                            *
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
    17:16.
    
    Discord: ce_phox#1259

*/


public class StringUtils {

    /**
     * Replace the last regex in a String
     *
     * @param text        the text where to replace
     * @param toReplace   what to replace
     * @param replacement the replacement
     * @return the new String
     */
    public static String replaceLast(String text, String toReplace, String replacement) {
        return text.replaceFirst("(?s)(.*)" + toReplace, "$1" + replacement);
    }

}
