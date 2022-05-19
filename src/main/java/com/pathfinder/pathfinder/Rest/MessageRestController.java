package com.pathfinder.pathfinder.Rest;

import com.pathfinder.pathfinder.Entity.Message;
import com.pathfinder.pathfinder.Entity.Response;
import com.pathfinder.pathfinder.Service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Messages")
public class MessageRestController {
    MessageService messageService;

    public MessageRestController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/")
    public Response<Message> saveMessage(@RequestBody Message message){
        try {
            var response = messageService.saveMessage(message);
            return new Response<>(true,"Message saved",response);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),null);
        }
    }

    @GetMapping("/")
    public List<Message> getAllMessage(){
        try {
            var response = messageService.getAllMessages();
            if (response != null)
                return response;
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/{mail}")
    public List<Message> getAllMessagesByUser(@PathVariable String mail){
        try {
            var response = messageService.findMessagesByToUserOrSender(mail);
            if (response != null)
                return response;
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/Sender/{mail}")
    public List<Message> findMessagesBySender(@PathVariable String mail){
        try {
            var response = messageService.findMessagesBySender(mail);
            if (response != null)
                return response;
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/ToUser/{mail}")
    public List<Message> findMessagesByToUser(@PathVariable String mail){
        try {
            var response = messageService.findMessagesByToUser(mail);
            if (response != null)
                return response;
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{messageId}")
    public Response<Boolean> deleteMessage(@PathVariable String messageId){
        try {
            var response = messageService.findMessage(messageId);
            if (response != null)
                messageService.deleteMessage(response);
                return new Response<>(true,"Message deleted",true);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),false);
        }
    }
}
