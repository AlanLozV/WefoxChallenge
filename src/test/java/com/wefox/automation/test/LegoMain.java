package com.wefox.automation.test;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class LegoMain {

    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testSuite = new TestNG();
        testSuite.setTestClasses(new Class[] {LegoTest.class});
        testSuite.addListener(tla);
        testSuite.run();
    }
}
