package com.arthur.problems;

import com.arthur.LeetCodeProblem;
import com.arthur.utils.Sort;

import java.util.*;

/**
 * Created by artcslee on 7/28/16.
 */
public class CoinChange extends LeetCodeProblem {

    @Override
    public Object setupProblem(String[] args) {
        ArrayList<Comparable> newArgs = new ArrayList<>();
        newArgs.add(Integer.valueOf(args[0]));

        ArrayList<Comparable> coins = new ArrayList<>();
        for (int x=1; x<args.length; x++) {
            coins.add(Integer.valueOf(args[x]));
        }
        newArgs.addAll(Sort.sortDescending(coins));
        return newArgs;
    }

    @Override
    public void solution(Object arg) {
        //Setup Problem
        List<Integer> args = (List<Integer>) arg;
        int target = args.get(0);
        List<Integer> coins = args.subList(1, args.size());

        //Print Problem
        System.out.print("Target: [" + target + "], Coins: [");
        for (int x=0; x<coins.size(); x++) {
            System.out.print(coins.get(x));
            if (x < coins.size()-1) {
                System.out.print(", ");
            } else {
                System.out.println("]");
            }
        }

        //Solve Problem
        HashMap<Integer, Integer> smallestSet = getSmallestSet(coins, target);
        int totalCoinNum = 0;
        if (smallestSet == null) {
            totalCoinNum = -1;
        } else {
            totalCoinNum = getNumOfCoins(smallestSet, true);
        }
        System.out.println("Total Num Of Coins: [" + totalCoinNum + "]");
    }

    public HashMap<Integer, Integer> getSmallestSet(List<Integer> coins, int target) {
        int coin = coins.get(0);
        HashMap <Integer, Integer> smallestSet = null;
        if(coins.size() == 1) {
            if(target % coin == 0) {
                smallestSet = new HashMap<>();
                int numOfLastCoin = target/coin;
                smallestSet.put(coin, numOfLastCoin);
            }
            return smallestSet;
        }

        int currNum = 0;
        while (currNum * coin <= target) {
            HashMap<Integer, Integer> othersSet = getSmallestSet(coins.subList(1, coins.size()), target - (currNum * coin));
            if (othersSet != null) {
                if (smallestSet == null) {
                    smallestSet = new HashMap<>();
                }

                int numOfCoins = currNum + getNumOfCoins(othersSet, false);
                int currSmallestNum = getNumOfCoins(smallestSet, false);
                if (smallestSet.isEmpty() || numOfCoins < currSmallestNum) {
                    smallestSet.put(coin, currNum);
                    smallestSet.putAll(othersSet);
                }
            }
            currNum++;
        }

        return smallestSet;
    }

    private int getNumOfCoins(HashMap<Integer, Integer> coinSet, boolean debug) {
        int totalNum = 0;
        Iterator<Integer> coinSetIterator = coinSet.keySet().iterator();
        while (coinSetIterator.hasNext()) {
            int coin = coinSetIterator.next();
            totalNum += coinSet.get(coin);
            if (debug) {
                System.out.println("[" + coin + "]: [" + coinSet.get(coin) + "]");
            }
        }
        return totalNum;
    }
}
