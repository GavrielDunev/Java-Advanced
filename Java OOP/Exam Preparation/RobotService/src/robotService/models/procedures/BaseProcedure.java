package robotService.models.procedures;

import robotService.models.procedures.interfaces.Procedure;
import robotService.models.robots.interfaces.Robot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static robotService.common.ExceptionMessages.*;

public abstract class BaseProcedure implements Procedure {
    protected Map<String, List<Robot>> robots;

    protected BaseProcedure() {
        this.robots = new HashMap<>();
    }


    @Override
    public String history() {
        StringBuilder builder = new StringBuilder();
        String procedure = this.getClass().getSimpleName();
        builder.append(procedure).append(System.lineSeparator());
        List<Robot> robots = this.robots.get(procedure);
        for (Robot robot : robots) {
            builder.append(robot.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

    @Override
    public void doService(Robot robot, int procedureTime) {
        if (robot.getProcedureTime() < procedureTime) {
            throw new IllegalArgumentException(INSUFFICIENT_PROCEDURE_TIME);
        }

        //TODO - move to subclasses
        robot.setProcedureTime(robot.getProcedureTime() - procedureTime);
        this.robots.putIfAbsent(this.getClass().getSimpleName(), new ArrayList<>());
        this.robots.get(this.getClass().getSimpleName()).add(robot);
    }
}
