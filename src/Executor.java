import com.arthur.LeetCodeProblem;
import com.arthur.problems.*;
import com.arthur.utils.PrintUtil;
import com.arthur.utils.SortUtil;

import java.util.ArrayList;

/**
 * Created by artcslee on 7/28/16.
 */
public class Executor {
    public static void main(String[] args) {
        /*
        LeetCodeProblem leetCodeProblem = new SummaryRanges();
        leetCodeProblem.runProblem(args);
        */
        ArrayList<Comparable> unsortedList = new ArrayList<>();
        unsortedList.add(9);
        unsortedList.add(1);
        unsortedList.add(8);
        unsortedList.add(3);
        unsortedList.add(1);
        unsortedList.add(2);
        unsortedList.add(1);
        unsortedList.add(5);

        SortUtil.quickSort(unsortedList);
    }
}
