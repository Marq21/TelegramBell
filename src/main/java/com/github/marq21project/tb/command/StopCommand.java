package com.github.marq21project.tb.command;

import com.github.marq21project.tb.service.SendBotMessageService;
import com.github.marq21project.tb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.marq21project.tb.command.CommandUtils.getChatId;

public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STOP_MESSAGE = "Деактивировал все твои подписки \uD83D\uDE1F.\n" +
            "Ты всегда можешь вернуться нажав /start";


    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {

        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {

        sendBotMessageService.sendMessage(getChatId(update), STOP_MESSAGE);
        telegramUserService.findByChatId(getChatId(update))

                .ifPresent(it -> {
                    it.setActive(false);
                    telegramUserService.save(it);
                });
    }
}
