package WithStrategyPattern.Strategy;

import WithStrategyPattern.Strategy.DriveStrategy;

public class NormalDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("normal drive strategy");
    }
}
