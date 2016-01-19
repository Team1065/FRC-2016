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
    public static double DRIVE_TOP_SPEED = 12.0;// feet per second TODO: change
    
    //PID Variables
    public static double DRIVE_MOTOR_KP = .1;//TODO: tune
}
