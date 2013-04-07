import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

/**
 * @author Steven Han
 * @version April 7, 2013
 * 
 */
public class StringSearchesTest {

	private static final String HAYSTACK_1 = "aaaaaabuttsaaabutts";
	private static final String NEEDLE_1 = "butts";
	private static final int[] RESULT_1 = new int[] {6,14};
	
	private static final String HAYSTACK_2 = "0123456789butts";
	private static final String NEEDLE_2 = "butts";
	private static final int[] RESULT_2 = new int[] {10};
	
	private static final String NEEDLE_3 = "abcdabcabe";
	private static final int[] RESULT_3 = new int[] {-1,0,0,0,0,1,2,3,1,2};
	
	private static final String HAYSTACK_4 = "abcdabcabcdabcfabcdabcabe";
	private static final String NEEDLE_4 = "abcdabcabe";
	private static final int[] RESULT_4 = new int[] {15};
	
	private static final String HAYSTACK_5 = "0123456789buts";
	private static final String NEEDLE_5 = "but";
	private static final int[] RESULT_5 = new int[] {10};
	
	private static final String HAYSTACK_6 = "1234567abccabc";
	private static final String NEEDLE_6 = "abc";
	private static final int[] RESULT_6 = new int[] {7,11};
	
	/*
	 * Boyer-Moore tests
	 */
	
	@Test (timeout = 1000)
	public void testBoyerMoore1() {
		assertEquals(Arrays.toString(RESULT_1), Arrays.toString(StringSearches.boyerMoore(NEEDLE_1, HAYSTACK_1)));
	}
	
	
	@Test (timeout = 1000)
	public void testBoyerMoore2() {
		assertEquals(Arrays.toString(RESULT_2), Arrays.toString(StringSearches.boyerMoore(NEEDLE_2, HAYSTACK_2)));
	}
	
	@Test (timeout = 1000)
	public void testBoyerMoore3() {
		assertEquals(Arrays.toString(RESULT_4), Arrays.toString(StringSearches.boyerMoore(NEEDLE_4, HAYSTACK_4)));
	}
	
	@Test (timeout = 1000)
	public void testBoyerMoore4() {
		assertEquals(Arrays.toString(RESULT_5), Arrays.toString(StringSearches.boyerMoore(NEEDLE_5, HAYSTACK_5)));
	}
	
	
	@Test (timeout = 1000)
	public void testBoyerMoore5() {
		assertEquals(Arrays.toString(RESULT_6), Arrays.toString(StringSearches.boyerMoore(NEEDLE_6, HAYSTACK_6)));
	}
	
	
	/*
	 * KMP Tests
	 */
	
	@Test (timeout = 1000)
	public void testPrefixTable1() {
		assertEquals(Arrays.toString(RESULT_3),Arrays.toString(StringSearches.buildTable(NEEDLE_3)));
	}
	
	@Test (timeout = 1000)
	public void testKMP1() {
		assertEquals(Arrays.toString(RESULT_1), Arrays.toString(StringSearches.kmp(NEEDLE_1, HAYSTACK_1)));
	}
	
	@Test (timeout = 1000)
	public void testKMP2() {
		assertEquals(Arrays.toString(RESULT_2), Arrays.toString(StringSearches.kmp(NEEDLE_2, HAYSTACK_2)));
	}
	
	@Test (timeout = 1000)
	public void testKMP3() {
		assertEquals(Arrays.toString(RESULT_4), Arrays.toString(StringSearches.kmp(NEEDLE_4, HAYSTACK_4)));
	}
	
	@Test (timeout = 1000)
	public void testKMP4() {
		assertEquals(Arrays.toString(RESULT_5), Arrays.toString(StringSearches.kmp(NEEDLE_5, HAYSTACK_5)));
	}
	
	@Test (timeout = 1000)
	public void testKMP5() {
		assertEquals(Arrays.toString(RESULT_6), Arrays.toString(StringSearches.kmp(NEEDLE_6, HAYSTACK_6)));
	}
	
	/*
	 * Robin-Karp tests
	 */
	
	@Test (timeout = 1000)
	public void testHash1() {
		int hash = StringSearches.hash("abc");
		assertEquals(StringSearches.hash("bcd"),StringSearches.updateHash(hash, 
				StringSearches.BASE * StringSearches.BASE * StringSearches.BASE,
				'd', 'a'));
	}
	
	@Test (timeout = 1000)
	public void testHash2() {
		int hash = StringSearches.hash("xdefg");

		assertEquals(StringSearches.hash("defgi"),StringSearches.updateHash(hash, 
				StringSearches.BASE * StringSearches.BASE * StringSearches.BASE * StringSearches.BASE * StringSearches.BASE,
				'i', 'x'));

	}
	
	@Test (timeout = 1000)
	public void testRabinKarp1() {
		assertEquals(Arrays.toString(RESULT_1), Arrays.toString(StringSearches.rabinKarp(NEEDLE_1, HAYSTACK_1)));
	}
	
	
	@Test (timeout = 1000)
	public void testRabinKarp2() {
		assertEquals(Arrays.toString(RESULT_2), Arrays.toString(StringSearches.rabinKarp(NEEDLE_2, HAYSTACK_2)));
	}
	
	
	@Test (timeout = 1000)
	public void testRabinKarp3() {
		assertEquals(Arrays.toString(RESULT_5), Arrays.toString(StringSearches.rabinKarp(NEEDLE_5, HAYSTACK_5)));
	}
	
	
	@Test (timeout = 1000)
	public void testRabinKarp4() {
		assertEquals(Arrays.toString(RESULT_6), Arrays.toString(StringSearches.rabinKarp(NEEDLE_6, HAYSTACK_6)));
	}
	
	
}