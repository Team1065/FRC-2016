package org.usfirst.frc.team1065.robot.subsystems;

import org.usfirst.frc.team1065.robot.RobotMap;
import org.usfirst.frc.team1065.robot.commands.ManualObstacleManipulatorControl;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ObstacleManipulator extends Subsystem {
    
	private Compressor compressor;
	private Solenoid actuatorLeft, actuatorRight;
	
	public ObstacleManipulator(){
		compressor = new Compressor();
		compressor.start();
		
		actuatorLeft = new Solenoid(RobotMap.OBSTACLE_MANIPULATOR_LEFT_PORT);
		actuatorRight = new Solenoid(RobotMap.OBSTACLE_MANIPULATOR_RIGHT_PORT);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ManualObstacleManipulatorControl());
    }
    
    public void setActuators(boolean value){
    	actuatorLeft.set(value);
    	actuatorRight.set(value);
    }
}

