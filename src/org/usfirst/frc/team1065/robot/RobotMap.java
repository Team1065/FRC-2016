package org.usfirst.frc.team1065.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Integer Constants
    public static int MOOSE_MOTOR_UPDATE_TIME = 10;
    
    //Double Constants
    public static double DRIVE_TOP_SPEED = 140.0,// inches per second TODO: change
    					 DRIVE_WHEEL_DIAMETER = 7.65,
    					 DRIVE_ENCODERS_COUNTS_PER_REV = 360;
    
    //PID Variables
    public static double DRIVE_MOTOR_KP = .1;//TODO: tune
    
    //PWM Ports
    public static int LEFT_DRIVE_MOTOR_PORT = 0,
    				  RIGHT_DRIVE_MOTOR_PORT = 1;
    
    //Digital Ports
    public static int LEFT_DRIVE_ENCODER_PORT_A = 0,
    				  LEFT_DRIVE_ENCODER_PORT_B = 1,
					  RIGHT_DRIVE_ENCODER_PORT_A = 2,
    				  RIGHT_DRIVE_ENCODER_PORT_B = 3;
    
    //OI
    public static int LEFT_JOYSTICK_PORT = 0,
					  RIGHT_JOYSTICK_PORT = 1,
					  ENHANCED_DS_PORT = 2;
}
