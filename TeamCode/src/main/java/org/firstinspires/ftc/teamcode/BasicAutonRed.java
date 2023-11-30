
//package org.firstinspires.ftc.teamcode;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//package org.firstinspires.ftc.robotcontroller.external.samples;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.util.ElapsedTime;


package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.TrinRobot;

@Autonomous(name = "Basic Auto Red", group = "Robot")
public class BasicAutonRed extends LinearOpMode{
    TrinRobot robot = new TrinRobot(this);

    public void runOpMode(){

        robot.init_robot();

        waitForStart();
        long start_time = System.currentTimeMillis();
        long end_time = start_time + 2*1000;

        while (System.currentTimeMillis() < end_time) {
            robot.drivePower(1, 0, 0);
        }
    }


}
