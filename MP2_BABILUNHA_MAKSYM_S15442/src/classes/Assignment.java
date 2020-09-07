package classes;

import java.time.LocalDate;

/**
 * middle class for the attribute constraint
 * simulates many to many between Gym and Manager
 */
public class Assignment {

    private LocalDate assignment_date; //attribute itself is the date when the connection was created (when manager was assigned to that Gym)

    private Manager manager;
    private Gym gym;


    public Assignment(Gym gym, Manager manager) {
        setGym(gym);
        setManager(manager);
        this.assignment_date = LocalDate.now();
    }


    private void setManager(Manager manager) {
        if (manager == null)
            throw new IllegalArgumentException("you can't add null manager to the list");

        this.manager = manager;
        manager.addAssignment(this);

    }

    private void setGym(Gym gym) {
        if (gym == null)
            throw new IllegalArgumentException("you can't add null gym to the list");

        this.gym = gym;
        gym.addAssignment(this);

    }

    public void removeAssignment() {
        if(manager != null && gym != null && manager.getAssignments_in_manager().contains(this) && gym.getAssignments().contains(this)) {
            gym.removeAssignment(this);
            manager.removeAssignment(this);
            this.manager = null;
            this.gym = null;
            System.out.println("assignment removed");
        }
    }

    public Manager getManager() {
        return manager;
    }

    public Gym getGym() {
        return gym;
    }


    @Override
    public String toString() {
        return " " + manager + " + " + gym + " ";
    }

    public LocalDate getAssignment_date() {
        return assignment_date;
    }


}
