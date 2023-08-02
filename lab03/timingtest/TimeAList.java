package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<>();
        int double_num  = 1000;
        for (int i = 0; i < 10; i++){
            Ns.addLast((double_num));
            double_num *= 2;
        }
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        for (int num = 0; num < Ns.size(); num++) {
            opCounts.addLast(Ns.get(num));
            AList<Integer> test = new AList<>();
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < opCounts.get(num); i++ ){
                test.addLast(i);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
