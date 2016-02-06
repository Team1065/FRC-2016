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
		if(Math.abs(leftJoystick.getY()) < RobotMap.JOYSTICK_DEADBAND){
			return 0;
		}
	    else {
	    	return -leftJoystick.getY();
	    }
	}
	
	public double getRightJoystickY () {
		if(Math.abs(rightJoystick.getY()) < RobotMap.JOYSTICK_DEADBAND){
			return 0;
		}
	    else {
	    	return -rightJoystick.getY();
	    }
	}
    
    public double getYAverage(){
        return (getLeftJoystickY () + getRightJoystickY ())/2.0;
    }
    
    public boolean getRightJoystickTrigger(){
    	return rightJoystick.getTrigger();
    }
    
    public boolean getIntakeUpSwitch(){
    	return enhancedDS.getRawButton(RobotMap.INTAKE_UP_PORT);
    }
    
    public boolean getIntakeDownSwitch(){
    	return enhancedDS.getRawButton(RobotMap.INTAKE_DOWN_PORT);
    }
}

