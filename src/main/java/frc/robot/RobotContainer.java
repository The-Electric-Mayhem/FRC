// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrainSubsystem m_driveTrain = new DriveTrainSubsystem();
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();

  private final DriveCommand m_driveCommand = new DriveCommand(m_driveTrain);
  private final ShootCommand m_shootCommand = new ShootCommand(m_shooterSubsystem);
  private final IntakeCommand m_intakeCommand = new IntakeCommand(m_intakeSubsystem);

  public static final XboxController m_joystick = new XboxController(Constants.JOYSTICK_NUMBER);

  private final SendableChooser<Command> chooser = new SendableChooser<>();
  // public static final PowerDistributionPanel m_pdp = new
  // PowerDistributionPanel(Constants.PDP_CAN_ID);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_driveCommand.addRequirements(m_driveTrain);
    m_driveTrain.setDefaultCommand(m_driveCommand);

    m_shootCommand.addRequirements(m_shooterSubsystem);
    m_shooterSubsystem.setDefaultCommand(m_shootCommand);

    m_intakeCommand.addRequirements(m_intakeSubsystem);
    m_intakeSubsystem.setDefaultCommand(m_intakeCommand);

    // chooser
    // chooser.addOption("Autonomous One", autonomousOne);
    // chooser.addOption("Autonomous Two", autonomousTwo);
    SmartDashboard.putData("Autonomous", chooser);
    // SmartDashboard.putData("PDP", m_pdp);
    SmartDashboard.putData("DriveTrain", m_driveTrain);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton m_shootButton = new JoystickButton(m_joystick, XboxController.Button.kBumperRight.value);
    m_shootButton.whileHeld(new ShootCommand(m_shooterSubsystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
