package tests.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;

public abstract class BaseApiTest {

    protected Logger log = LogManager.getLogger(this.getClass().getName());

    protected RequestSpecification reqSpec;
    protected ResponseSpecification resSpec;

    @Before
    public void setUp(){
        this.reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.novaposhta.ua")
                .addHeader("Content-Type","application/json")
                .build();
        this.resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                //.expectBody("success", hasItem(equalTo("true")))
                .build();
    }



}
