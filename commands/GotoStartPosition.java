//Goto the "start" position.

package org.usfirst.frc6333.DeepSpace.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc6333.DeepSpace.Robot;

/**
 * This command moves all arms until the switchs are closed
 * once all switches are closed it resets the encoders
 */
public class GotoStartPosition extends Command {
    
    public GotoStartPosition() {        
        requires(Robot.shoulder_sub);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        setInterruptible(true);
        

        Robot.shoulder_sub.setSetpoint(-484.0);
        Robot.fingers_sub.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

     
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if (Math.abs(-484-Robot.shoulder_sub.getShoulderEncoderCount())<50) {
            Robot.shoulder_sub.disable();
            return true;
        
        } else if (timeSinceInitialized() > 2.0) {
            return true;
        }
        else{
            return false;
        }
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.shoulder_sub.disable();

        System.out.print("Completed GotoStartPosition Command\n");
    }


    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
