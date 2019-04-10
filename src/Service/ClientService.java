package Service;

import Domain.Client;
import Domain.Entity;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientService <T extends Entity> {

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
     * Show all the clients
     * @return the list with all the clients
     */
    public List<Client> getAll(){
        return repository.getAll();
    }

    /**
     * Search the client after the given input
     * @param option the input to search after
     * @return the clients which contain the given input
     */
    public List<Client> searchClient(String option){
        List<Client> clientsFound = new ArrayList<>();
        for(Client client : repository.getAll()){
            System.out.println(client.toString());
            if(client.toString().contains(option))
               clientsFound.add(client);
        }
        return clientsFound;
    }
}
