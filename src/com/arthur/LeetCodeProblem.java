package com.arthur;

/**
 * Created by artcslee on 7/28/16.
 */
public abstract class LeetCodeProblem {
    public void runProblem(String[] args) {
        solution(setupProblem(args));
    }

    public abstract Object setupProblem(String[] args);
    public abstract void solution(Object arg);
}
