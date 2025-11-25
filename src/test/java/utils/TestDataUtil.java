package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.InputStream;

public class TestDataUtil {

    private static JsonNode testData;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream is = TestDataUtil.class.getClassLoader()
                    .getResourceAsStream("testdata.json");

            if (is == null) {
                throw new RuntimeException("❌ testdata.json NOT FOUND under src/main/resources/");
            }

            testData = mapper.readTree(is);

        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to read testdata.json", e);
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
