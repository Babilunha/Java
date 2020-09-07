package classes;

public abstract class EquipmentType {


    private int equipment_type_id;
    private String equipment_type_name;

    public EquipmentType(String equipment_type_name) {
        this.setEquipment_type_name(equipment_type_name);
    }

    public int getEquipment_type_id() {
        return equipment_type_id;
    }

    public void setEquipment_type_id(int equipment_type_id) {
        this.equipment_type_id = equipment_type_id;
    }

    public String getEquipment_type_name() {
        return equipment_type_name;
    }

    public void setEquipment_type_name(String equipment_type_name) {
        if (equipment_type_name != null) {
            this.equipment_type_name = equipment_type_name;

        } else throw new RuntimeException("equipment type name cannot be null.");
    }

}
