package com.aem.exercise.romannumeral;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RomanNumeralIntegrationTests {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGetRomanNumeral() {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/romannumeral?query=1089"),
				HttpMethod.GET, entity, String.class);

		String expected = "I\u0305LXXXIX";

		Assert.assertEquals(expected, response.getBody());
	}

	@Test
	public void test_UnavailableUrl() {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/romannumeral"),
				HttpMethod.GET, entity, String.class);

		Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	public void test_OutOfRangeValues() {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/romannumeral?query=-5"),
				HttpMethod.GET, entity, String.class);

		Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}


	@Test
	public void test_UnsupportedFormatValues() {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/romannumeral?query=ABC"),
				HttpMethod.GET, entity, String.class);

		Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}



	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
