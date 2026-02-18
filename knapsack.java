
import java.util.*;

public class knapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter bag weight");
        int m = sc.nextInt();
        System.out.println("enter total number weights ");
        int n = sc.nextInt();
        int p[] = new int[n];
        int w[] = new int[n];
        for (int i = 1; i <= n; i++) {
            System.out.println("enter" + i + "object weight");
            w[i] = sc.nextInt();
            System.out.println("enter" + i + "object profit");
            p[i] = sc.nextInt();
        }
        double rato[] = new double[n];
        int fw[] = new int[n];
        for (int i = 0; i < n; i++) {
            rato[i] = (double) p[i] / w[i];
        }
        Arrays.fill(fw, 0);
        double temp;
        int teemp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rato[i] > rato[j]) {
                    temp = rato[i];
                    rato[i] = rato[j];
                    rato[j] = temp;
                    teemp = p[i];
                    p[i] = p[j];
                    p[j] = teemp;
                    teemp = w[i];
                    w[i] = w[j];
                    w[j] = teemp;

                }
            }

        }

    }

}
