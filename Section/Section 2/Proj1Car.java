public class Proj1Car extends BaseCar
{
    //This code is not very effective...
    public int getPedal(){
        if ((getSpeed() < speedOfNextCar()) && (distToNextCar() < 99) ){return -1;} //Slow down if we are closer than 1 unit and are faster than the target car
        if ((getSpeed() > speedOfNextCar()) && (distToNextCar() > 101) ){return 0;} //Speed up if we are further than the next car and are slower than the target car
        if ((getSpeed() < speedOfNextCar()) && (distToNextCar() > 101)){return 1;} //If we are further than 101 units and slower speed up
        if ((getSpeed() > speedOfNextCar()) && (distToNextCar() < 99)){return -1;}//If we are faster than the target car and closer than one unit break
        return 0;
    }
}

