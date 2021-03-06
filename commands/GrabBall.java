//Close the fingers arround a ball.

package org.usfirst.frc6333.DeepSpace.commands;
import org.usfirst.frc6333.DeepSpace.Robot;

import edu.wpi.first.wpilibj.command.Command;
//import org.usfirst.frc6333.DeepSpace.Robot;

/**
 * This grabs the ball assuming it is set
 */
public class GrabBall extends Command {

    private int FingerSetpoint = 400000;
    private int WristSetPoint = 140000;
    private int ElbowSetPoint = 525;

    public GrabBall() {
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        setInterruptible(true);
        
        Robot.elbow_sub.setSetpoint(ElbowSetPoint);
        Robot.elbow_sub.enable();

        
    
       // Robot.fingers_sub.setSetpoint(FingerSetpoint);
       // Robot.fingers_sub.enable();
        Robot.ballFlag = true;
    
        /*
       if (Robot.fingers_sub.getEncoder()>FingerSetpoint) { 
           Robot.fingers_sub.moveFingers(0.75);
       } else {
           Robot.fingers_sub.stopFingers();
       }
       */

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        
        
        if (Math.abs(ElbowSetPoint-Robot.elbow_sub.getElbowEncoderCount())< 50) { 
            Robot.wrist_sub.setSetpoint(WristSetPoint);
            Robot.wrist_sub.enable();
            return true;
        } else {
            return false;
        
        }
        /*if (Robot.fingers_sub.getEncoder() < FingerSetpoint) {
            return true;
        }
        else {
            return false;
        }*/
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.fingers_sub.disable();
        Robot.fingers_sub.moveFingers(0);
        Robot.elbow_sub.disable();
        System.out.print("Completed GetBall Command\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
