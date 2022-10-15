package com.github.marq21project.tb;

import com.github.marq21project.tb.command.Command;
import com.github.marq21project.tb.command.StopCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.marq21project.tb.command.CommandName.STOP;
import static com.github.marq21project.tb.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-test testing for StopCommand")
public class StopCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}
