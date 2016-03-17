package org.usfirst.frc.team1065.robot.subsystems;

import org.usfirst.frc.team1065.robot.RobotMap;
import org.usfirst.frc.team1065.robot.commands.LEDControl;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Lighting extends Subsystem {
    
	private Solenoid leftLED, frontLED, rightLED, backLED;
	
	public Lighting(){
		leftLED = new Solenoid(RobotMap.LEFT_LED_PORT);
		frontLED = new Solenoid(RobotMap.FRONT_LED_PORT);
		rightLED = new Solenoid(RobotMap.RIGHT_LED_PORT);
		backLED = new Solenoid(RobotMap.BACK_LED_PORT);
		
		LiveWindow.addActuator("Intake", "leftLED", leftLED);
    	LiveWindow.addActuator("Shooter", "frontLED", frontLED);
    	LiveWindow.addActuator("Shooter", "rightLED", rightLED);
    	LiveWindow.addActuator("Shooter", "backLED", backLED);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new LEDControl());
    }

    public void setLeftLED(boolean val){
    	leftLED.set(val);
    }
    
    public void setFrontLED(boolean val){
    	frontLED.set(val);
    }
    
    public void setRightLED(boolean val){
    	rightLED.set(val);
    }
    
    public void setBackLED(boolean val){
    	backLED.set(val);
    }
}

