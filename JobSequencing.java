import java.util.*;

class Job {
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    static void jobScheduling(Job jobs[], int n) {

        
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            if (jobs[i].deadline > maxDeadline)
                maxDeadline = jobs[i].deadline;
        }

        int[] slot = new int[maxDeadline];
        boolean[] filled = new boolean[maxDeadline];

        int totalProfit = 0;

        for (int i = 0; i < n; i++) {

            
            for (int j = Math.min(maxDeadline, jobs[i].deadline) - 1; j >= 0; j--) {
                if (!filled[j]) {
                    filled[j] = true;
                    slot[j] = jobs[i].id;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }

        System.out.print("Selected Jobs: ");
        for (int i = 0; i < maxDeadline; i++) {
            if (filled[i])
                System.out.print("J" + slot[i] + " ");
        }

        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        Job[] jobs = new Job[n];

        System.out.println("Enter Job details (id deadline profit):");
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }

        jobScheduling(jobs, n);
        sc.close();
    }
}

