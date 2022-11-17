import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ObjectTests {
	@Test
	@Disabled
	void wrapperTest() {
		
		Integer a = 11;
		
		Integer b = 11;
		assertEquals(a, b);
		Integer c = 201;
		Integer d = 201;
		assertEquals(c, d);
		assertTrue(a == b);
		assertFalse(c == d);
		assertTrue(c.equals(d));
	}
	@Test
	@Disabled
	void stringTest() {
		String hello = "hello";
		char[] helloAr = hello.toCharArray();
		assertEquals('h', helloAr[0]);
		System.out.println((byte)helloAr[0]);
		assertEquals(5, hello.length());
	}
	
	@Test
	void isAnagramTest( ) {
		assertTrue(Strings.isAnagram("qweasd", "asdqwe"));
		assertTrue(Strings.isAnagram("qqqwww", "wwwqqq"));
		assertTrue(Strings.isAnagram("qw", "wq"));
		assertTrue(Strings.isAnagram("qwqqq", "wqqqq"));
		assertFalse(Strings.isAnagram("qwe", "qwe"));
		assertFalse(Strings.isAnagram("q", "q"));
		assertFalse(Strings.isAnagram("qwe", "qw"));
		assertFalse(Strings.isAnagram("qwe", "qww"));
	}
	
	@Test
	void isAnagram2Test( ) {
		assertTrue(Strings.isAnagram("qweasd", "asdqwe"));
		assertTrue(Strings.isAnagram("qqqwww", "wwwqqq"));
		assertTrue(Strings.isAnagram("qw", "wq"));
		assertTrue(Strings.isAnagram("qwqqq", "wqqqq"));
		assertFalse(Strings.isAnagram("qwe", "qwe"));
		assertFalse(Strings.isAnagram("q", "q"));
		assertFalse(Strings.isAnagram("qwe", "qw"));
		assertFalse(Strings.isAnagram("qwe", "qww"));
		
	}
	

}