package org.usfirst.frc.team1065.robot.subsystems;

import org.usfirst.frc.team1065.robot.RobotMap;
import org.usfirst.frc.team1065.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team1065.robot.commands.ManualCameraControl;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;


public class CameraSystem extends Subsystem{

	int currSession;
    int sessionfront;
    int sessionback;
    Image frame;
    USBCamera cam0, cam1;
    
    public CameraSystem(){
    	
    	frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    	//TODO: make it safe in case the cameras are not connected
        sessionfront = NIVision.IMAQdxOpenCamera(RobotMap.FRONT_CAM, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        sessionback = NIVision.IMAQdxOpenCamera(RobotMap.BACK_CAM, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        currSession = sessionfront;
        NIVision.IMAQdxConfigureGrab(currSession);
        //CameraServer.getInstance().setQuality(25);//add and tune
        
        //test and tune
        cam0 = new USBCamera(RobotMap.FRONT_CAM);
        cam1 = new USBCamera(RobotMap.FRONT_CAM);
        
        cam0.setBrightness(0);//tune
        cam0.setExposureAuto();//might want to use manual one
        cam0.setFPS(30);
        cam0.setSize(320, 240);
        cam0.updateSettings();
        
        cam1.setBrightness(0);//tune
        cam1.setExposureAuto();//might want to use manual one
        cam1.setFPS(30);
        cam1.setSize(320, 240);
        cam1.updateSettings();
    }
    
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualCameraControl());	
	}
	
	public void switchCamera(){
		if(currSession == sessionfront){
			switchToBack();
		}
		else{
			switchToFront();
		}
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