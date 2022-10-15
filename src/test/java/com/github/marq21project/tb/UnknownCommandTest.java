package com.github.marq21project.tb;

import com.github.marq21project.tb.command.Command;
import com.github.marq21project.tb.command.UnknownCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.marq21project.tb.command.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-test testing for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return "/kafhjskfka";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
