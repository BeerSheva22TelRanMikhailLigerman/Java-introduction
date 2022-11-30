package telran.digital.numbers.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.digital.numbers.DigitalNumbersPrinting.*;

public class DigitalPrintingTest {
	@Test
	@Disabled
	void lineTest() {
		System.out.println(line(30, 30));
	}
	@Test
	@Disabled
	void verticalLineTest() {
		displayStrings(verticalLine(30, 6));
	}
	@Test
	@Disabled
	void twoVerticalLinesTest() {
		displayStrings(twoVerticalLines(30, 2, 5));
	}
	@Test
	@Disabled
	void zeroTest() {
		displayStrings(zero(10, 4, 4));
	}
	@Test
	@Disabled
	void oneTest() {
		displayStrings(one(3, 5, 4));
	}
	
	@Test
	
	void displayDigitalNumberTest() {
		String number = "0123456789";
		displayDigitalNumber(number, 5, 5, 7);
	}
	
	
}