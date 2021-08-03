package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YAMLHelper {

    public String getProperty(String property) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        JsonNode jsonNode = mapper.readValue(new File("src/test/resources/configuration.json"), JsonNode.class);
        JsonNode object = jsonNode.get(0);
        return object.get(property).textValue();
    }
}
