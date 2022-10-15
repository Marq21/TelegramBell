package com.github.marq21project.tb;

import com.github.marq21project.tb.command.Command;
import com.github.marq21project.tb.command.CommandContainer;
import com.github.marq21project.tb.command.CommandName;
import com.github.marq21project.tb.command.UnknownCommand;
import com.github.marq21project.tb.service.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init(){
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService);
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });
    }

    @Test
    public void shouldReturnUnknownCommand() {
        String unknown = "/kfjjkafs";

        Command command = commandContainer.retrieveCommand(unknown);

        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}
