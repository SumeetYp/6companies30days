import java.util.*;

public class ques11{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        double[] arr = new double[n];

        for(int i: arr){
            arr[i] = scn.nextDouble();
        }

        double radius = scn.nextDouble();
        double x_center = scn.nextDouble();
        double y_center = scn.nextDouble();

        Solution obj = new Solution(radius, x_center, y_center);
        double[] param_1 = obj.randPoint();
    }
}

class Solution {
    private double x, y, r;
    private ThreadLocalRandom rand;
    
    public Solution(double radius, double x_center, double y_center) {
        x = x_center;
        y = y_center;
        r = radius;
        rand = ThreadLocalRandom.current();
    }
    
    public double[] randPoint() {
        double minx = x - r;
        double maxx = x + r;
        double miny = y - r;
        double maxy = y + r;
        do {
            double xx = rand.nextDouble(minx, maxx);
            double yy = rand.nextDouble(miny, maxy);
            if (inCircle(xx, yy)) {
                return new double[]{xx, yy};
            }
        } while(true);
    }
    
    boolean inCircle(double xx, double yy) {
        xx -= x;
        yy -= y;
        xx = xx * xx;
        yy = yy * yy;
        return xx + yy <= r * r;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */