package com.github.marq21project.tb.command;

import com.github.marq21project.tb.repository.TelegramUser;
import com.github.marq21project.tb.service.SendBotMessageService;
import com.github.marq21project.tb.service.TelegramUserService;
import org.springframework.util.CollectionUtils;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.ws.rs.NotFoundException;
import java.util.stream.Collectors;

import static com.github.marq21project.tb.command.CommandUtils.getChatId;

public class ListGroupSubCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public ListGroupSubCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        TelegramUser telegramUser = telegramUserService.findByChatId(getChatId(update))
                .orElseThrow(NotFoundException::new);
        String message;
        if(CollectionUtils.isEmpty(telegramUser.getGroupSubs())) {
            message = "Пока нет подписок на группы. Чтобы добавить подписку напиши /addGroupSub";
        } else {
            String collectedGroups = telegramUser.getGroupSubs().stream()
                    .map(it -> "Группа: " + it.getTitle() + " , ID = " + it.getId() + " \n")
                    .collect(Collectors.joining());
            message =  String.format("Я нашел все подписки на группы: \n\n %s", collectedGroups);
        }


        sendBotMessageService.sendMessage(telegramUser.getChatId(), message);
    }
}

