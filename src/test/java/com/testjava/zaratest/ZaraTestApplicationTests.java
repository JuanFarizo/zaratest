package com.testjava.zaratest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class ZaraTestApplicationTests {

	@Test
	void givenScopeWhenConstructThenDoNotThrowException() {
		assertDoesNotThrow(ZaraTestApplication::new);
	}

}
