package robotService.models.procedures;

import robotService.models.robots.interfaces.Robot;

public class Charge extends BaseProcedure {

    @Override
    public void doService(Robot robot, int procedureTime) {
        super.doService(robot, procedureTime);
        robot.setHappiness(robot.getHappiness() + 12);
        robot.setEnergy(robot.getEnergy() + 10);
    }
}
