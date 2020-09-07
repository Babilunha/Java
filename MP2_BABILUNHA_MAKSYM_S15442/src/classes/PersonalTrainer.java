package classes;

import java.util.HashSet;

public class PersonalTrainer {

    private String name;

    private HashSet<Customer> allCustomers = new HashSet<>(); //collection of all customers associated with this trainer

    public PersonalTrainer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns a copy of the collection, so that it's
     * impossible to modify it
     * @return
     */
    public HashSet<Customer> getAllCustomers() {
        return new HashSet<Customer>(allCustomers);
    }

    /**
     * creating an association between customer and personal trainer, by adding
     * customer to trainer's collection, and by setting the trainer for the customer
     * @param customer
     */
    public void addCustomer(Customer customer) {
        if (customer == null)
            throw new IllegalArgumentException("you can't add null customer to the list");
        if(!allCustomers.contains(customer)) {
            if(customer.getPersonalTrainer() != null) {
                customer.getPersonalTrainer().removeCustomer(customer);
            }
            customer.setPersonalTrainer(this);
            allCustomers.add(customer);
        } else {
            throw new IllegalArgumentException(
                    "you've already added this customer");
        }

    }

    /**
     * removes trainer from the cutomer
     * and removes customer from the triners list
     */
    public void removeCustomer(Customer customer) {
        if (!allCustomers.isEmpty() && allCustomers.contains(customer)
                && customer.getPersonalTrainer() != null) {
            allCustomers.remove(customer);
            customer.removeTrainer();
        }
    }

    @Override
    public String toString() {
        return "" + name;
    }
}
