package org.usfirst.frc.team1065.robot.subsystems;

import org.usfirst.frc.team1065.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private Talon leftTalon, rightTalon;
    private MooseDriveMotor leftMooseMotor, rightMooseMotor;
    private Encoder leftEncoder, rightEncoder;
    
    public DriveTrain(){
    	leftEncoder = new Encoder(RobotMap.LEFT_DRIVE_ENCODER_PORT_A,RobotMap.LEFT_DRIVE_ENCODER_PORT_B,true,CounterBase.EncodingType.k1X);
    	rightEncoder = new Encoder(RobotMap.LEFT_DRIVE_ENCODER_PORT_A,RobotMap.LEFT_DRIVE_ENCODER_PORT_B,false,CounterBase.EncodingType.k1X);
    	leftEncoder.setDistancePerPulse((RobotMap.DRIVE_WHEEL_DIAMETER * Math.PI)/(RobotMap.DRIVE_ENCODERS_COUNTS_PER_REV*12));//1/12 to convert inches to feet
    	rightEncoder.setDistancePerPulse((RobotMap.DRIVE_WHEEL_DIAMETER * Math.PI)/(RobotMap.DRIVE_ENCODERS_COUNTS_PER_REV*12));//1/12 to convert inches to feet
    	
    	leftTalon = new Talon(RobotMap.LEFT_DRIVE_MOTOR_PORT);
    	rightTalon = new Talon(RobotMap.RIGHT_DRIVE_MOTOR_PORT);
    	rightTalon.setInverted(true);
    	
    	leftMooseMotor = new MooseDriveMotor(leftTalon, leftEncoder);
    	rightMooseMotor = new MooseDriveMotor(rightTalon, rightEncoder);
    	leftMooseMotor.encoderFeedbackEnabled(false);
    	rightMooseMotor.encoderFeedbackEnabled(false);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive(double leftSpeed, double rightSpeed){
    	leftMooseMotor.setVelocity(leftSpeed);
    	rightMooseMotor.setVelocity(rightSpeed);
    }
    
    public void setEncoderFeedback(boolean enable){
    	leftMooseMotor.encoderFeedbackEnabled(enable);
    	rightMooseMotor.encoderFeedbackEnabled(enable);
    }
}

