package classes;

import java.util.HashSet;

/**
 * qualified
 */
public class Equipment {

    private static HashSet<Equipment> equipmentExtent = new HashSet<>();

    private static int eq_id_counter = 1;
    private int id;
    private String name;
    private Gym.Room room;
    private EquipmentType equipmentType;

    public Equipment(String name, EquipmentType equipmentType) {
        setId();
        setName(name);
        setEquipmentType(equipmentType);
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        if (equipmentType == null)
            throw new RuntimeException("EquipmentType cannot be null.");
        else {
            if (equipmentExtent.stream().anyMatch(e -> e.getEquipmentType() == equipmentType))
                throw new RuntimeException("This EquipmentType already belongs to the other Equipment.");
            else
                this.equipmentType = equipmentType;
        }
    }

    private void setId() {
        id = eq_id_counter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //================================================================================
    //mp2 qualified
    //================================================================================

    public Gym.Room getRoom() {
        return room;
    }

    public void setRoom(Gym.Room room) throws Exception {
        if (this.room != room) {

            this.room = room;
            room.addEquipment(this);
        }

    }


    @Override
    public String toString() {
        return "[" + id + " " + name + "]";
    }
}
