package telran.text;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.text.Strings.*;


public class StringsTest {
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
	@Disabled
	void ipV4OctetTest() {
		assertTrue("0".matches(Strings.ipV4Octet()));
		assertTrue("1".matches(Strings.ipV4Octet()));
		assertTrue("00".matches(Strings.ipV4Octet()));
		assertTrue("99".matches(Strings.ipV4Octet()));
		assertTrue("199".matches(Strings.ipV4Octet()));
		assertTrue("230".matches(Strings.ipV4Octet()));
		assertTrue("245".matches(Strings.ipV4Octet()));
		assertTrue("255".matches(Strings.ipV4Octet()));
		assertFalse(" ".matches(Strings.ipV4Octet()));
		assertFalse("256".matches(Strings.ipV4Octet()));
		assertFalse("311".matches(Strings.ipV4Octet()));
		assertFalse("1O0".matches(Strings.ipV4Octet()));
	}
	
	@Test
	@Disabled
	void ipV4Test() {
		assertTrue("0.0.0.0".matches(Strings.ipV4()));
		assertTrue("192.168.0.1".matches(Strings.ipV4()));
		assertTrue("255.255.255.255".matches(Strings.ipV4()));
		assertFalse("0.0.0.256".matches(Strings.ipV4()));
		assertFalse("0.0.0,0".matches(Strings.ipV4()));
		assertFalse("0.0.0.O".matches(Strings.ipV4()));
		assertFalse("0.0.0.0.".matches(Strings.ipV4()));
		assertFalse("".matches(Strings.ipV4()));
	}
	
	@Test
	
	void computeExpressionTest() {
		assertEquals(10.5, computeArithmenticExpression("2 + 2 + 1 * 2 + 0.5", null, null));
		assertEquals(10.5, computeArithmenticExpression("(2 + ((2 + 1) * 2) + 0.5)", null, null));
		assertEquals(10.5, computeArithmenticExpression("a + (2) + c * 2 + 0.5", new double[] {2, 1}, new String[] {"a", "c"}));
		
		assertTrue(Double.isNaN(computeArithmenticExpression("(2 + 2 + 1) * 2) + 0.5", null, null)));
		assertTrue(Double.isNaN(computeArithmenticExpression("(2 + 2 + 1( * 2) + 0.5))", null, null)));
		assertTrue(Double.isNaN(computeArithmenticExpression("2 # 2 + 10", null, null)));
		assertTrue(Double.isNaN(computeArithmenticExpression("a + (2) + b * 2 + 0.5", new double[] {2, 1}, new String[] {"a", "c"})));
	
	}
	
	

}
