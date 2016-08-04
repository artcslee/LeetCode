package com.arthur.problems;

import com.arthur.LeetCodeProblem;
import com.arthur.utils.SortUtil;

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
        for (int x=0; x<coins.size(); x++) {
            System.out.print(coins.get(x));
            if (x < coins.size()-1) {
                System.out.print(", ");
            } else {
                System.out.println("]");
            }
        }

        //Solve Problem
        int totalCoinNum = getLeastCoinNum(coins, amount, Integer.MAX_VALUE);
        System.out.println("Total Num Of Coins: [" + totalCoinNum + "]");
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
