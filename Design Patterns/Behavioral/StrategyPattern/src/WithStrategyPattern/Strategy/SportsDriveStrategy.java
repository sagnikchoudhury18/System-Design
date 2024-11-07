package WithStrategyPattern.Strategy;

import WithStrategyPattern.Strategy.DriveStrategy;

public class SportsDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("sports drive strategy");
    }
}
