package classes;

public class EquipmentTypeHorizontalBar extends EquipmentType{

    private int length;

    public EquipmentTypeHorizontalBar(String equipment_type_name, int length) {
        super(equipment_type_name);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
