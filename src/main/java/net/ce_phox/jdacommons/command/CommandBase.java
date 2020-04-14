package net.ce_phox.jdacommons.command;

public interface CommandBase {

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

}
