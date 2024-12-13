package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "A1 Auto")

public class Auto extends LinearOpMode {
   DcMotor FrontLeft;
   DcMotor FrontRight;
   DcMotor BackLeft;
   DcMotor BackRight;
    DcMotor Slider;DcMotorEx Shoulder;
    @Override
    public void runOpMode() throws InterruptedException {
        Slider = hardware.get(DcMotor.class, "Slider")
        FrontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "frontRight");
        BackLeft = hardwareMap.get(DcMotor.class, "backLeft");
        BackRight = hardwareMap.get(DcMotor.class, "backRight");
        Shoulder = hardwareMap.get(DcMotorEx.class, "Shoulder");


        FrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);


        waitForStart();
        // NEW UPDATE! When using the functions, there are now 2 variables
        // 1st one is power, 2nd one is time to sleep after. It will auto sleep.
        // Remember that time is in miliseconds not seconds ppl
        // Psuedocode example:
        //     moveForward(POWER, TIME)
        // -techiebirb
        if(opModeIsActive()){
            moveForward(1000, 500);
            slideLeft(20, 100);
            moveBackward(1000, 100);
            moveForward(1000, 500);
            slideLeft(20, 100);
            moveBackward(1000, 100);
            moveForward(1000, 500);
            slideLeft(20, 100);
            moveBackward(1000, 100);
            stopMotors();
        }

    }
    private void moveForward(double power, double time) {
        FrontLeft.setPower(power);
        FrontRight.setPower(power);
        BackLeft.setPower(power);
        BackRight.setPower(power);
        sleep(time);
    }
    private void slideLeft(double power, double time) {
        FrontLeft.setPower(-power);
        FrontRight.setPower(power);
        BackLeft.setPower(power*0.8);
        BackRight.setPower(-power*0.8);
        sleep(time);
    }

    private void sliderUp(double power, double time) {
        Slider.setPower(power*1.2)
        sleep(time);
    }

    private void sliderBack(double power, double time) {
        Slider.setPower(-power*1.2)
        sleep(time);
    }

    private void slideRight(double power, double time) {
        FrontLeft.setPower(power);
        FrontRight.setPower(-power);
        BackLeft.setPower(-power*0.8);
        BackRight.setPower(power*0.8);
        sleep(time);
    }

    private void moveBackward(double power, double time){
        FrontLeft.setPower(-power);
        FrontRight.setPower(-power);
        BackLeft.setPower(-power);
        BackRight.setPower(-power);
        sleep(time);
    }

    // Method to stop all motors
    private void stopMotors() {
        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);
    }
} 