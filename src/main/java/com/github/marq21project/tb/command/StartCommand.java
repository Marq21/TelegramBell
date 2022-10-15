package com.github.marq21project.tb.command;

import com.github.marq21project.tb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public final static String START_MESSAGE = "Привет. Я личный бот Николая Ковыршина. Я помогу тебе быть в курсе происходящего";

    public StartCommand (SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
