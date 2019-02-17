package com.zhaokangbing.leetcode;

import java.util.*;

public class Q950 {


    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck==null||deck.length<=1) return deck;

        Arrays.sort(deck);
        LinkedList<Integer> index = new LinkedList<>();
        for (int i=0;i<deck.length;i++) {
            index.add(i);
        }
        int[] res = new int[deck.length];
        for (int i=0;i<deck.length;i++) {
            res[index.poll()] = deck[i];
            index.add(index.poll());
        }
        return res;




    }
}
