package Domain;

import java.util.Objects;

public class Agenda extends Entity {
    private String denumire, zi, ora;
    private int durata;

    public Agenda(int id, String denumire, String zi, String ora, int durata) {
        super(id);
        this.denumire = denumire;
        this.zi = zi;
        this.ora = ora;
        this.durata = durata;
    }

    @Override
    public String toString() {
        return  denumire + " " + zi + " " + ora + " " + durata;
    }


    @Override
    public int hashCode() {
        return Objects.hash(denumire, zi, ora, durata);
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getZi() {
        return zi;
    }

    public void setZi(String zi) {
        this.zi = zi;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
}
