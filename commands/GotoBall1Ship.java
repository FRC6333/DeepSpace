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

import edu.wpi.first.wpilibj.command.Command;
//import org.usfirst.frc6333.DeepSpace.Robot;

/**
 *
 */
public class GotoBall1Ship extends Command {

    private int ElbowSetpoint = 330;
    private int ShoulderSetpoint = -441;
    private int WristSetpoint = 82683;

    private boolean ElbowPID;
    private boolean ShoulderPID;

    public GotoBall1Ship() {

        requires(Robot.elbow_sub);
        requires(Robot.shoulder_sub);
        requires(Robot.wrist_sub);

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

        // Disable any already running commands
        Robot.elbow_sub.disable();
        Robot.fingers_sub.disable();
        Robot.shoulder_sub.disable();
        Robot.wrist_sub.disable();
        
           /* Order of Arm Operations
        *   1. Adjust Elbow
        *   2. Adjust Wrist
        *   3. Adjust Shoulder
        */

        Robot.elbow_sub.setSetpoint(ElbowSetpoint);
        Robot.elbow_sub.enable();
        //Robot.elbow_sub.set_PID_Running(true);
        //Robot.shoulder_sub.set_PID_Running(true);
        ElbowPID = false;
        ShoulderPID = false;
        }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        
        if (Math.abs(ShoulderSetpoint-Robot.shoulder_sub.getShoulderEncoderCount())<100) {
            Robot.shoulder_sub.disable();
            ShoulderPID = true;
            Robot.shoulder_sub.set_PID_Running(false);

            Robot.wrist_sub.setSetpoint(WristSetpoint);
            Robot.wrist_sub.enable();
            
            }
    
        if (Math.abs(ElbowSetpoint-Robot.elbow_sub.getElbowEncoderCount())<50) {
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
        System.out.print("Completed GotoBall1 Command\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
