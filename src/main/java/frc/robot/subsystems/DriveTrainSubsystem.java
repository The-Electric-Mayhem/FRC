// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSubsystem extends SubsystemBase {
    /**
     * More information on FRC DriveTrain can be found at:
     * https://docs.wpilib.org/en/stable/docs/software/actuators/wpi-drive-classes.html
     */

    PWMVictorSPX leftFront, rightFront, leftBack, rightBack;
    SpeedControllerGroup leftMotors, rightMotors;
    DifferentialDrive drive;
    AnalogInput rangeFinder;

    public DriveTrainSubsystem() {
        // left front motor
        leftFront = new PWMVictorSPX(Constants.LEFT_FRONT_PWM);
        leftFront.setInverted(Constants.DRIVE_LEFT_FRONT_INVERTED);

        // right front motor
        rightFront = new PWMVictorSPX(Constants.RIGHT_FRONT_PWM);
        rightFront.setInverted(Constants.DRIVE_RIGHT_FRONT_INVERTED);

        // left back motor
        leftBack = new PWMVictorSPX(Constants.LEFT_BACK_PWM);
        leftBack.setInverted(Constants.DRIVE_LEFT_BACK_INVERTED);

        // right back motor
        rightBack = new PWMVictorSPX(Constants.RIGHT_BACK_PWM);
        rightBack.setInverted(Constants.DRIVE_RIGHT_BACK_INVERTED);

        // create speed controller groups
        leftMotors = new SpeedControllerGroup(leftFront, leftBack);
        rightMotors = new SpeedControllerGroup(rightFront, rightBack);

        // create a new differential drive with the left and right motor groups
        drive = new DifferentialDrive(leftMotors, rightMotors);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        super.periodic();
    }

    public void driveWithJoysticks(XboxController controller, double speed) {
        drive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS) * speed,
                controller.getRawAxis(Constants.XBOX_RIGHT_X_AXIS) * speed);
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
