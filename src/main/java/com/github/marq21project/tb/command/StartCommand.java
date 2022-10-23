package com.github.marq21project.tb.command;

import com.github.marq21project.tb.repository.TelegramUser;
import com.github.marq21project.tb.service.SendBotMessageService;
import com.github.marq21project.tb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.marq21project.tb.command.CommandUtils.getChatId;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String START_MESSAGE = "Привет. Я TelegramBell-бот. Я помогу тебе быть в курсе происходящего";

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = getChatId(update);

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    telegramUserService.save(user);
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setActive(true);
                    telegramUser.setChatId(chatId);
                    telegramUserService.save(telegramUser);
                });

        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }
}

