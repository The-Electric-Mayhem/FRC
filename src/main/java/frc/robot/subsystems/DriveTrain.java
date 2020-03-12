/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  PWMVictorSPX leftFront;
  PWMVictorSPX rightFront;
  PWMVictorSPX leftBack;
  PWMVictorSPX rightBack;
  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;
  DifferentialDrive drive;
  AnalogInput rangeFinder;

  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    leftFront = new PWMVictorSPX(Constants.LEFT_FRONT_PWM);
    leftFront.setInverted(Constants.DRIVE_LEFT_FRONT_INVERTED);
    rightFront = new PWMVictorSPX(Constants.RIGHT_FRONT_PWM);
    rightFront.setInverted(Constants.DRIVE_RIGHT_FRONT_INVERTED);
    leftBack = new PWMVictorSPX(Constants.LEFT_BACK_PWM);
    leftBack.setInverted(Constants.DRIVE_LEFT_BACK_INVERTED);
    rightBack = new PWMVictorSPX(Constants.RIGHT_BACK_PWM);
    rightBack.setInverted(Constants.DRIVE_RIGHT_BACK_INVERTED);

    leftMotors = new SpeedControllerGroup(leftFront, leftBack);
    rightMotors = new SpeedControllerGroup(rightFront, rightBack);
    drive = new DifferentialDrive(leftMotors, rightMotors);

    rangeFinder = new AnalogInput(Constants.RANGE_FINDER_CHANNEL);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveWithJoysticks(XboxController controller, double speed) {
    drive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS) * speed, controller.getRawAxis(Constants.XBOX_RIGHT_X_AXIS) * speed);
  }

  public void driveForward(double speed) {
    drive.tankDrive(speed, speed);
  }

  public boolean driveToDistance(double distance, double speed) {
    while(rangeFinder.getAverageVoltage() > distance) {
      driveForward(speed);
    }
    return true;
  }

  public void stop() {
    drive.stopMotor();
  }
}
