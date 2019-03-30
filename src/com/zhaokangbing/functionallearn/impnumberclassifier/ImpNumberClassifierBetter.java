package com.zhaokangbing.functionallearn.impnumberclassifier;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 向函数式靠拢的完美数解法：
 *   1. 去除内部变量，通过参数传递
 *   2. 函数级重用
 *   3. 没有缓存，效率降低
 */
public class ImpNumberClassifierBetter {
    public static boolean isFactor(final int candidate, final int number) {
        return number % candidate == 0;
    }
    public static Set<Integer> factors(final int number) {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(number);
        for (int i=0;i<number;i++) {
            if (isFactor(i,number)) {
                factors.add(i);
            }
        }
        return factors;
    }
    public static int aliquotSum(final Collection<Integer> factors) {
        int sum = 0;
        int targetNum = Collections.max(factors);
        for (int n:factors) {
            sum+=n;
        }
        return sum - targetNum;
    }
    public static boolean isPerfect(final int number) {
        return aliquotSum(factors(number)) == number;
    }
    public static boolean isAbundant(final int number) {
        return aliquotSum(factors(number)) > number;
    }
    public static boolean isDeficient(final int number) {
        return aliquotSum(factors(number)) < number;
    }

}
