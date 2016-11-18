package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by kching17 on 10/11/16.
 */
public abstract class AutonomousOpMode extends LinearOpMode {

    public DcMotor left_drive;
    public DcMotor right_drive;
    public Servo button;

    public LightSensor light_sensor;
    public ColorSensor color_sensor;

    public OpticalDistanceSensor distance_sensor;

    public ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() {
        left_drive = hardwareMap.dcMotor.get("left_drive");
        right_drive = hardwareMap.dcMotor.get("right_drive");
        right_drive.setDirection(DcMotor.Direction.REVERSE);
        light_sensor = hardwareMap.lightSensor.get("light_sensor");
        light_sensor.enableLed(true);
        color_sensor = hardwareMap.colorSensor.get("color_sensor");
        color_sensor.enableLed(false);
        distance_sensor = hardwareMap.opticalDistanceSensor.get("distance_sensor");
        button = hardwareMap.servo.get("servo");
        try {
            waitForStart();
            if (opModeIsActive()) {
                idle();
                runProgram();
            }
        } catch (InterruptedException e) {
        }



    }

    public abstract void runProgram() throws InterruptedException;

    public void drive(double l_pwr, double r_pwr, double time) throws InterruptedException {
        if (opModeIsActive()) {
            left_drive.setPower((float)l_pwr);
            right_drive.setPower((float)r_pwr);
            resetStartTime();
            while (opModeIsActive() && time > getRuntime()) {
                idle();
            }
            left_drive.setPower(0);
            right_drive.setPower(0);
        }
    }

    public void driveUntilLine(double l_pwr, double r_pwr) throws InterruptedException {
        if (opModeIsActive()) {
            left_drive.setPower(l_pwr);
            right_drive.setPower(r_pwr);
            while (opModeIsActive() && light_sensor.getLightDetected() < 0.4) {
                idle();
            }
            left_drive.setPower(0);
            right_drive.setPower(0);
        }
    }

    public void trackLine(double pwr, double time) {
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < time) {
            if(light_sensor.getLightDetected() < 0.4) {
                left_drive.setPower(0);
                right_drive.setPower(pwr);
            } else {
                left_drive.setPower(pwr);
                right_drive.setPower(0);
            }
        }
    }

    public void driveUntilDist(double pwr) {
        if (opModeIsActive()) {
            left_drive.setPower(pwr);
            right_drive.setPower(pwr);
            while (opModeIsActive() && distance_sensor.getLightDetected() < 0.22) {
                telemetry.addData("Light Detected", distance_sensor.getLightDetected());
            }
            left_drive.setPower(0);
            right_drive.setPower(0);
        }
    }





}
