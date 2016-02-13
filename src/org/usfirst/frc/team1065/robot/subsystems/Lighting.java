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
    
	private Solenoid intakeLED, shooterLED;
	
	public Lighting(){
		intakeLED = new Solenoid(RobotMap.INTAKE_LED_PORT);
		shooterLED = new Solenoid(RobotMap.SHOOTER_LED_PORT);
		
		LiveWindow.addActuator("Intake", "Intake LED", intakeLED);
    	LiveWindow.addActuator("Shooter", "Shooter LED", shooterLED);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new LEDControl());
    }

    public void setIntakeLED(boolean val){
    	intakeLED.set(val);
    }
    
    public void setShooterLED(boolean val){
    	shooterLED.set(val);
    }
}

