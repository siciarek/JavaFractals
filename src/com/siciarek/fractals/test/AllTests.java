package com.siciarek.fractals.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FractalFactoryNotSupportedTest.class, FractalFactoryTest.class,
		GenericFractalTest.class })
public class AllTests {

}
