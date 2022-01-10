package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LotteryToolTests {
	
	static Rules defaultRules;
	ITool lotteryTool;
	
	@BeforeAll
	static void setUpAll() {
		defaultRules = new Rules(50, 7);
	}
	
	@BeforeEach
	void setUpEach() {
		lotteryTool = new LotteryTool();
	}
	
	@Test
	void ruleAndResultAmountsMatch() {
		lotteryTool.startToolService(defaultRules);
		assertEquals(defaultRules.getAmount(), lotteryTool.returnResults().size());
	}
	
	@Test
	void returnedResultsAreSorted() {
		lotteryTool.startToolService(defaultRules);
		List<String> sortedList = lotteryTool.returnResults();
		System.out.println("Sorted list: " + sortedList);
		//Check with recursion, Implementation from https://www.baeldung.com/java-check-if-list-sorted
		assertTrue(isSorted(sortedList));
	}
	
	@Test
	void resultssAreUnique() {
		Rules uniqueRules = new Rules(10, 10);
		
		Set<String> uniqueList = new HashSet<>(uniqueRules.getAmount() + 1);
		lotteryTool.startToolService(uniqueRules);
		List<String> sortedList = lotteryTool.returnResults();
		System.out.println("Unique list: " + sortedList);
		for (String item: sortedList) {
			uniqueList.add(item);
		}
		//Set only takes unique numbers, size is expected to be the same if all added values are unique.
		assertEquals(uniqueRules.getAmount(), uniqueList.size());
	}
	
	@Test
	void resultsDontContainBorderValues() {
		int rounds = 100;
		List<String> combinedList = new ArrayList<>();
		for (int i = 0; i < rounds; i++) {
			lotteryTool.startToolService(defaultRules);
			List<String> sortedList = lotteryTool.returnResults();
			for (String item: sortedList) {
				combinedList.add(item);
			}
		}
		assertTrue(doesNotContainBorderValues(combinedList));
	}
	
	//----------------Helper methods-----------------//
	
	private static boolean isSorted(List<String> listOfStrings) {
	    return isSorted(listOfStrings, listOfStrings.size());
	}

	private static boolean isSorted(List<String> listOfStrings, int index) {
	    if (index < 2) {
	        return true;
	    } else if ( Integer.parseInt(listOfStrings.get(index - 2)) > Integer.parseInt(listOfStrings.get(index - 1)) ) {
	        return false;
	    } else {
	        return isSorted(listOfStrings, index - 1);
	    }
	}
	
	private static boolean doesNotContainBorderValues(List<String> items) {
		if (items.contains("51")) {
			return false;
		} else if (items.contains("0")) {
			return false;
		} else {
			return true;
		}
	}

}
