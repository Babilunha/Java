package classes;

import java.util.HashSet;

/**
 * attribute constraint  (gym * - * manager) (assignment is the middle class)
 *
 */
public class Manager {


    private String name;
    private HashSet<Assignment> assignments_in_manager = new HashSet<>();

    public Manager(String name) {
        this.name = name;
    }

    public HashSet<Assignment> getAssignments_in_manager() {
        return new HashSet<>(assignments_in_manager);
    }

    @Override
    public String toString() {
        return "" + name;
    }

    void addAssignment(Assignment assignment) {
        if (assignment != null && !assignments_in_manager.contains(assignment)) {
            assignments_in_manager.add(assignment);
        } else {
            throw new IllegalArgumentException("assignment was created already");
        }
    }


    void removeAssignment(Assignment assignment) {
        if (assignment != null && assignments_in_manager.contains(assignment)) {
            assignments_in_manager.remove(assignment);
            assignment.removeAssignment();
        }
    }
}
