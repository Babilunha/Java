package classes;

public class Customer {

    private String name;

    private PersonalTrainer personalTrainer;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonalTrainer getPersonalTrainer() {
        return personalTrainer;
    }

    /**
     * sets a trainer to the customer and
     * adds the customer to the trainers list
     * @param personalTrainer
     */
    public void setPersonalTrainer(PersonalTrainer personalTrainer) {
        if (personalTrainer != null && this.personalTrainer != personalTrainer) {
            this.personalTrainer = personalTrainer;

            personalTrainer.addCustomer(this);
        }
    }

    /**
     * removes trainer from the cutomer
     * and removes customer from the triners list
     */
    public void removeTrainer() {
        if(this.personalTrainer != null) {
            personalTrainer.removeCustomer(this);
            this.personalTrainer = null;
        }
    }

    @Override
    public String toString() {
        return "" + name;
    }
}
