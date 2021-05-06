// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveCommand extends CommandBase {
  private final DriveTrainSubsystem driveTrain;

  /** Creates a new DriveCommand. */
  public DriveCommand(DriveTrainSubsystem dt) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = dt;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      //driveTrain.driveWithJoysticks(RobotContainer.m_controller, Constants.DRIVE_TRAIN_SPEED);
      driveTrain.driveWithJoysticksTank(RobotContainer.m_joystick1,RobotContainer.m_joystick2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
