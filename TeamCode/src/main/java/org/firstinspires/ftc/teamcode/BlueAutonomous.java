package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by kklausing19 on 11/12/16.
 */

@Autonomous(name="Blue")
public class BlueAutonomous extends AutonomousOpMode2 {

    @Override
    public void runProgram() throws InterruptedException {

        driveUntilLine(-0.7, -0.7);
        drive(0.2, 0.2, 0.25);
        trackLine(-0.3, 3);
        int side = color_sensor.red() > color_sensor.blue()? -1:1;
        drive(1, 1, 0.2);
        button.setPosition(side);
        drive(-1, -1, .7);
        drive(1, 1.5, 2);
    }
}
