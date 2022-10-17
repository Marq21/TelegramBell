package com.github.marq21project.tb.command;

import com.github.marq21project.tb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.marq21project.tb.command.CommandName.*;

/**
 * Help {@link Command}.
 */
public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = "✨<b>Доcтупные команды</b>✨\n\n<b>Начать\\закончить работу с ботом</b>\n" + START.getCommandName() + " - начать работу со мной\n" + STOP.getCommandName() + " - приостановить работу со мной\n\n" + HELP.getCommandName() + " - получить помощь в работe со мной\n";

    public HelpCommand ( SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
