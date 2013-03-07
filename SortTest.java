import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

/**
 * @author Steven Han
 * @version March 6, 2013
 * 
 * Things left untested:
 *  - Stability of Radix sort
 */
public class SortTest {

	private static final String SORTED_MAKE_INT_ARRAY = "[-1, 0, 1, 2, 2, 4, 5, 9, 11]";
	private static final String STABLE_SORTED_STEVEN_ARRAY = "[-11(-11), -11(0), -7(-7), -2(-2), 0(0), 1(1), 1(0), 5(5), 8(8), 10(10)]";
	private static final String SORTED_SIMPLE_INT_ARRAY = "[1, 2, 3, 4, 5, 6, 7, 8, 9]";
	
	/*
	 * Bubble Sort tests
	 */
	
	@Test (timeout = 1000)
	public void simpleTestBubbleSort() {
		Integer[] arr = makeSimpleIntArray();
		Sort.bubblesort(arr);
		assertEquals(SORTED_SIMPLE_INT_ARRAY, Arrays.toString(arr));
	}
	
	@Test (timeout = 1000)
	public void testBubbleSort() {
		Integer[] arr = makeIntArray();
		Sort.bubblesort(arr);
		assertEquals(SORTED_MAKE_INT_ARRAY, Arrays.toString(arr));
	}
	
	@Test (timeout = 1000)
	public void testStableBubbleSort() {
		StevenInteger[] arr = makeStevenIntArray();
		Sort.bubblesort(arr);
		assertEquals(STABLE_SORTED_STEVEN_ARRAY, Arrays.toString(arr));
	}
	
	@Test (timeout = 1000)
	public void testStableBubbleSortBash() {
		StevenInteger[] arr = createGodAwfulStevenIntArray();
		System.out.println();
		Arrays.sort(arr);
		assertEquals(Arrays.toString(arr), Arrays.toString(arr));
	}
	
	/*
	 * Insertion Sort tests
	 */
	
	@Test (timeout = 1000)
	public void simpleTestInsertionSort() {
		Integer[] arr = makeSimpleIntArray();
		Sort.insertionsort(arr);
		assertEquals(SORTED_SIMPLE_INT_ARRAY, Arrays.toString(arr));
	}
	
	@Test (timeout = 1000)
	public void testInsertionSort() {
		Integer[] arr = makeIntArray();
		Sort.insertionsort(arr);
		assertEquals(SORTED_MAKE_INT_ARRAY, Arrays.toString(arr));
	}
	
	@Test (timeout = 1000)
	public void testStableInsertionSort() {
		StevenInteger[] arr = makeStevenIntArray();
		Sort.insertionsort(arr);
		assertEquals(STABLE_SORTED_STEVEN_ARRAY, Arrays.toString(arr));
	}
	
	@Test (timeout = 5000)
	public void testInsertionSortStableBash() {
		StevenInteger[] arr = createGodAwfulStevenIntArray();
		StevenInteger[] sorted = new StevenInteger[arr.length];
		for (int i = 0; i < arr.length; i++)
			sorted[i] = arr[i];
		Arrays.sort(sorted);
		
		Sort.insertionsort(arr);
		assertEquals(Arrays.toString(sorted), Arrays.toString(arr));
	}
	
	/*
	 * Quick Sort tests
	 */
	
	@Test (timeout = 1000)
	public void simpleTestQuickSort() {
		Integer[] arr = makeSimpleIntArray();
		Random r = new Random();
		Sort.quicksort(arr, r);
		assertEquals(SORTED_SIMPLE_INT_ARRAY, Arrays.toString(arr));
	}
	
	@Test (timeout = 1000)
	public void testQuickSort() {
		Integer[] arr = makeIntArray();
		Random r = new Random();
		Sort.quicksort(arr, r);
		assertEquals(SORTED_MAKE_INT_ARRAY, Arrays.toString(arr));
	}
	
	@Test (timeout = 5000)
	public void testQuickSortBash() {
		Integer[] arr = createGodAwfulArray();
		Integer[] sorted = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++)
			sorted[i] = arr[i];
		Arrays.sort(sorted);
		
		Random r = new Random();
		Sort.quicksort(arr, r);
		assertEquals(Arrays.toString(sorted), Arrays.toString(arr));
	}
	
	/*
	 * Merge Sort tests
	 */
	
	@Test (timeout = 1000)
	public void simpleTestMergeSort() {
		Integer[] arr = makeSimpleIntArray();
		arr = (Integer[]) Sort.mergesort(arr);
		assertEquals(SORTED_SIMPLE_INT_ARRAY, Arrays.toString(arr));
	}
	
	@Test (timeout = 1000)
	public void testStableMergeSort() {
		StevenInteger[] arr = makeStevenIntArray();
		arr = Sort.mergesort(arr);
		assertEquals(STABLE_SORTED_STEVEN_ARRAY, Arrays.toString(arr));
	}
	
	@Test (timeout = 5000)
	public void testMergeSortBash() {
		Integer[] arr = createGodAwfulArray();
		Integer[] sorted = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++)
			sorted[i] = arr[i];
		Arrays.sort(sorted);
		
		arr = Sort.mergesort(arr);
		assertEquals(Arrays.toString(sorted), Arrays.toString(arr));
	}
	
	@Test (timeout = 5000)
	public void testMergeSortStableBash() {
		StevenInteger[] arr = createGodAwfulStevenIntArray();
		StevenInteger[] sorted = new StevenInteger[arr.length];
		for (int i = 0; i < arr.length; i++)
			sorted[i] = arr[i];
		Arrays.sort(sorted);
		
		arr = Sort.mergesort(arr);
		assertEquals(Arrays.toString(sorted), Arrays.toString(arr));
	}
	
	/*
	 * Radix Sort tests
	 */
	
	@Test (timeout = 1000)
	public void testRadixSort() {
		int[] arr = makePrimIntArray();
		arr = (int[]) Sort.radixsort((int[]) arr);
		assertEquals(SORTED_MAKE_INT_ARRAY, Arrays.toString(arr));
	}

	@Test (timeout = 5000)
	public void testRadixSortBash() {
		int[] arr = createGodAwfulPrimArray();
		int[] sorted = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			sorted[i] = arr[i];
		Arrays.sort(sorted);
		
		arr = Sort.radixsort(arr);
		assertEquals(Arrays.toString(sorted), Arrays.toString(arr));
	}
	
	/*
	 * Edge cases
	 */
	
	@Test
	public void testSingleElement(){
		Integer[] arrI = new Integer[] {1};
		Sort.bubblesort(arrI);
		assertEquals("[1]", Arrays.toString(arrI));
		Sort.insertionsort(arrI);
		assertEquals("[1]", Arrays.toString(arrI));
		
		Random r = new Random();
		Sort.quicksort(arrI, r);
		assertEquals("[1]", Arrays.toString(arrI));
		
		arrI = Sort.mergesort(arrI);
		assertEquals("[1]", Arrays.toString(arrI));
		
		int arr[] = new int[] {1};
		arr = Sort.radixsort(arr);
		assertEquals("[1]", Arrays.toString(arr));
	}
	
	@Test
	public void testAllRepeats(){
		Integer[] arrI = new Integer[] {1, 1, 1, 1, 1, 1, 1};
		Sort.bubblesort(arrI);
		assertEquals("[1, 1, 1, 1, 1, 1, 1]", Arrays.toString(arrI));
		Sort.insertionsort(arrI);
		assertEquals("[1, 1, 1, 1, 1, 1, 1]", Arrays.toString(arrI));
		
		Random r = new Random();
		Sort.quicksort(arrI, r);
		assertEquals("[1, 1, 1, 1, 1, 1, 1]", Arrays.toString(arrI));
		
		arrI = Sort.mergesort(arrI);
		assertEquals("[1, 1, 1, 1, 1, 1, 1]", Arrays.toString(arrI));
		
		int arr[] = new int[] {1, 1, 1, 1, 1, 1, 1};
		arr = Sort.radixsort(arr);
		assertEquals("[1, 1, 1, 1, 1, 1, 1]", Arrays.toString(arr));
	}
	
	/*
	 * Utilities
	 */
	
	private Integer[] makeIntArray(){
		return new Integer[] {5, 4, 2, 9, 11, 2, 0, -1, 1};
	}
	
	private int[] makePrimIntArray(){
		return new int[] {5, 4, 2, 9, 11, 2, 0, -1, 1};
	}
	
	private Integer[] makeSimpleIntArray(){
		return new Integer[] {9, 7, 8, 6, 5, 3, 4, 1, 2};
	}
	
	private StevenInteger[] makeStevenIntArray(){
		StevenInteger[] toReturn = new StevenInteger[10];
		
		toReturn[0] = new StevenInteger(10,10);
		toReturn[1] = new StevenInteger(5,5);
		toReturn[2] = new StevenInteger(-7,-7);
		toReturn[3] = new StevenInteger(8,8);
		toReturn[4] = new StevenInteger(1,1);
		toReturn[5] = new StevenInteger(1,0);
		toReturn[6] = new StevenInteger(-2,-2);
		toReturn[7] = new StevenInteger(-11,-11);
		toReturn[8] = new StevenInteger(0,0);
		toReturn[9] = new StevenInteger(-11,0);
		
		return toReturn;
	}
	
	private Integer[] createGodAwfulArray(){
		Integer[] toReturn = new Integer[500];
		Random rand = new Random();
		for (int i = 0; i < 500; i++)
			toReturn[i] = rand.nextInt(250) - 500;
		return toReturn;
	}
	
	private int[] createGodAwfulPrimArray(){
		int[] toReturn = new int[500];
		Random rand = new Random();
		for (int i = 0; i < 500; i++)
			toReturn[i] = rand.nextInt(1000) - 500;
		return toReturn;
	}
	
	private StevenInteger[] createGodAwfulStevenIntArray(){
		StevenInteger[] toReturn = new StevenInteger[500];
		Random rand = new Random();
		for (int i = 0; i < 500; i++)
			toReturn[i] = new StevenInteger(rand.nextInt(500) - 250, rand.nextInt(120) - 60);
		return toReturn;
	}
	
	private class StevenInteger implements Comparable{
		private int key;
		private int number;
		
		public StevenInteger(int key, int number){
			this.key = key;
			this.number = number;
		}
		
		public int getKey(){return key;}
		public int getNumber(){return number;}
		
		@Override
		public int compareTo(Object o) {
			return key - ((StevenInteger) o).getKey();
		}
		
		public String toString(){
			return Integer.toString(key) + "(" + Integer.toString(number) + ")";
		}
	}
}