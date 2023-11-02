package com.testjava.zaratest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ZaraTestApplicationTests {

	@Test
	void givenScopeWhenConstructThenDoNotThrowException() {
		assertDoesNotThrow(ZaraTestApplication::new);
	}

}
