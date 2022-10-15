package com.github.marq21project.tb.service;


import com.github.marq21project.tb.bot.ChanelTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Implementation of {@link SendBotMessageService} interface.
 */
@Service
public class SendBotMessageServiceImpl implements SendBotMessageService{

    private final ChanelTelegramBot chanelTelegramBot;

    @Autowired
    public SendBotMessageServiceImpl (ChanelTelegramBot chanelTelegramBot) {
        this.chanelTelegramBot = chanelTelegramBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            chanelTelegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
