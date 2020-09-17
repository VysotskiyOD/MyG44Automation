package tests.api;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NovaPoshtaApiTest extends MethodHelper{

    @Test
    public void getPrivateExchangeRateArchive(){
        Map<String, Object> testData = new HashMap<String, Object>();
        testData.put("modelName", "Common");
        testData.put("calledMethod", "getTiresWheelsList");
        testData.put("apiKey", "ea31a740b49da1f1af71c12a1d8fabb0");

        post(testData, "/v2.0/json/")
        .then()
                .log()
                .body(true)
                .spec(resSpec);
                //.body(matchesJsonSchema(
                //      new File(getProperty("user.dir")
                //               + "/src/test/resources/schema-validation/getTimeIntervals.json")));
    }

}
