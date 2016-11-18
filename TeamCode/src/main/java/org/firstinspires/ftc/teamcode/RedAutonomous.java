package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by kching17 on 10/28/16.
 */
@Autonomous(name="Red")
public class RedAutonomous extends AutonomousOpMode {

    @Override
    public void runProgram() throws InterruptedException {
        driveUntilLine(-0.7, -0.7);
        drive(0.2, 0.2, 0.2);
        trackLine(-0.3, 3);
        int side = color_sensor.red() > color_sensor.blue()? 1:-1;
        drive(1, 1, 0.2);
        button.setPosition(side);
        drive(-.5, -.5, .8);
        drive(1,1,1);
        drive(-1,0,.8);
        drive(-.5,-.7,.5);
        button.setPosition(.5);
        driveUntilLine(-.5,-.5);
        drive(0.2, 0.2, 0.2);
        trackLine(-0.3, 3);
        side = color_sensor.red() > color_sensor.blue()? -1:1;
        drive(1, 1, 0.2);
        button.setPosition(side);
        drive(-.5, -.5, .8);
        drive(1,1,1.5);
        drive(0,1,.5);
        drive(1,1,1);
    }
}
