package com.doctors.repository;

import com.doctors.model.ClientModel;
import com.doctors.repository.crudrepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository
{
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<ClientModel> getAllClients() {
        return (List<ClientModel>) clientCrudRepository.findAll();
    }
    public Optional<ClientModel> getClient(Integer idClient) {
        return clientCrudRepository.findById(idClient);

    }
    public ClientModel saveClient(ClientModel clientModel){
        return clientCrudRepository.save(clientModel);
    }
    public boolean deleteClient(Integer idClient){
        try {
            clientCrudRepository.deleteById(idClient);
            return true;
        }catch (Exception e){
    return false;
    }
}
    public ClientModel updateClient(ClientModel clientModel) {
        if (clientModel.getIdClient() != null) {
            Optional<ClientModel> client = clientCrudRepository.findById(clientModel.getIdClient());
            if (!client.isEmpty()) {
                if (clientModel.getEmail() != null) {
                    client.get().setEmail(clientModel.getEmail());
                }
                if (clientModel.getPassword() != null) {
                    client.get().setPassword(clientModel.getPassword());
                }
                if (clientModel.getName() != null) {
                    client.get().setName(clientModel.getName());
                }
                if (clientModel.getAge() != null) {
                    client.get().setAge(clientModel.getAge());
                }
                if (clientModel.getMessages() != null) {
                    client.get().setMessages(clientModel.getMessages());
                }
                if (clientModel.getReservations() != null) {
                    client.get().setReservations(clientModel.getReservations());
                }
                clientCrudRepository.save(client.get());
                return client.get();
            } else {
                return clientModel;
            }
        } else {
            return clientModel;
        }

    }
}
