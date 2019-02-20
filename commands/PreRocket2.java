// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6333.DeepSpace.commands;
import org.usfirst.frc6333.DeepSpace.Robot;
//import org.usfirst.frc6333.DeepSpace.OI;
import edu.wpi.first.wpilibj.command.Command;
//import org.usfirst.frc6333.DeepSpace.Robot;

/**
 * This command will check the state of the Ball/Hatch Button 
 * and either setup to place a ball in the high level of the rocket
 * or setup to place a hatch in the high level of the rocket.
 */
public class PreRocket2 extends Command {

    //Values for Hatch
    private int ElbowSetpoint;
    private int ShoulderSetpoint;
    private int WristSetpoint;

    private boolean ElbowPID;
    private boolean ShoulderPID;

    public PreRocket2() {

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

        // Disable any already running commands
        Robot.elbow_sub.disable();
        Robot.fingers_sub.disable();
        Robot.shoulder_sub.disable();
        //Robot.wrist_sub.disable();

        // First Check state of BallHatchButton
        // Then define the setpoints
        // Then start the movement

        //Button is 'set' for hatch and 'unset' for ball
        if (!Robot.operatorInterface.BallHatchButton.get()) {
            System.out.print("Doing Ball\n");
            ElbowSetpoint = 1080;
            ShoulderSetpoint =-82;
            WristSetpoint =109031;
        
        } else {
            System.out.print("Doing Hatch\n");
            ElbowSetpoint = 1030;
            ShoulderSetpoint = -297;
             WristSetpoint = 105555; 
        }
           /* Order of Arm Operations
        *   1. Adjust Elbow
        *   2. Adjust Wrist
        *   3. Adjust Shoulder
        */
        Robot.wrist_sub.setSetpoint(WristSetpoint);
        Robot.wrist_sub.enable();
        Robot.elbow_sub.setSetpoint(ElbowSetpoint);
        Robot.elbow_sub.enable();
        ElbowPID = false;
        ShoulderPID = false;
        }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        
        if (Math.abs(ShoulderSetpoint-Robot.shoulder_sub.getShoulderEncoderCount())<20) {
            
            Robot.shoulder_sub.disable();
            ShoulderPID = true;
            

            Robot.wrist_sub.setSetpoint(WristSetpoint);
            Robot.wrist_sub.enable();
        
            }
    
        if (Math.abs(ElbowSetpoint-Robot.elbow_sub.getElbowEncoderCount())<20) {
            
            Robot.elbow_sub.disable();
            ElbowPID=true;
            
            Robot.shoulder_sub.setSetpoint(ShoulderSetpoint);
            Robot.shoulder_sub.enable();
            
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
      
        if (ShoulderPID && ElbowPID) {
            
            return true;
        }
        else return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.shoulder_sub.disable();
        Robot.elbow_sub.disable();
        System.out.print("Completed PreRocket2 Command\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}