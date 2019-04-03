//Open the fingers to grab the ball.

package org.usfirst.frc6333.DeepSpace.commands;
import org.usfirst.frc6333.DeepSpace.Robot;

import edu.wpi.first.wpilibj.command.Command;
//import org.usfirst.frc6333.DeepSpace.Robot;

/**
 * This Command positions the arm for pickp of a ball. 
 * Meaning the wrist is pointing down and the shoulder
 * and elbow are set to put the wrist in front of the robot
 */
public class PreBallPickup extends Command {

    private int ElbowSetpoint = 1500;
    private int ShoulderSetpoint = -916;
    private int WristSetpoint = 176000;
    private int FingerSetpoint = 500000;

    private boolean ElbowPID;
    private boolean ShoulderPID;
    private boolean FingerPID;

    public PreBallPickup() {

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        System.out.print("Starting PreBall Pickup Command\n");
        setInterruptible(true);
        
         // Disable any already running commands
         Robot.elbow_sub.disable();
         Robot.fingers_sub.disable();
         Robot.shoulder_sub.disable();
         //Robot.wrist_sub.disable();

         /* Order of Arm Operations
        *   1. Adjust Elbow
        *   2. Adjust Wrist
        *   3. Adjust Shoulder
        */

        //Start fingers
        Robot.fingers_sub.setSetpoint(FingerSetpoint);
        Robot.fingers_sub.enable();

        //Start Wrist
        Robot.wrist_sub.setSetpoint(WristSetpoint);
        Robot.wrist_sub.enable();

        //Start Elbow
        Robot.elbow_sub.setSetpoint(ElbowSetpoint);
        Robot.elbow_sub.enable();
        ElbowPID = false;
        ShoulderPID = false;
        FingerPID = false;
        }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        
        if (Math.abs(ShoulderSetpoint-Robot.shoulder_sub.getShoulderEncoderCount())<20) {
            
            Robot.shoulder_sub.disable();
            ShoulderPID = true;
        
            }
    
        if (Math.abs(ElbowSetpoint-Robot.elbow_sub.getElbowEncoderCount())<20) {
            Robot.elbow_sub.disable();
            ElbowPID=true;
            
            Robot.shoulder_sub.setSetpoint(ShoulderSetpoint);
            Robot.shoulder_sub.enable();
    
        }

        if (Math.abs(FingerSetpoint - Robot.fingers_sub.getEncoder())<20000) {
            Robot.fingers_sub.disable();
            FingerPID = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {

        if (ShoulderPID && ElbowPID && FingerPID) {
            return true;
        }
        else return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.shoulder_sub.disable();
        Robot.elbow_sub.disable();
        Robot.fingers_sub.disable();
        System.out.print("Completed PreBallPickup Command\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {

        end();
    }
}
