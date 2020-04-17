package net.ce_phox.jdacommons.config.yaml.serialization;

import java.util.Map;

public interface ConfigurationSerializable {
    Map<String, Object> serialize();
}
