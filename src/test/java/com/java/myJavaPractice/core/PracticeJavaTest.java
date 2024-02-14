package com.java.myJavaPractice.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class PracticeJavaTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    public void testProduct() {

        int[] inputArray = {1, 2, 3, 4, 6};

        int[] result = new int[inputArray.length];
        int temp = 1;

        // Product of elements on left side excluding arr[i]
        for (int i = 0; i < inputArray.length; i++) {
            result[i] = temp;
            temp *= inputArray[i];
//            System.out.println("Temp " + temp);
        }

        temp = 1;

        // Product of elements on right side excluding arr[i]
        for (int i = inputArray.length - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= inputArray[i];
        }

        System.out.println("result " + Arrays.toString(result));
    }

    @Test
    public void testPalindrome() {
        StringBuilder rev = new StringBuilder();
        String inputString = "bebeb";

        for (int i = inputString.length() - 1; i >= 0; i--) {
            System.out.printf("%s", inputString.charAt(i));
            rev.append(inputString.charAt(i));
        }

        boolean isPalindrome = inputString.contentEquals(rev);

        assertThat(isPalindrome).isTrue();
    }

    @Test
    void testGreaterValueInArray() {
        int[] inputArray = generateRandomIntArray(30);
        int[] resultArray = new int[inputArray.length];
        System.out.println("inputArray " + Arrays.toString(inputArray));

        int resultCounter = 0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i + 1] < inputArray[i]) {
//                System.out.printf("%-10d is greater %-10d\n", inputArray[i + 1], inputArray[i]);
                resultArray[resultCounter++] = inputArray[i];
            }
        }
        int[] finalArray = Arrays.stream(resultArray).filter(num -> num != 0).toArray();
        System.out.println("finalArray " + Arrays.toString(finalArray));
    }

    @Test
    void testRemoveEvenNumbers() {
        int[] inputArray = generateRandomIntArray(12);
        int[] resultArray = new int[inputArray.length];

        System.out.println("inputArray " + Arrays.toString(inputArray));
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] % 2 != 0)
                resultArray[i] = inputArray[i];
        }

        int[] finalArray = Arrays.stream(resultArray).filter(num -> num != 0).toArray();
        System.out.println("finalArray " + Arrays.toString(finalArray));
    }

    private int[] generateRandomIntArray(final int randomSize) {
        int[] inputArray = new Random().ints(randomSize, 0, 100).toArray();
        assertThat(inputArray).isNotEmpty();

        return inputArray;
    }
}
