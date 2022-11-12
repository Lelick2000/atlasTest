package confuguration;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class YamlPropertiesReader {
    private static final Yaml yamlReader = new Yaml();
    private static final Map<String, Map<String, String>> yamlProperties;
    private static final String propertyPath = "common";
    private static final String configFileName = "src/test/resources/test-config.yml";

    static {
        try {
            InputStream inputStream = new FileInputStream(configFileName);
            yamlProperties = yamlReader.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getProperty(String property) {
        return yamlProperties.get(propertyPath).get(property);
    }

    public static String getApiBaseUri() {
        return getProperty("apiBaseUri");
    }
}
