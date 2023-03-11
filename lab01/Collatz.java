/** Class that prints the Collatz sequence starting from a given number.
 *  @author Albert Sun
 */
public class Collatz {

    /** Returns the nextNumber in a Collatz sequence. */
    public static int nextNumber(int n) {
        // TODO: Fill in this method.
        int nextnum;
        if (n % 2 == 0){
            nextnum = n / 2;
        }
        else{
            nextnum = 3 * n + 1;
        }
        return nextnum;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");

        // Some starter code to test
        while (n != 1) {          
            n = nextNumber(n);          
            System.out.print(n + " ");
        }
        System.out.println();

    }
}

