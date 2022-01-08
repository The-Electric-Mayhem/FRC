// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  PWMVictorSPX shooterLeft, shooterRight;
  MotorControllerGroup shooter;

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    shooterLeft = new PWMVictorSPX(Constants.SHOOTER_LEFT_CAN_ID);
    shooterRight = new PWMVictorSPX(Constants.SHOOTER_RIGHT_CAN_ID);

    shooter = new MotorControllerGroup(shooterLeft, shooterRight);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shoot(double speed) {
    shooter.set(speed);
    shooter.setInverted(Constants.SHOOTER_INVERTED);
  }

  public void stop() {
    shooter.set(0);
  }
}
