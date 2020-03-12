/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  PWMVictorSPX shooterLeft;
  PWMVictorSPX shooterRight;


  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    shooterLeft = new PWMVictorSPX(Constants.SHOOTER_LEFT_PWM);
    shooterRight = new PWMVictorSPX(Constants.SHOOTER_RIGHT_PWM);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shoot(double speed) {
    shooterLeft.set(speed);
    shooterLeft.setInverted(Constants.SHOOTER_LEFT_INVERTED);
    shooterLeft.set(speed);
    shooterRight.setInverted(Constants.SHOOTER_RIGHT_INVERTED);
  }

  public void stop() {
    shooterLeft.set(0);
    shooterRight.set(0);
  }
}
