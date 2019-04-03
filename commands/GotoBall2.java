// Goto the second ball position(on the ship).

package org.usfirst.frc6333.DeepSpace.commands;
import org.usfirst.frc6333.DeepSpace.Robot;

import edu.wpi.first.wpilibj.command.Command;
//import org.usfirst.frc6333.DeepSpace.Robot;

/**
 *
 */
public class GotoBall2 extends Command {

    private int ElbowSetpoint = 1080;
    private int ShoulderSetpoint = -82;
    private int WristSetpoint = 109031;

    private boolean ElbowPID;
    private boolean ShoulderPID;

    public GotoBall2() { 
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        setInterruptible(true);
        
        // Disable any already running commands
        Robot.elbow_sub.disable();
        Robot.fingers_sub.disable();
        Robot.shoulder_sub.disable();
        Robot.wrist_sub.disable();
 
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
        Robot.wrist_sub.setSetpoint(WristSetpoint);
            Robot.wrist_sub.enable();
        Robot.shoulder_sub.disable();
        Robot.elbow_sub.disable();
        System.out.print("Completed GotoBall2 Command\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
