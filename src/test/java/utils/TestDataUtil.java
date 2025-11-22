package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class TestDataUtil {

    private static JsonNode testData;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            testData = mapper.readTree(new File("src/main/resources/testdata.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Path example: login.valid.email
    public static String getValue(String path) {
        String[] keys = path.split("\\.");
        JsonNode current = testData;

        for (String key : keys) {
            current = current.get(key);
        }

        return current.asText();
    }
}
