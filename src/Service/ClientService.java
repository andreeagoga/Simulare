package Service;

import Domain.Client;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private IRepository<Client> repository;

    /**
     *  Instantiates a service
     * @param repository the repository used by the server
     */
    public ClientService(IRepository<Client> repository) {
        this.repository = repository;
    }

    /**
     * Add and update a client to the repository
     * @param id the client's id to add and update
     * @param name the client's name to add and update
     * @param firstName the client's first name to add and update
     * @param CNP the client's CNP to add and update
     * @param dateOfBirth the client's date of birth to add and update
     * @param dateOfRegistration the client's date of registration to add and update
     */
    public void addAndUpdate(Integer id, String name, String firstName, String CNP, String dateOfBirth, String dateOfRegistration){
        Client client = repository.findById(id);
        if(client != null){
            if (name.isEmpty()){
                name = client.getName();
            }
            if (firstName.isEmpty()) {
                firstName = client.getFirstName();
            }
            if (CNP.isEmpty()){
                CNP = client.getCNP();
            }
            if (dateOfBirth.isEmpty()){
                dateOfBirth = client.getDateOfBirth();
            }

            if (dateOfRegistration.isEmpty()){
                dateOfRegistration = client.getDateOfRegistration();
            }

        }
        Client client1 = new Client(id, name, firstName, CNP, dateOfBirth, dateOfRegistration);
        repository.addAndUpdate(client1);
    }

    /**
     * Remove the client with the given id
     * @param id the id of the client to remove
     */
    public void delete(Integer id) {
        repository.remove(id);
    }

    /**
     * @return the list with all the clients
     */
    public List<Client> getAll(){
        return repository.getAll();
    }

    public List<Client> searchClient(String option){
        int i = 0;
        List<Client> clientsFound = new ArrayList<>();
        for(Client client : repository.getAll()){
            if(client.toString().contains(option))
               clientsFound.add(client);
                i++;
        }
        return clientsFound;
    }
}
