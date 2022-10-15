package com.github.marq21project.tb;

import com.github.marq21project.tb.command.Command;
import com.github.marq21project.tb.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.marq21project.tb.command.CommandName.NO;
import static com.github.marq21project.tb.command.NoCommand.NO_MESSAGE;

@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}
