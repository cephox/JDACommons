package net.ce_phox.jdacommons.config;

import org.yaml.snakeyaml.Yaml;

import java.io.*;

public class ConfigUtils {

    public static void seralize(Object object, String filePath, ConfigType type) throws IOException {
        switch (type) {
            case YAML:
                Yaml yaml = new Yaml();
                File file = new File(filePath);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                yaml.dump(object, new FileWriter(file));
                break;
        }
    }

    public static Object deseralize(String filePath, ConfigType type) throws FileNotFoundException {
        switch (type) {
            case YAML:
                Yaml yaml = new Yaml();
                File file = new File(filePath);
                if (!file.exists()) return null;
                InputStream inputStream = new FileInputStream(file);
                return yaml.load(inputStream);
        }
        return null;
    }

    public enum ConfigType {
        YAML
    }
}
