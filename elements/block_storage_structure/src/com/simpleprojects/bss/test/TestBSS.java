/**
 * Test Class which runs two different scenarios
 *
 * @author XXXXXXXXXXX
 * @version 1.0
 * @since 2021-02-8
 */

package com.simpleprojects.bss.test;
import com.simpleprojects.bss.CircularBSInterface;
import com.simpleprojects.bss.impl.CircularBS;

public class TestBSS {

    public static void main(String args[]) {

        //run the simple add and archive scenario
        normalTestCaseScenario();

        //run another scenario where storage reaches to max capacity
        //doubleStorageSizeTestCaseScenario();
    }

    public static void normalTestCaseScenario() {

        System.out.println("Test case scenario 1");

        CircularBSInterface cbs = new CircularBS(String.class);
        System.out.println(cbs);

        cbs.insert("B1");
        System.out.println(cbs);
        cbs.insert("B2");
        cbs.insert("B3");
        System.out.println(cbs);

        cbs.archive();
        cbs.archive();
        System.out.println(cbs);

        cbs.insert("B4");
        cbs.insert("B5");
        cbs.insert("B6");
        cbs.insert("B7");
        cbs.insert("B8");
        cbs.insert("B9");
        cbs.insert("B10");
        cbs.insert("B11");

        System.out.println(cbs);

        cbs.archive();
        cbs.archive();
        cbs.archive();
        cbs.archive();
        System.out.println(cbs);

        cbs.insert("B12");
        cbs.insert("B13");
        cbs.archive();
        cbs.insert("B14");
        cbs.insert("B15");
        cbs.insert("B16");
        System.out.println(cbs);

        cbs.archive();
        cbs.archive();
        cbs.archive();
        cbs.archive();
        cbs.archive();
        cbs.archive();
        cbs.archive();
        cbs.archive();
        cbs.archive();
        System.out.println(cbs);

    }

    public static void doubleStorageSizeTestCaseScenario() {

        System.out.println("Test case scenario - Double the Storage Scenario");

        CircularBSInterface cbs = new CircularBS(String.class);
        System.out.println(cbs);

        cbs.insert("B1");
        System.out.println(cbs);
        cbs.insert("B2");
        cbs.insert("B3");
        System.out.println(cbs);

        cbs.archive();
        cbs.archive();
        System.out.println(cbs);

        cbs.insert("B4");
        cbs.insert("B5");
        cbs.insert("B6");
        cbs.insert("B7");
        cbs.insert("B8");
        cbs.insert("B9");
        cbs.insert("B10");
        cbs.insert("B11");

        System.out.println(cbs);

        cbs.archive();
        cbs.archive();
        cbs.archive();
        cbs.archive();
        System.out.println(cbs);

        cbs.insert("B12");
        cbs.insert("B13");
        cbs.archive();
        cbs.insert("B14");
        cbs.insert("B15");
        cbs.insert("B16");
        System.out.println(cbs);
        cbs.insert("B17");
        cbs.insert("B18");
        System.out.println(cbs);

    }

}
