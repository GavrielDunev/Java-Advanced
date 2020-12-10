package robotService.models.procedures;

import robotService.models.robots.interfaces.Robot;

public class Work extends BaseProcedure {
    @Override
    public void doService(Robot robot, int procedureTime) {
        super.doService(robot, procedureTime);
        robot.setEnergy(robot.getEnergy() - 6);
        robot.setHappiness(robot.getHappiness() + 12);
    }
}
