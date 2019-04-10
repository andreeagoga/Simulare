package Service;

import Domain.Agenda;
import Domain.Entity;
import Repository.IRepository;

import java.util.List;

public class AgendaService <T extends Entity> {

    private IRepository<Agenda> repository;

    /**
     *  Instantiates a service
     * @param repository the repository used by the server
     */
    public AgendaService(IRepository<Agenda> repository){
        this.repository = repository;
    }

    /**
     *  Add and update an event to the repository
     * @param id the id of the event
     * @param denumire the name of the event
     * @param zi the day of the event
     * @param ora the start hour of the event
     * @param durata the duration of the event
     */
    public void addAndUpdate(Integer id, String denumire, String zi, String ora, Integer durata) {
        Agenda agenda = repository.findById(id);
        if (agenda != null) {
            if (denumire.isEmpty()) {
                denumire = agenda.getDenumire();
            }
            if (zi.isEmpty()) {
                zi = agenda.getZi();
            }
            if (ora.isEmpty()) {
                ora = agenda.getOra();
            }
            if (durata == 0) {
                durata = agenda.getDurata();
            }
        }
            Agenda agenda1 = new Agenda(id, denumire, zi, ora, durata);
            repository.addAndUpdate(agenda1);
    }


    /**
     * Show all the events
     * @return the list with all the events
     */

    public List<Agenda> getAll(){
        return repository.getAll();
    }

}
