package org.usfirst.frc.team1065.robot.subsystems;

import java.util.Timer;
import java.util.TimerTask;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

import org.usfirst.frc.team1065.robot.RobotMap;


public class MooseDriveMotor {
	private SpeedController motor;
	private Encoder encoder;
	
	private double desiredVelocity;
	private double currentVelocity;
	private boolean encoderEnabled;
	
	private TimerTask runUpdate = new TimerTask() {
		
		@Override
		public void run() {
			update();
		}
	};
	
	public MooseDriveMotor(SpeedController motor, Encoder encoder){
		this.motor = motor;
		this.encoder = encoder;
		
		this.desiredVelocity = 0.0;
		this.currentVelocity = 0.0;
		this.encoderEnabled = false;
	}
	
	public void setVelocity(double desiredVelocity) {
		this.desiredVelocity = desiredVelocity;
	}
	
	public double getVelocity(double desiredVelocity) {
		return this.desiredVelocity;
	}
	
	public void encoderFeedbackEnabled(boolean encoderEnabled) {
		this.encoderEnabled = encoderEnabled;
	}
	
	public void update(){
		//use MooseMath.trim
		if(encoderEnabled){
			//desiredVelocity is from -1 to 1
			double desiredVelocityFPS =  this.desiredVelocity * RobotMap.DRIVE_TOP_SPEED;
			
			double adjustedError = (desiredVelocityFPS - this.encoder.getRate()) * RobotMap.DRIVE_MOTOR_KP;
			
			currentVelocity = trim(currentVelocity + adjustedError,-1.0,1.0);
			
			motor.set(currentVelocity);
		}
		else{
			motor.set(desiredVelocity);
		}
	}
	
	public void start() {
		try{
			Timer myTimer = new Timer();
			myTimer.schedule(runUpdate,0,RobotMap.MOOSE_MOTOR_UPDATE_TIME);
		} catch (Exception a) {
			System.out.println("Exception caught trying to schedule MooseMotor update loop");
		}
	}
	
	public double trim(double value, double min, double max){
		if(value > max){
			return max;
		}
		else if(value < min){
			return min;
		}
		else{
			return value;
		}
	}
	
}
