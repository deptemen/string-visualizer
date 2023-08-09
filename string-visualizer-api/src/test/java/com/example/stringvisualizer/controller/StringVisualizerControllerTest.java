package com.example.stringvisualizer.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StringVisualizerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void testStringVisualizer() {
        String requestBody = "{\"inputString1\": \"mmmmm m nnnnn y&friend&Paul has heavy hats! &\", \"inputString2\": \"my frie n d Joh n has ma n y ma n y frie n ds n&\"}";
        String expectedOutput = "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/visualize-max-occurrence", requestEntity, String.class);

        Assertions.assertEquals(expectedOutput, response.getBody());
    }

    @Test
    public void testStringVisualizerForEmptyStrings() {
        String requestBody = "{\"inputString1\": \"\", \"inputString2\": \"\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/visualize-max-occurrence", requestEntity, String.class);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testStringVisualizerForUpperCaseStrings() {
        String requestBody = "{\"inputString1\": \"ABCDAS\", \"inputString2\": \"ABCRG\"}";
        String expectedOutput = "Please provide valid inputs to compare";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/visualize-max-occurrence", requestEntity, String.class);

        Assertions.assertEquals(expectedOutput, response.getBody());
    }
}
