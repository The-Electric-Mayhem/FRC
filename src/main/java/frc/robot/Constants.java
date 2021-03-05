// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    // CAN IDs
    public static final int LEFT_FRONT_CAN_ID = 2;
    public static final int RIGHT_FRONT_CAN_ID = 0;
    public static final int LEFT_BACK_CAN_ID = 3;
    public static final int RIGHT_BACK_CAN_ID = 1;
    public static final int SHOOTER_LEFT_CAN_ID = 4;
    public static final int SHOOTER_RIGHT_CAN_ID = 5;
    public static final int INTAKE_CAN_ID = 6;
    public static final int PDP_CAN_ID = 0;

    // Buttons and Axis
    public static final int XBOX_LEFT_Y_AXIS = 1;
    public static final int XBOX_RIGHT_X_AXIS = 0;
    public static final int XBOX_INTAKE_AXIS = 3;

    // Speeds
    public static final double DRIVE_TRAIN_SPEED = 1;
    public static final double AUTONOMOUS_SPEED = 0.4;
    public static final double SHOOTER_SPEED = 1.0;
    public static final double INTAKE_SPEED = 1.0;

    // Joystick
    public static final int JOYSTICK_NUMBER = 0;

    // Inverted
    public static final boolean SHOOTER_INVERTED = false;
    public static final boolean DRIVE_LEFT_FRONT_INVERTED = false;
    public static final boolean DRIVE_RIGHT_FRONT_INVERTED = true;
    public static final boolean DRIVE_LEFT_BACK_INVERTED = false;
    public static final boolean DRIVE_RIGHT_BACK_INVERTED = true;
    public static final boolean INTAKE_INVERTED = false;

    // Camera
    public static final int CAMERA_RESOLUTION_X = 320;
    public static final int CAMERA_RESOLUTION_Y = 240;

    // Times
    public static final double DRIVE_FORWARD_TIME = 3.0;
    public static final double AUTONOMOUS_SHOOT_TIME = 2.0;

    // Analog Channels
    public static final int RANGE_FINDER_CHANNEL = 0;

    // Misc
    public static final double DISTANCE_FORWARD = 1.5; // 1.5 m
}
