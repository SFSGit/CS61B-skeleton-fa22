package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        int M = 10000;
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        // 初始 Ns 数据
        int double_num  = 1000;
        for (int i = 0; i < 8; i++){
            Ns.addLast((double_num));
            double_num *= 2;
        }

        for (int num = 0; num < Ns.size(); num++) {
            SLList<Integer> test = new SLList<>();
            for (int i = 0; i < Ns.get(num); i++ ){
                test.addLast(i);
            }
            opCounts.addLast(M);
            Stopwatch sw = new Stopwatch();
            for (int i = 0;i < M; i++) {
                test.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns, times, opCounts);
    }

}
