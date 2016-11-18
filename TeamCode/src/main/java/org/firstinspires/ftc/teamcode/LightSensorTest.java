package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.LightSensor;

/**
 * Created by kching17 on 10/28/16.
 */
@TeleOp(name="Light Sensor Test")
public class LightSensorTest extends OpMode {
    LightSensor lightSensor;

    public void init() {
        lightSensor = hardwareMap.lightSensor.get("light_sensor");
        lightSensor.enableLed(true);
    }

    public void loop() {
        telemetry.addData("Light Sensor Value", lightSensor.getLightDetected());
    }
}
