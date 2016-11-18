package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by kching17 on 10/11/16.
 */

@TeleOp(name="Tele Op", group="Keen")
public class TeleOpMode extends OpMode {
    public DcMotor left_drive;
    public DcMotor right_drive;
    public ElapsedTime toggle = new ElapsedTime();

    public Servo servo;
    // true = 1
    // false = 0
    boolean x_already_pressed = false;

    public void init() {
        left_drive = hardwareMap.dcMotor.get("left_drive");
        right_drive = hardwareMap.dcMotor.get("right_drive");
        right_drive.setDirection(DcMotor.Direction.REVERSE);
        servo = hardwareMap.servo.get("servo");

    }

    public void loop() {
        left_drive.setPower(gamepad1.left_stick_y);
        right_drive.setPower(gamepad1.right_stick_y);
        //servo code on button x
        if (gamepad1.x && toggle.time() > 0.5) {
            if (!x_already_pressed) {
                if (servo.getPosition() > 0.5) {
                    servo.setPosition(-1);
                } else {
                    servo.setPosition(1);
                }
                x_already_pressed = true;
            }
        } else {
            x_already_pressed = false;
        }
    }
}
