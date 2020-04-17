package net.ce_phox.jdacommons.config.yaml.serialization;

public @interface DelegateDeserialization {
    Class<? extends ConfigurationSerializable> value();
}
