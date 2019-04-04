package Domain;

import java.util.Objects;

public class Medicine extends Entity {
    private String name, firstName, producer;
    private double price;
    private boolean recipe;

    public Medicine(int id, String name, String firstName, String producer, double price, boolean recipe) {
        super(id);
        this.name = name;
        this.firstName = firstName;
        this.producer = producer;
        this.price = price;
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return name + " " + firstName + " " + producer + " " + price + " " + recipe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getFirstName(), getProducer(), getPrice(), isRecipe());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isRecipe() {
        return recipe;
    }

    public void setRecipe(boolean recipe) {
        this.recipe = recipe;
    }
}


