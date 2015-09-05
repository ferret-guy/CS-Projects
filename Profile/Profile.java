import java.util.Arrays;

public class Profile {

 public static void main(String[] args) {
  int trial_count = 10000;
  float crashes = 0;
  double[] trials = new double[trial_count];
  for (int i = 0; i < trial_count; i++) {
   trials[i] = Cars_Proj1.main((int)(1000000 * Math.random()));
   //System.out.printf("%.1f\n",trials[i]);
  }
  Arrays.sort(trials);
  Statistics stat = new Statistics(trials);
  System.out.println("Mean: " + stat.getMean());
  System.out.println("StdDev: " + stat.getStdDev());
  System.out.println("Median: " + stat.median());
  System.out.println("Min Value: " + trials[0]);
  System.out.println("Max Value: " + trials[trials.length - 1]);
  for (int i = 0; i < trial_count; i++) {
   if (trials[i] == 0) {
    crashes++;
   }
  }
  System.out.println("Percent of crashes: " + (crashes / ((float) trial_count)) * 100);
 }
}