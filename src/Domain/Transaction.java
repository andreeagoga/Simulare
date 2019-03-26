package Domain;

import java.util.Objects;

public class Transaction extends Entity{
    private int idMedicine, idClientCard, numberMedicine;
    private String date, hour;

    public Transaction(int id, int idMedicine, int idClientCard, int numberMedicine, String date, String hour) {
        super(id);
        this.idMedicine = idMedicine;
        this.idClientCard = idClientCard;
        this.numberMedicine = numberMedicine;
        this.date = date;
        this.hour = hour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIdMedicine(), getIdClientCard(), getNumberMedicine(), getDate(), getHour());
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "idMedicine=" + idMedicine +
                ", idClientCard=" + idClientCard +
                ", numberMedicine=" + numberMedicine +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                '}';
    }

    public int getIdMedicine() {
        return idMedicine;
    }

    public void setIdMedicine(int idMedicine) {
        this.idMedicine = idMedicine;
    }

    public int getIdClientCard() {
        return idClientCard;
    }

    public void setIdClientCard(int idClientCard) {
        this.idClientCard = idClientCard;
    }

    public int getNumberMedicine() {
        return numberMedicine;
    }

    public void setNumberMedicine(int numberMedicine) {
        this.numberMedicine = numberMedicine;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
