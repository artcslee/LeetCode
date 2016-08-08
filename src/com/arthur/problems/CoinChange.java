package com.arthur.problems;

import com.arthur.LeetCodeProblem;
import com.arthur.utils.SortUtil;

import java.util.*;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * \If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 *
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
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
        newArgs.addAll(SortUtil.sortDescending(coins));
        return newArgs;
    }

    @Override
    public void solution(Object arg) {
        //Setup Problem
        List<Integer> args = (List<Integer>) arg;
        int amount = args.get(0);
        List<Integer> coins = args.subList(1, args.size());

        //Print Problem
        System.out.print("Target: [" + amount + "], Coins: [");
        for (int x = 0; x < coins.size(); x++) {
            System.out.print(coins.get(x));
            if (x < coins.size() - 1) {
                System.out.print(", ");
            } else {
                System.out.println("]");
            }
        }

        //Solve Problem
        int totalCoinNum = getLeastCoinNum(coins, amount, Integer.MAX_VALUE);
        System.out.println("Total Num Of Coins: [" + totalCoinNum + "]");
    }

    public int coinChange(int[] coins, int amount) {
        return 0;
    }

    public int getLeastCoinNum(List<Integer> coins, int target, int leastNum) {
        if (coins == null || coins.size() < 1) {
            return -1;
        }

        int coin = coins.get(0);
        int leastCoinNum = -1;

        //base case
        if(coins.size() == 1) {
            if(target % coin == 0) {
                leastCoinNum = target/coin;
            }
            return leastCoinNum;
        }

        //recursive case
        int currNum = 0;
        while (currNum * coin <= target) {
            int leastSubsetCoinNum = getLeastCoinNum(coins.subList(1, coins.size()), target - (currNum * coin), leastCoinNum);
            int numOfCoins = currNum + leastSubsetCoinNum;
            if (leastSubsetCoinNum >= 0) {
                if (leastCoinNum < 0 || numOfCoins < leastCoinNum) {
                    leastCoinNum = numOfCoins;
                }
            }
            currNum++;
        }

        return leastCoinNum;
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
