package org.usfirst.frc.team1065.robot.subsystems;

import org.usfirst.frc.team1065.robot.RobotMap;
import org.usfirst.frc.team1065.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team1065.robot.commands.SwitchCameraFeed;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;


public class CameraSystem extends Subsystem{

	int currSession;
    int sessionfront;
    int sessionback;
    Image frame;
    
    public CameraSystem(){
    
    	frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        sessionfront = NIVision.IMAQdxOpenCamera(RobotMap.FRONT_CAM, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        sessionback = NIVision.IMAQdxOpenCamera(RobotMap.BACK_CAM, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        currSession = sessionfront;
        NIVision.IMAQdxConfigureGrab(currSession);
    }
    
	protected void initDefaultCommand() {
		setDefaultCommand(new SwitchCameraFeed());
		
	}
	
	public void switchToBack(){
		NIVision.IMAQdxStopAcquisition(currSession);
		currSession = sessionback;
        NIVision.IMAQdxConfigureGrab(currSession);
		}
	
	public void switchToFront(){
		NIVision.IMAQdxStopAcquisition(currSession);
		currSession = sessionfront;
		NIVision.IMAQdxConfigureGrab(currSession);
      	}
	public void sendImageToDS(){
		NIVision.IMAQdxGrab(currSession, frame, 1);
        CameraServer.getInstance().setImage(frame);
	}
	
}