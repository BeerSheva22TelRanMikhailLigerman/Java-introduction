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
	@Disabled
	void isAnagramTest() {
		assertTrue(Strings.isAnagram("qweasd", "asdqwe"));
		assertTrue(Strings.isAnagram("qqqwww", "wwwqqq"));
		assertTrue(Strings.isAnagram("qw", "wq"));
		assertTrue(Strings.isAnagram("qwqqq", "wqqqq"));
		assertFalse(Strings.isAnagram("wwee", "wwqq"));
		assertFalse(Strings.isAnagram("qwe", "qwe"));
		assertFalse(Strings.isAnagram("q", "q"));
		assertFalse(Strings.isAnagram("qwe", "qw"));
		assertFalse(Strings.isAnagram("qwe", "qww"));
	}
	
	@Test
	@Disabled
	void sortStringNumbersTest() {
		String[] array1 = { "5", "-37", "15", "2", "22", "120", "118", "-110", "5", "2", "1", "0", "127", "-128", "-128", "1", "5" };
		Strings.sortStringNumbers(array1);
		assertArrayEquals(new String[] { "-128", "-128", "-110", "-37", "0", "1", "1", "2", "2", "5", "5", "5", "15", "22", "118", "120", "127" }, array1);
	}
	
	@Test
	@Disabled
	void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));
	}
	
	@Test
	
	void ipV4OctetTest() {
		assertTrue("0".matches(Strings.ipV4Octet()));
		assertTrue("1".matches(Strings.ipV4Octet()));
		assertTrue("00".matches(Strings.ipV4Octet()));
		assertTrue("99".matches(Strings.ipV4Octet()));
		assertTrue("199".matches(Strings.ipV4Octet()));
		assertTrue("249".matches(Strings.ipV4Octet()));
		assertTrue("255".matches(Strings.ipV4Octet()));
		assertFalse(" ".matches(Strings.ipV4Octet()));
		assertFalse("256".matches(Strings.ipV4Octet()));
		assertFalse("311".matches(Strings.ipV4Octet()));
		assertFalse("1O0".matches(Strings.ipV4Octet()));
	}
	
	@Test
	
	void ipV4Test() {
		assertTrue("0.0.0.0".matches(Strings.ipV4()));
		assertTrue("192.168.0.1".matches(Strings.ipV4()));
		assertTrue("255.255.255.255".matches(Strings.ipV4()));
		assertFalse("0.0.0.256".matches(Strings.ipV4()));
		assertFalse("0.0.0,0".matches(Strings.ipV4()));
		assertFalse("0.0.0.O".matches(Strings.ipV4()));
		assertFalse("0.0.0.0.".matches(Strings.ipV4()));
	}
		
	
	

}