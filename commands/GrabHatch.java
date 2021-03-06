//Open the fingers to hold the hatch.

package org.usfirst.frc6333.DeepSpace.commands;
import org.usfirst.frc6333.DeepSpace.Robot;

import edu.wpi.first.wpilibj.command.Command;
//import org.usfirst.frc6333.DeepSpace.Robot;

/**
 * This Command will grab a Hatch. It has two parts.
 * It must check the status of the LoadStation/Floor Button
 * It will either move forward and expand the fingers to grap a hatch
 * or it will 'bend' down and pick a hatch off the floor
 */
public class GrabHatch extends Command {

    private boolean FingerPID;

    public GrabHatch() {
       
        requires(Robot.fingers_sub);

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        setInterruptible(true);
        
        Robot.fingers_sub.setSetpoint(75000);
        Robot.fingers_sub.enable();
        FingerPID = false;
        Robot.ballFlag = false;

        
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

        if (Math.abs(75000 - Robot.fingers_sub.getEncoder())<15000) {
            Robot.fingers_sub.disable();
            FingerPID = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if (FingerPID) {
            return true;
        } else return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {

        Robot.fingers_sub.disable();
        System.out.print ("Completed GrabHatch Command\n");

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
