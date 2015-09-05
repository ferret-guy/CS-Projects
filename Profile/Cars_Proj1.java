import java.util.Random;
//import java.awt.Color;

public class Cars_Proj1 {
 public static double main(int seed) {

  //System.out.println("Running with seed="+seed);
  Random rand = new Random(seed);


  // initialize the array of cars
  BaseCar[] cars = new BaseCar[2];

  cars[0] = new Proj1Car();
  cars[1] = new TargetCar(rand);
  cars[0].setNext(cars[1]);

  cars[0].init(rand.nextInt(100), rand.nextInt(25) + 25, 2);
  cars[1].init(cars[0].getPos() + 50 + rand.nextInt(100), cars[0].getSpeed(), 2);

  // before we start the main loop, we run tick() once on each car
  // (but with time=0) so that we'll get the cars all pre-colored
  // as greed or red (instead of black)
  for (int i = 0; i < cars.length; i++)
  cars[i].tick(0);


  // the main loop: we draw the current state, increment by a certain
  // time delta, and then check for collisions.  If a collision has
  // occurred, we terminate the simulation.  We run all of the cars have
  // exited the road.
  double TIME_TICK = 0.01;
  // now, do the loop.
  double elapsedTime = 0;
  double score = 0;
  while (elapsedTime < 25) {



   // update the score.
   score += TIME_TICK * Math.abs(cars[0].distToNextCar() - 100);


   // iterate over all of the cars, and advance their positions
   for (int i = 0; i < cars.length; i++)
   if (cars[i] != null) cars[i].tick(TIME_TICK);

   elapsedTime += TIME_TICK;


   // hunt for any collisions
   int collision = findCollision(cars);
   if (collision != -1) {
    return 0;
   }
  }

  // we get here when either there has been a collision, or when all
  // of the cars have exited the road.
  return score;
 }

 public static int findCollision(BaseCar[] cars) {
  for (int i = 0; i < cars.length; i++)
  for (int j = 0; j < cars.length; j++)
  if (i != j && cars[i] != null && cars[j] != null) {
   double posI = cars[i].getPos();
   double posJ = cars[j].getPos();
   double lenI = cars[i].getLen();

   if (posI <= posJ && posI + lenI > posJ) return i;
  }

  return -1;
 }
}