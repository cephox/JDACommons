package net.ce_phox.jdacommons.config.yaml;

public class InvalidConfigurationException extends Exception {

    public InvalidConfigurationException() {
    }

    public InvalidConfigurationException(String msg) {
        super(msg);
    }

    public InvalidConfigurationException(Throwable cause) {
        super(cause);
    }

    public InvalidConfigurationException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
