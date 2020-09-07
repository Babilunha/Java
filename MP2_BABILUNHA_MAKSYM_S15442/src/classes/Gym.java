package classes;

import java.util.HashMap;
import java.util.HashSet;


/**
 * with an attribute
 * composition
 * qualified
 */
public class Gym {

    private static int room_id_counter = 1;

    private String name;

    private HashSet<Assignment> assignments_in_gym = new HashSet<>(); // collection for the constraint with an attribute (gym * - * manager)

    private HashSet<Room> all_rooms = new HashSet<>(); //collection for the composition (gym 1 - * room)




    public Gym(String name) {
        this.name = name;
    }

    // ================================================================================
    // mp2 with an attribute
    // ================================================================================

    void addAssignment(Assignment assignment) {
        if (assignment != null && !assignments_in_gym.contains(assignment)) {
            assignments_in_gym.add(assignment);
        } else {
            throw new IllegalArgumentException("assignment was created already");
        }
    }

    void removeAssignment(Assignment assignment) {
        if (assignment != null && assignments_in_gym.contains(assignment)) {
            assignments_in_gym.remove(assignment);
            assignment.removeAssignment();
        }
    }

    public HashSet<Assignment> getAssignments() {
        return new HashSet<Assignment>(assignments_in_gym);
    }

    // ================================================================================
    // mp2 composition (GYM - room)
    // ================================================================================

    public void addRoom(String name) {
        Room room = new Room(name);
        all_rooms.add(room);
    }

    public void removeRoom(int id) {
        Room tempRoom = getRoom(id);
        all_rooms.remove(tempRoom);
        System.out.println(tempRoom + " was removed.");

    }

    public Room getRoom(int id) {
        for (Room r : all_rooms) {
            if (r.getId() == id) {
                return r;
            }
        }
        throw new NullPointerException("there's no room with such id");
    }

    public HashSet<Room> getAll_rooms() {
        return new HashSet<>(all_rooms);
    }


    @Override
    public String toString() {
        return "" + name;
    }


    /**
     * inner class
     * one of the ways to implement composition
     * (Room cannot be created without a Gym)
     */
    public class Room {

        private long id;

        private String name;

        private HashMap<Integer, Equipment> all_equipment = new HashMap<>();

        private Room(String name) {
            this.id = getNewID();
            this.name = name;
        }

        private int getNewID() {
            return Gym.room_id_counter++;
        }

        // ================================================================================
        // mp2 qualified
        // ================================================================================

        public void addEquipment(Equipment equipment) throws Exception {
            if (equipment == null)
                throw new IllegalArgumentException("You can't add null object to the collection.");

            if (!all_equipment.containsKey(equipment.getId())) {
                if(equipment.getRoom() != null) {

                    equipment.getRoom().removeEquipmentPrivate(equipment.getId());
                }
                all_equipment.put(equipment.getId(), equipment);
                equipment.setRoom(this);

            }
        }

        private void removeEquipmentPrivate(int id) {
            this.all_equipment.remove(id);
        }

        public void removeEquipment(Integer key) throws Exception {

            if (findEquipment(key) != null && all_equipment.containsKey(key) &&
            findEquipment(key).getRoom() != null) {
                findEquipment(key).setRoom(null);
                all_equipment.remove(key);
            }
        }

        public Equipment findEquipment(Integer key) throws Exception {

            if (!all_equipment.containsKey(key)) {
                throw new Exception("Unable to find an equipment: " + key.toString());
            }
            return all_equipment.get(key);
        }

        @Override
        public String toString() {
            return "Room{" + "id=" + id + ", name='" + name + '\'' + '}';
        }

        public long getId() {
            return id;
        }

        public HashMap<Integer, Equipment> getAll_equipment() {
            return new HashMap<>(all_equipment);
        }

    }

}
