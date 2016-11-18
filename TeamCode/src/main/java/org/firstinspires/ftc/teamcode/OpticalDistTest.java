package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

/**
 * Created by kklausing19 on 11/8/16.
 */

@TeleOp(name="distance test")
public class OpticalDistTest extends OpMode {

    public OpticalDistanceSensor sensor;

    public void init() {
        sensor = hardwareMap.opticalDistanceSensor.get("distance_sensor");
        sensor.enableLed(true);
    }

    public void loop() {
        telemetry.addData("Raw light", sensor.getRawLightDetected());
        telemetry.addData("Light", sensor.getLightDetected());
    }

}
