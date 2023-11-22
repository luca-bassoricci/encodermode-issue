package org.acme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
@TestHTTPEndpoint(ServerResource.class)
class ClientTest {

    @Test
    void test(@TempDir File tempDir) throws IOException {
        File f = File.createTempFile("tmp", null, tempDir);
        try (var w = new FileWriter(f)) {
            w.write("a string");
        }
        RestAssured.given()
                .contentType("multipart/form-data")
                .multiPart("file", f)
                .when().post("test").then().statusCode(200);
    }
}
