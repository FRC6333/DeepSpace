// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6333.DeepSpace;

import org.usfirst.frc6333.DeepSpace.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc6333.DeepSpace.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton driveHalfButton;
    public Joystick mainJoy;
    public JoystickButton gotoGroundButton;
    public JoystickButton getBallButton;
    public JoystickButton getHatchGroundButton;
    public JoystickButton getHatchStationButton;
    public JoystickButton gotoHatch1Button;
    public JoystickButton gotoHatch2Button;
    public JoystickButton gotoHatch3Button;
    public JoystickButton releaseHatchButton;
    public JoystickButton gotoBall1ShipButton;
    public JoystickButton gotoBall1CargoshipButton;
    public JoystickButton gotoBall2Button;
    public JoystickButton gotoBall3Button;
    public JoystickButton releaseBallButton;
    public JoystickButton climbButton;
    public Joystick buttonJoy;
    public JoystickButton sholuderUpButton;
    public JoystickButton shoulderDownButton;
    public JoystickButton elbowUpButton;
    public JoystickButton elbowDownButton;
    public JoystickButton wristUpButton;
    public JoystickButton wristDownButton;
    public JoystickButton fingersOpenButton;
    public JoystickButton fingersCloseButton;
    public Joystick debugJoy;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        debugJoy = new Joystick(2);
        fingersCloseButton = new JoystickButton(debugJoy, 1);
        fingersCloseButton.whileHeld(new FingersClose());
        fingersOpenButton = new JoystickButton(debugJoy, 2);
        fingersOpenButton.whileHeld(new FingersOpen());
        wristDownButton = new JoystickButton(debugJoy, 3);
        wristDownButton.whileHeld(new WristDown());
        wristUpButton = new JoystickButton(debugJoy, 4);
        wristUpButton.whileHeld(new WristUp());
        elbowDownButton = new JoystickButton(debugJoy, 5);
        elbowDownButton.whileHeld(new ElbowDown());
        elbowUpButton = new JoystickButton(debugJoy, 6);
        elbowUpButton.whileHeld(new ElbowUp());
        shoulderDownButton = new JoystickButton(debugJoy, 7);
        shoulderDownButton.whileHeld(new ShoulderDown());
        sholuderUpButton = new JoystickButton(debugJoy, 8);
        sholuderUpButton.whileHeld(new ShoulderUp());
        
        buttonJoy = new Joystick(1);
        climbButton = new JoystickButton(buttonJoy, 14);
        climbButton.whenPressed(new Climb());
        releaseBallButton = new JoystickButton(buttonJoy, 13);
        releaseBallButton.whenPressed(new ReleaseBall());
        gotoBall3Button = new JoystickButton(buttonJoy, 12);
        gotoBall3Button.whenPressed(new GotoBall3());
        gotoBall2Button = new JoystickButton(buttonJoy, 11);
        gotoBall2Button.whenPressed(new GotoBall2());
        gotoBall1CargoshipButton = new JoystickButton(buttonJoy, 10);
        gotoBall1CargoshipButton.whenPressed(new GotoBall1Cargoship());
        gotoBall1ShipButton = new JoystickButton(buttonJoy, 9);
        gotoBall1ShipButton.whenPressed(new GotoBall1Ship());
        releaseHatchButton = new JoystickButton(buttonJoy, 8);
        releaseHatchButton.whenPressed(new ReleaseHatch());
        gotoHatch3Button = new JoystickButton(buttonJoy, 7);
        gotoHatch3Button.whenPressed(new GotoHatch3());
        gotoHatch2Button = new JoystickButton(buttonJoy, 6);
        gotoHatch2Button.whenPressed(new GotoHatch2());
        gotoHatch1Button = new JoystickButton(buttonJoy, 5);
        gotoHatch1Button.whenPressed(new GotoHatch1());
        getHatchStationButton = new JoystickButton(buttonJoy, 4);
        getHatchStationButton.whenPressed(new GetHatchStation());
        getHatchGroundButton = new JoystickButton(buttonJoy, 3);
        getHatchGroundButton.whenPressed(new GetHatchGround());
        getBallButton = new JoystickButton(buttonJoy, 2);
        getBallButton.whenPressed(new GetBall());
        gotoGroundButton = new JoystickButton(buttonJoy, 1);
        gotoGroundButton.whenPressed(new GotoGround());
        
        mainJoy = new Joystick(0);
        driveHalfButton = new JoystickButton(mainJoy, 1);
        driveHalfButton.whileHeld(new DriveHalf());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("GotoGround", new GotoGround());
        SmartDashboard.putData("GetBall", new GetBall());
        SmartDashboard.putData("GetHatchGround", new GetHatchGround());
        SmartDashboard.putData("GetHatchStation", new GetHatchStation());
        SmartDashboard.putData("GotoHatch1", new GotoHatch1());
        SmartDashboard.putData("GotoHatch2", new GotoHatch2());
        SmartDashboard.putData("GotoHatch3", new GotoHatch3());
        SmartDashboard.putData("ReleaseHatch", new ReleaseHatch());
        SmartDashboard.putData("GotoBall1Ship", new GotoBall1Ship());
        SmartDashboard.putData("GotoBall1Cargoship", new GotoBall1Cargoship());
        SmartDashboard.putData("GotoBall2", new GotoBall2());
        SmartDashboard.putData("GotoBall3", new GotoBall3());
        SmartDashboard.putData("ReleaseBall", new ReleaseBall());
        SmartDashboard.putData("Climb", new Climb());
        SmartDashboard.putData("DriveWithJoystick", new DriveWithJoystick());
        SmartDashboard.putData("DriveHalf", new DriveHalf());
        SmartDashboard.putData("ShoulderUp", new ShoulderUp());
        SmartDashboard.putData("ShoulderDown", new ShoulderDown());
        SmartDashboard.putData("ElbowUp", new ElbowUp());
        SmartDashboard.putData("ElbowDown", new ElbowDown());
        SmartDashboard.putData("WristUp", new WristUp());
        SmartDashboard.putData("WristDown", new WristDown());
        SmartDashboard.putData("FingersOpen", new FingersOpen());
        SmartDashboard.putData("FingersClose", new FingersClose());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getMainJoy() {
        return mainJoy;
    }

    public Joystick getButtonJoy() {
        return buttonJoy;
    }

    public Joystick getDebugJoy() {
        return debugJoy;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

