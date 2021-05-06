// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSubsystem extends SubsystemBase {
    /**
     * More information on FRC DriveTrain can be found at:
     * https://docs.wpilib.org/en/stable/docs/software/actuators/wpi-drive-classes.html
     */

    WPI_VictorSPX leftFront, rightFront, leftBack, rightBack;
    SpeedControllerGroup leftMotors, rightMotors;
    public static DifferentialDrive drive;
    AnalogInput rangeFinder;

    public DriveTrainSubsystem() {
        // left front motor

        leftFront = new WPI_VictorSPX(Constants.LEFT_BACK_CAN_ID);
        leftFront.setInverted(Constants.DRIVE_LEFT_FRONT_INVERTED);

        // right front motor
        rightFront = new WPI_VictorSPX(Constants.RIGHT_FRONT_CAN_ID);
        rightFront.setInverted(Constants.DRIVE_RIGHT_FRONT_INVERTED);

        // left back motor
        leftBack = new WPI_VictorSPX(Constants.LEFT_BACK_CAN_ID);
        leftBack.setInverted(Constants.DRIVE_LEFT_BACK_INVERTED);

        // right back motor
        rightBack = new WPI_VictorSPX(Constants.RIGHT_BACK_CAN_ID);
        rightBack.setInverted(Constants.DRIVE_RIGHT_BACK_INVERTED);

        // create speed controller groups
        leftMotors = new SpeedControllerGroup(leftFront, leftBack);
        rightMotors = new SpeedControllerGroup(rightFront, rightBack);

        // create a new differential drive with the left and right motor groups
        drive = new DifferentialDrive(leftMotors, rightMotors);

        SmartDashboard.putData("Differential Drive", drive);
        SmartDashboard.putData("Left Speedgroup", leftMotors);
        SmartDashboard.putData("Right Speedgroup", rightMotors);

        SmartDashboard.putData("Left Front Motor", leftFront);
        SmartDashboard.putData("Left Back Motor", leftBack);
        SmartDashboard.putData("Right Front Motor", rightFront);
        SmartDashboard.putData("Right Back Motor", rightBack);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        super.periodic();
    }

    public void driveWithJoysticks(XboxController controller, double speed) {
        drive.arcadeDrive(speed * controller.getRawAxis(0), -speed * controller.getRawAxis(1));
    }

    public void driveWithJoysticksTank(Joystick leftStick, Joystick rightStick) {
        drive.tankDrive(-leftStick.getY(), -rightStick.getY());
    }

    public void driveForward(double speed) {
        drive.tankDrive(speed, speed);
    }

    public boolean driveToDistance(double distance, double speed) {
        while (rangeFinder.getAverageVoltage() > distance) {
            driveForward(speed);
        }
        return true;
    }

    public void stop() {
        drive.stopMotor();
    }
}
