package tests.api;

import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static java.lang.System.getProperty;

public class PrivatApiTest extends MethodHelper{


    @Test
    public void getPrivateExchangeRateArchive(){
        Map<String, Object> testData = new HashMap<>();
        testData.put("coursid", 5);

        get(testData, "/pubinfo")
                .then()
                .log()
                .all(true)
                .spec(resSpec)
                .body(matchesJsonSchema(
                        new File(getProperty("user.dir")
                                + "/src/test/resources/schema-validation/getPubinfoSchema.json")));
    }

}
