package com.itea.messenger.converter;

import com.itea.messenger.dto.ChatsDto;
import com.itea.messenger.entity.Chats;
import org.springframework.stereotype.Component;

@Component
public class ChatsConverter {
    public Chats chatEntityFromDto(ChatsDto chatsDto) {
        Chats chat = new Chats();
        chat.setId(chatsDto.getChatId());
        chat.setName(chatsDto.getName());
        chat.setDescription(chatsDto.getDescription());
        chat.setChatType(chatsDto.getChatType());
        return chat;
    }

    public ChatsDto dtoFromChatEntity(Chats chat){
        ChatsDto chatsDto = new ChatsDto();
        chatsDto.setChatId(chat.getId());
        chatsDto.setName(chat.getName());
        chatsDto.setDescription(chat.getDescription());
        chatsDto.setChatType(chat.getChatType());
        return chatsDto;
    }
}