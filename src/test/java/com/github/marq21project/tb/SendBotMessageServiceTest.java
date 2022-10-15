package com.github.marq21project.tb;

import com.github.marq21project.tb.bot.ChanelTelegramBot;
import com.github.marq21project.tb.service.SendBotMessageService;
import com.github.marq21project.tb.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private ChanelTelegramBot chanelTelegramBot;

    @BeforeEach
    public void init() {
        chanelTelegramBot = Mockito.mock(ChanelTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(chanelTelegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        sendBotMessageService.sendMessage(chatId, message);

        Mockito.verify(chanelTelegramBot).execute(sendMessage);
    }
}
