import java.util.Random;

class RandTest {

 public static void main(String[] args) {
  //Source code for java.util.Random found here: http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/tip/src/share/classes/java/util/Random.java
  //tldr; it uses a Linear congruential generator to generate numbers in the format
  //number_(i+1) = (a * number_(i) + c) mod m
  //Where the current version of the OpenJDK are as follows:
  //a = 25214903917
  //c = 11
  //m = 4294967296 (stripping off the first 32 bits to guarantee randomness
  //based on this (reversible) functions we can then caculate prevous random numbers
  long seed;
  seed = 2521L;
  Random rand = new Random(seed);
  System.out.println("next: " + rand.nextInt(10));
  Random rand2 = new Random(InvRand.prevSeed(InvRand.prevSeed(InvRand.prevSeed(InvRand.replicateSeed(rand.nextLong())))) ^ 0x5DEECE66DL);
  System.out.println("next: " + rand2.nextInt(10));
 }
}