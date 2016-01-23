package org.usfirst.frc.team1065.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	Joystick leftJoystick, rightJoystick, enhancedDS;
    
    
	public OI() {
		leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK_PORT);
		rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT);
	    enhancedDS = new Joystick(RobotMap.ENHANCED_DS_PORT);
	}
	
	public double getLeftJoystickY () {
		return -leftJoystick.getY();
	}
	
	public double getRightJoystickY () {
		return -rightJoystick.getY();
	}
    
    public double getYAverage(){
        return ((-leftJoystick.getY()) + (-rightJoystick.getY()))/2.0;
    }
}

