import java.util.*;

class Job {
    int deadline, profit;
    Job(int d, int p) {
        deadline = d;
        profit = p;
    }
}

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];
        
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        
        int maxDeadline = Arrays.stream(deadline).max().getAsInt();
        boolean[] slots = new boolean[maxDeadline + 1];
        int count = 0, totalProfit = 0;
        
        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    count++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(count);
        result.add(totalProfit);
        return result;
    }
}
