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
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc6333.DeepSpace.Robot;

/**
 *
 */
public class Startup extends Command {

    
    public Startup() {
        
        requires(Robot.shoulder_sub);
        requires(Robot.elbow_sub);
        requires(Robot.wrist_sub);
        requires(Robot.fingers_sub);

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.elbow_sub.disable();
        Robot.wrist_sub.disable();
        Robot.shoulder_sub.disable();
        Robot.fingers_sub.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //while the wrist insn't at the stop move it back
        while (Robot.wrist_sub.getWristStop()) {
            Robot.wrist_sub.moveWrist(-0.5);
            SmartDashboard.putBoolean("Wrist Stop", Robot.wrist_sub.getWristStop());
        }
        Robot.wrist_sub.stopWrist();
        Robot.wrist_sub.ResetWrist();
        //while the fingers aren't at the stop, move them together
        while (Robot.fingers_sub.getFingerStop()){
            Robot.fingers_sub.moveFingers(0.6);
        }
        Robot.fingers_sub.stopFingers();
        Robot.fingers_sub.ResetFingers();
       
        //while the shoulder isnt at the stop move it back
        while (Robot.shoulder_sub.getShoulderStop()){
            Robot.shoulder_sub.moveShoulder(0.75);
        }
        Robot.shoulder_sub.stopShoulder();
        Robot.shoulder_sub.ResetShoulder();
        //while the elbow isnt at the stop move it down
        while (Robot.elbow_sub.getElbowStop()){
            Robot.elbow_sub.moveElbow(-0.5);
        }
        Robot.elbow_sub.stopElbow();
        Robot.elbow_sub.ResetElbow();
        
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if(!Robot.elbow_sub.getElbowStop()){
            
            Robot.shoulder_sub.ResetShoulder();
            Robot.elbow_sub.ResetElbow();
            Robot.wrist_sub.ResetWrist();
            Robot.fingers_sub.ResetFingers();
            return true;
        }
        else{
            return false;
        }
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        System.out.print("Completed Startup Command\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
