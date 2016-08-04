package com.arthur.problems;

import com.arthur.LeetCodeProblem;
import com.arthur.utils.AdapterUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arthur on 8/3/2016.
 */
public class HIndex extends LeetCodeProblem {
    @Override
    public Object setupProblem(String[] args) {
        return AdapterUtil.stringArrayToIntegerList(args);
    }

    @Override
    public void solution(Object arg) {
        //Setup Problem
        int[] citations = AdapterUtil.listToArray((List<Integer>) arg);

        //Solve Problem

    }
}
