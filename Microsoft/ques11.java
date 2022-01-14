import java.util.*;

public class ques11 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            ArrayList<String> res = new ArrayList<String>();

            res = new solve().generate(n);

            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}

class solve {

    static ArrayList<String> generate(int n) {
        ArrayList<String> res = new ArrayList<>();
        Queue<String> q = new ArrayDeque<>();
        q.add("1");
        int count = 0;

        while (q.size() > 0) {
            String rem = q.remove();
            res.add(rem);
            count++;
            if (count == n)
                return res;
            q.add(rem + "0");
            q.add(rem + "1");
        }
        return res;
    }

}
