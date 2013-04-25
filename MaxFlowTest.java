import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import org.junit.Test;

/**
 * @author Steven Han
 * @version Mar 30, 2013
 */
public class MaxFlowTest {

	public static final int[][] CAPACITIES_1 = new int[][]
			{{0,2,7,0,0,0},
			{0,0,0,6,3,0},
			{0,0,0,6,0,0},
			{0,0,0,0,0,8},
			{0,0,0,0,0,9},
			{0,0,0,0,0,0}};

	public static final int START_1 = 0;
	public static final int END_1 = 5;
	public static final int MAX_1 = 8;

	public static final int[][] CAPACITIES_2 = new int[][]
			{{0,3,2,9,0,0,0,0},
			{0,0,8,0,0,0,0,7},
			{0,0,0,0,5,0,0,0},
			{0,0,0,0,0,0,0,6},
			{0,0,0,0,0,4,0,0},
			{0,0,0,0,0,0,7,6},
			{0,0,0,0,0,0,0,8},
			{0,0,0,0,0,0,0,0}};

	public static final int START_2 = 0;
	public static final int END_2 = 7;
	public static final int MAX_2 = 11;

	public static final int[][] CAPACITIES_3 = new int[][]
			{{0,10,10,0},
			{0,0,0,5},
			{0,0,0,10},
			{0,0,0,0}};
	
	public static final int START_3 = 0;
	public static final int END_3 = 3;
	public static final int MAX_3 = 15;
	

	public static final int[][] CAPACITIES_4 = new int[][]
			{{0,5,0,0,0,3,0},
			{0,0,5,0,0,0,0},
			{0,0,0,5,0,0,0},
			{0,0,0,0,5,0,0},
			{0,5,0,0,0,0,0},
			{0,0,0,0,0,0,3},
			{0,0,0,0,0,0,0}};
	
	public static final int START_4 = 0;
	public static final int END_4 = 6;
	public static final int MAX_4 = 3;
	
	
	public static final int[][] CAPACITIES_5 = new int[][]
			{{0,10,10,0},
			{0,0,5,0},
			{0,0,0,10},
			{0,0,0,0}};
	
	public static final int START_5 = 1;
	public static final int END_5 = 2;
	public static final int MAX_5 = 5;
	

	public static final int[][] CAPACITIES_6 = new int[][]
			{{0,5,0,0,10},
			{0,0,5,0,0},
			{0,0,0,5,0},
			{0,5,0,0,0},
			{0,0,0,0,0}};
	
	public static final int START_6 = 0;
	public static final int END_6 = 4;
	public static final int MAX_6 = 10;
	
	
	
	@Test
	public void testMaxFlow1() {
		assertEquals(MAX_1, MaxFlow.flow(CAPACITIES_1.length, START_1, END_1, CAPACITIES_1));
	}

	@Test
	public void testMaxFlow2() {
		assertEquals(MAX_2, MaxFlow.flow(CAPACITIES_2.length, START_2, END_2, CAPACITIES_2));
	}

	@Test
	public void testMaxFlow3() {
		assertEquals(MAX_3, MaxFlow.flow(CAPACITIES_3.length, START_3, END_3, CAPACITIES_3));
	}

	@Test
	public void testMaxFlow4() {
		assertEquals(MAX_4, MaxFlow.flow(CAPACITIES_4.length, START_4, END_4, CAPACITIES_4));
	}
	
	@Test
	public void testMaxFlow5() {
		assertEquals(MAX_5, MaxFlow.flow(CAPACITIES_5.length, START_5, END_5, CAPACITIES_5));
	}

	@Test
	public void testMaxFlow6() {
		assertEquals(MAX_6, MaxFlow.flow(CAPACITIES_6.length, START_6, END_6, CAPACITIES_6));
	}
}
