
package org.usfirst.frc.team1065.robot;

import org.usfirst.frc.team1065.robot.RobotMap.Obstacle;
import org.usfirst.frc.team1065.robot.RobotMap.StartingPosition;
import org.usfirst.frc.team1065.robot.RobotMap.TargetGoal;
import org.usfirst.frc.team1065.robot.RobotMap.TargetPosition;
import org.usfirst.frc.team1065.robot.commands.Autonomous.AutoCross;
import org.usfirst.frc.team1065.robot.commands.Autonomous.AutoCrossBack;
import org.usfirst.frc.team1065.robot.commands.Autonomous.AutoCrossDelayAndFollow;
import org.usfirst.frc.team1065.robot.commands.Autonomous.AutoReach;
import org.usfirst.frc.team1065.robot.commands.Autonomous.AutoShoot;
import org.usfirst.frc.team1065.robot.commands.Autonomous.AutoShootDelayAndFollow;
import org.usfirst.frc.team1065.robot.subsystems.CameraSystem;
import org.usfirst.frc.team1065.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1065.robot.subsystems.Intake;
import org.usfirst.frc.team1065.robot.subsystems.Lighting;
import org.usfirst.frc.team1065.robot.subsystems.ObstacleManipulator;
import org.usfirst.frc.team1065.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain drive;
	public static Intake intake;
	public static Shooter shooter;
	public static ObstacleManipulator manipulator;
	public static Lighting lighting;
	public static CameraSystem camera;
	
    public static SendableChooser positionChooser;
    public static SendableChooser obstacleChooser;
    public static SendableChooser commandChooser;
    Command autonomousCommand;

    public void robotInit() {
		oi = new OI();
		drive = new DriveTrain();
		intake = new Intake();
		shooter = new Shooter();
		manipulator = new ObstacleManipulator();
		lighting = new Lighting();
		camera = new CameraSystem();
		
		positionChooser = new SendableChooser();
		positionChooser.addDefault("Far Left", StartingPosition.FarLeft);
		positionChooser.addObject("Left", StartingPosition.Left);
		positionChooser.addObject("Middle", StartingPosition.Middle);
		positionChooser.addObject("Right", StartingPosition.Right);
		positionChooser.addObject("Far Right", StartingPosition.FarRight);
        SmartDashboard.putData("Position Chooser", positionChooser);
		
        obstacleChooser = new SendableChooser();
        obstacleChooser.addDefault("Low Bar", Obstacle.LowBar);
        obstacleChooser.addObject("Portcullis (Lift Gate)", Obstacle.LiftGate);
        obstacleChooser.addObject("Cheval de Frise (Seesaw)", Obstacle.Seesaw);
        obstacleChooser.addObject("Moat", Obstacle.Moat);
        obstacleChooser.addObject("Ramparts", Obstacle.Ramparts);
        obstacleChooser.addObject("Drawbridge", Obstacle.Drawbridge);
        obstacleChooser.addObject("Sally Port (Door)", Obstacle.Door);
        obstacleChooser.addObject("Rock Wall", Obstacle.RockWall);
        obstacleChooser.addObject("Rough Terrain", Obstacle.RoughTerrian);
        SmartDashboard.putData("Obstacle Chooser", obstacleChooser);
		
        commandChooser = new SendableChooser();
        commandChooser.addDefault("Reach", new AutoReach());
        commandChooser.addObject("Cross", new AutoCross());
        commandChooser.addObject("Cross Follow", new AutoCrossDelayAndFollow());
        commandChooser.addObject("Cross Follow Shoot Low Left", new AutoShootDelayAndFollow(TargetGoal.Low, TargetPosition.Left));
        commandChooser.addObject("Cross Follow Shoot high Left", new AutoShootDelayAndFollow(TargetGoal.High, TargetPosition.Left));
        commandChooser.addObject("Cross Back", new AutoCrossBack());
        commandChooser.addObject("Shoot High Left", new AutoShoot(TargetGoal.High, TargetPosition.Left));
        commandChooser.addObject("Shoot High Center", new AutoShoot(TargetGoal.High, TargetPosition.Center));
        commandChooser.addObject("Shoot High Right", new AutoShoot(TargetGoal.High, TargetPosition.Right));
        commandChooser.addObject("Shoot Low Left", new AutoShoot(TargetGoal.Low, TargetPosition.Left));
        commandChooser.addObject("Shoot Low right", new AutoShoot(TargetGoal.Low, TargetPosition.Right));
        SmartDashboard.putData("Command Chooser", commandChooser);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	drive.resetAngle();
    	drive.resetEncoders();
    	
    	if(oi.getShooterOverride()){
    		shooter.disablePIDController();
    	}
    	else{
    		shooter.enablePIDController();
    	}
    	
    	autonomousCommand = (Command)commandChooser.getSelected();
        if (autonomousCommand != null){
        	autonomousCommand.start();
        }
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	if (autonomousCommand != null){
    		autonomousCommand.cancel();
    	}
    	
    	drive.resetAngle();
    }

    public void disabledInit(){

    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
