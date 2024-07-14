package com.test;

import org.apache.commons.lang3.StringUtils;

import com.acme_semi.test.AcmeSemiSystemTest;
import com.uberchip.test.UberChipSystemTest;

public class CompareSystemsTest {

    public static void main(String[] args) {
        System.out.println("---------------------------- Acme_Semi System Test -----------------------------------");
        String acmeSemiOutput = AcmeSemiSystemTest.systemTest();

        System.out.println("\n\n---------------------------- UberChip System Test -----------------------------------");
        String uberChipOutput = UberChipSystemTest.systemTest();

        System.out.println("\n-------------------------------------------------------------------------------------");
        System.out.println("                  Acme_Semi vs. UberChip Test Comparison Results");
        System.out.println("-------------------------------------------------------------------------------------");
        // remove company specific output before comparison
        acmeSemiOutput = acmeSemiOutput.replaceAll("Acme_Semi", "");
        uberChipOutput = uberChipOutput.replaceAll("UberChip", "");
        if (uberChipOutput.equals(acmeSemiOutput)) {
            System.out.println("Acme_Semi and UberChip outputs have exact match!");
        } else {
            String stringDifference = stringDifference(acmeSemiOutput, uberChipOutput);
            System.out.println("UberChip differs from Acme_Semi at: " + stringDifference);
        }
    }

    private static String stringDifference(String str1, String str2) {
        int differenceIndex = StringUtils.indexOfDifference(str1, str2);
        String stringDifference = str2.substring(differenceIndex);
        if (stringDifference.length() > 50) {
            stringDifference = stringDifference.substring(0, 50) + "...";
        }
        return stringDifference;
    }
}
