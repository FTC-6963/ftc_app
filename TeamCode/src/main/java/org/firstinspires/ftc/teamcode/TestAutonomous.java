package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by kching17 on 10/4/16.
 */
@Autonomous(name="Test Autonomous", group="Test")
@Disabled
public class TestAutonomous extends LinearOpMode{
    public DcMotor motor_1;
    public Servo servo_1;

    public void runOpMode() {
        motor_1 = hardwareMap.dcMotor.get("motor_1");
        servo_1 = hardwareMap.servo.get("servo_1");

        try {
            waitForStart();

            motor_1.setPower(0.8);
            sleep(5000);
            servo_1.setPosition(0.8);
        } catch (InterruptedException e) {}
    }
}
