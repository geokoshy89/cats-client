package com.example.catsclient;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import wiremock.org.eclipse.jetty.http.HttpHeader;

//@AutoConfigureWireMock(port = 8080)
@AutoConfigureStubRunner(ids="com.example:cats-service:+:8080",stubsMode = StubRunnerProperties.StubsMode.REMOTE,
		repositoryRoot = "https://geokoshy89.jfrog.io/artifactory/cloudnativejava-libs-snapshot-local/")
@SpringBootTest
//@ActiveProfiles("test")
class CatsClientApplicationTests {

	@Autowired
	private CatClient catClient;

	@Test
	void contextLoads() {
//		var body="{\"name\":\"Toby\"}";
//		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/cat/Toby"))
//		.willReturn(WireMock.aResponse()
//		.withBody(body)
//				.withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//		));

		Cats toby = catClient.findByName("Toby");
		Assertions.assertThat(toby.getName()).isEqualTo("Toby");
	}

}
