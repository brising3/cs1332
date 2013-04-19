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
			{0,0,0,0,0,0}
			};
	public static final int START_1 = 0;
	public static final int END_1 = 5;
	public static final int MAX_1 = 8;

	@Test (timeout = 1000)
	public void testMaxFlow1() {
		assertEquals(MAX_1, MaxFlow.flow(CAPACITIES_1.length, START_1, END_1, CAPACITIES_1));
	}
}