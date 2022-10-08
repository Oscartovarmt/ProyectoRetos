package com.doctors.repository;

import com.doctors.model.MessageModel;
import com.doctors.repository.crudrepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository
{
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<MessageModel> getAllMessages() {
        return (List<MessageModel>) messageCrudRepository.findAll();
    }
    public Optional<MessageModel> getMessage(Integer idMessage) {
        return messageCrudRepository.findById(idMessage);
    }

    public MessageModel saveMessage(MessageModel messageModel){
        return messageCrudRepository.save(messageModel);
    }

    public boolean deleteMessage(Integer idMessage) {
        try {
            messageCrudRepository.deleteById(idMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public MessageModel updateMessage(MessageModel messageModel){
        if (messageModel.getIdMessage() != null) {
            Optional<MessageModel> message = messageCrudRepository.findById(messageModel.getIdMessage());
            if (!message.isEmpty()) {
                if (messageModel.getMessageText() != null) {
                    message.get().setMessageText(messageModel.getMessageText());
                }
                if (messageModel.getDoctor() != null) {
                    message.get().setDoctor(messageModel.getDoctor());
                }
                if (messageModel.getClient() != null) {
                    message.get().setClient(messageModel.getClient());
                }
                messageCrudRepository.save(message.get());
                return message.get();
            } else {
                return messageModel;
            }
        } else {
            return messageModel;
        }

    }
}
