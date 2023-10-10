package com.javajunit.junitbasic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
 import org.junit.jupiter.api.*;


class MathUtilTest 
{
	MathUtil mu;
	@BeforeEach   //executes before each run of test method
	void init() 
	{
		mu = new MathUtil();
		
	}
	@BeforeAll //it runs before all the test
	static void beforeAllinit()
	{
		System.out.println("this needs to run before all test methods");
	}
	@AfterAll  //this executes after all the test methods
		static void afterAlltest()
		{
			System.out.println("all the tests have executed succesfully");
		}
	@AfterEach  //it runs after every test method
	
		void cleanUp()
		{
			System.out.println("cleaning up.....!!!");
		}
	
	

	// @Test //
	void test()  //method to test add method
	 {
		// fail("Not yet implemented");
		// System.out.println("Test case is running");
		// MathUtil mu = new MathUtil();
		int expected = 4;
		int actual = mu.add(3, 1);
		// assertEquals compares the actual and expected values given from the method
		assertEquals(expected,actual);
		// System.out.println("add test is running");
	}
	
//	@Test //annotation to run that particular test method
	@DisplayName("This is area of circle")
	void testcircleArea() // method to test the areacircle
	{
		// MathUtil mu = new MathUtil();
		assertEquals(50.24,mu.areacircle(4),"should return areaofcircle");
		System.out.println("ara of circlue is running");

	}
	
	@Test
	@Disabled // skips the test
	
	void testsub()
	{
		// MathUtil mu = new MathUtil();
		int expected = 10;
		int actual = mu.sub(20, 1);
		// assertEquals compares the actual and expected values given from the method
		assertEquals(expected,actual);
		System.out.println("sub test is running");

		
	}

}
