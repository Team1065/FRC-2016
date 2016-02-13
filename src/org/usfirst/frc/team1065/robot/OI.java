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
    
    public boolean getLeftJoystickTrigger(){
    	return leftJoystick.getTrigger();
    }
    
    public boolean getIntakeInSwitch(){
    	return enhancedDS.getRawButton(RobotMap.INTAKE_IN_PORT);
    }
    
    public boolean getIntakeOutSwitch(){
    	return enhancedDS.getRawButton(RobotMap.INTAKE_OUT_PORT);
    }
    
    public boolean getDriveOverride(){
    	return enhancedDS.getRawButton(RobotMap.DRIVE_CONTROL_OVERRIDE);
    }
    
    public boolean getShooterOverride(){
    	return enhancedDS.getRawButton(RobotMap.DRIVE_CONTROL_OVERRIDE);
    }
    
    public double getShooterDesiredSpeed(){
    	double speed;
		double knobValue = enhancedDS.getRawAxis(RobotMap.SHOOTER_KNOB_PORT);
		double threshold = 0.008;
		
		boolean useVoltageValues = getShooterOverride();
		
		//If Station Knob is at 0
		if(knobValue < RobotMap.SHOOTER_KNOB_POS_0 + threshold){
			speed = useVoltageValues ? RobotMap.SHOOTER_VOLT_0 : RobotMap.SHOOTER_RPM_0;
        }
        //If Station Knob is at 1
        else if(knobValue >= RobotMap.SHOOTER_KNOB_POS_1 - threshold && knobValue < RobotMap.SHOOTER_KNOB_POS_1 + threshold){
        	speed = useVoltageValues ? RobotMap.SHOOTER_VOLT_1 : RobotMap.SHOOTER_RPM_1;
        }
        //If Station Knob is at 2
        else if(knobValue >= RobotMap.SHOOTER_KNOB_POS_2 - threshold && knobValue < RobotMap.SHOOTER_KNOB_POS_2 + threshold){
        	speed = useVoltageValues ? RobotMap.SHOOTER_VOLT_2 : RobotMap.SHOOTER_RPM_2;
        }
        //If Station Knob is at 3
        else if(knobValue >= RobotMap.SHOOTER_KNOB_POS_3 - threshold && knobValue < RobotMap.SHOOTER_KNOB_POS_3 + threshold){
        	speed = useVoltageValues ? RobotMap.SHOOTER_VOLT_3 : RobotMap.SHOOTER_RPM_3;
        }
        //If Station Knob is at 4
        else if(knobValue >= RobotMap.SHOOTER_KNOB_POS_4 - threshold && knobValue < RobotMap.SHOOTER_KNOB_POS_4 + threshold){
        	speed = useVoltageValues ? RobotMap.SHOOTER_VOLT_4 : RobotMap.SHOOTER_RPM_4;
        }
        //If Station Knob is at 5
        else if(knobValue >= RobotMap.SHOOTER_KNOB_POS_5 - threshold){
        	speed = useVoltageValues ? RobotMap.SHOOTER_VOLT_5 : RobotMap.SHOOTER_RPM_5;
        }
        else
        {
        	speed = useVoltageValues ? RobotMap.SHOOTER_VOLT_0 : RobotMap.SHOOTER_RPM_0;
        }
		
		return speed;
	}
}

