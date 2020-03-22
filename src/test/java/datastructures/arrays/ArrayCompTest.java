package datastructures.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayCompTest {

	@Test
	void testMaxProfit() {
		int price1[] = {10, 20, 30};
		int price2[] = {1,5,3,8,12};
		int expected1 = 20;
		int expected2 = 13;
		assertEquals(expected1,ArrayComp.maxProfit(price1));
		assertEquals(expected2,ArrayComp.maxProfit(price2));
	}

	@Test
	void testMaxProfit1() {
		int price1[] = {10, 20, 30};
		int price2[] = {1,5,3,8,12};
		int expected1 = 20;
		int expected2 = 13;
		assertEquals(expected1,ArrayComp.maxProfit1(price1));
		assertEquals(expected2,ArrayComp.maxProfit1(price2));
	}

}
