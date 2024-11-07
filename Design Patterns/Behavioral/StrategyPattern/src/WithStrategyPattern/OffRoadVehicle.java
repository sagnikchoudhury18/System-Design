package WithStrategyPattern;

import WithStrategyPattern.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends  Vehicle{

    /*
    The line super(new SportsDriveStrategy()); in the OffRoadVehicle constructor is invoking the constructor of the superclass (the parent class of OffRoadVehicle)
    and passing an instance of SportsDriveStrategy as an argument to it.
    */

    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
