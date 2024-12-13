package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Manual Servo Control", group = "TeleOp")
public class servo extends OpMode {

    // Declare the servo
    private Servo sampleServo;

    private double currentServoPosition = 0.5; // Start at the midpoint

    @Override
    public void init() {
        // Initialize the servo
        sampleServo = hardwareMap.get(Servo.class, "wrist2");
        sampleServo.setPosition(currentServoPosition); // Set initial position
    }

    @Override
    public void loop() {
        // Control servo position with gamepad buttons
        double SERVO_INCREMENT = 0.01;
        if (gamepad1.dpad_up) {
            currentServoPosition += SERVO_INCREMENT;
        } else if (gamepad1.dpad_down) {
            currentServoPosition -= SERVO_INCREMENT;
        }

        // Clamp the servo position within the range
        // Define positions for the servo
        double SERVO_MIN_POS = 0.0;
        double SERVO_MAX_POS = 1.0;
        currentServoPosition = Math.max(SERVO_MIN_POS, Math.min(SERVO_MAX_POS, currentServoPosition));

        // Update the servo position
        sampleServo.setPosition(currentServoPosition);

        // Telemetry for debugging
        telemetry.addData("Servo Position", currentServoPosition);
        telemetry.update();
    }
}
