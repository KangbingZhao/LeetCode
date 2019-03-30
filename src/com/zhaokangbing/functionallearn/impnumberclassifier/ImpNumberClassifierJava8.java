package com.zhaokangbing.functionallearn.impnumberclassifier;

import java.util.stream.IntStream;

/**
 * Java8实现的完全函数式版本，完美数解法
 */
public class ImpNumberClassifierJava8 {
     public static IntStream factorOf(int number) {
         return IntStream.range(1,number+1)
                 .filter(potential -> number % potential == 0);
     }
     public static int aliquotSum(int number) {
         return factorOf(number).sum() - number;
     }
    public static boolean isPerfect(final int number) {
        return aliquotSum(number) == number;
    }
    public static boolean isAbundant(final int number) {
        return aliquotSum(number) > number;
    }
    public static boolean isDeficient(final int number) {
        return aliquotSum(number) < number;
    }
}
