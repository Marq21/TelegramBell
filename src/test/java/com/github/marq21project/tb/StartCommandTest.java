package com.github.marq21project.tb;

import com.github.marq21project.tb.command.Command;
import com.github.marq21project.tb.command.StartCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.marq21project.tb.command.CommandName.START;
import static com.github.marq21project.tb.command.StartCommand.START_MESSAGE;

@DisplayName("Unit-level testing for StartCommand")
public class StartCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}
