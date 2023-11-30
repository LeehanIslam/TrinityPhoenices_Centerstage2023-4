package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class TrinRobot {
    private final OpMode opMode;

    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    public Servo planeLaunch = null;
    public DcMotor armBase = null;
    public DcMotor armElbow = null;

    private double MECANUM_SPEED = 1;
    private double ROTATION_SPEED = 1;
    private double ARM_BASE_SPEED = 1;
    private double ARM_ELBOW_SPEED = 1;

    public TrinRobot(OpMode mode) {
        opMode = mode;
    }

    public void drivePower(double x, double y, double r){
        x *= MECANUM_SPEED;
        y *= MECANUM_SPEED;
        r *= ROTATION_SPEED;
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(r), 1);

        frontLeft.setPower(-(y + x + r));
        frontRight.setPower((y - x - r));
        backLeft.setPower(-(y - x + r));
        backRight.setPower((y + x - r));
    }

    public void init_robot(){
        frontLeft = opMode.hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = opMode.hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = opMode.hardwareMap.get(DcMotor.class, "backLeft");
        backRight = opMode.hardwareMap.get(DcMotor.class, "backRight");

        armBase = opMode.hardwareMap.get(DcMotor.class, "armBase");
        armElbow = opMode.hardwareMap.get(DcMotor.class, "armElbow");

        planeLaunch = opMode.hardwareMap.get(Servo.class, "planeLaunch");

        opMode.telemetry.addData("start", "hello world :>");
        opMode.telemetry.update();
    }
    public void armPower(double basePwr, double elbowPwr){
        armBase.setPower(basePwr*ARM_BASE_SPEED);
        armElbow.setPower(elbowPwr*ARM_ELBOW_SPEED);
    }
    public void armPos(int basePos, int elbowPos){
        armBase.setTargetPosition(basePos);
        armElbow.setTargetPosition(elbowPos);
        armBase.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armElbow.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armBase.setPower(ARM_BASE_SPEED);
        armElbow.setPower(ARM_ELBOW_SPEED);
    }
}
