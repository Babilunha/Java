package main;

import classes.*;

public class Main {

    public static void main(String[] args) {


        // binary (Сustomer * - 1 PersonalTrainer)
        System.out.println("\n" + "//binary" + "\n");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //setting up the objects

        Customer customer1 = new Customer("c1");
        Customer customer2 = new Customer("c2");
        Customer customer3 = new Customer("c3");
        Customer customer4 = new Customer("c4");

        PersonalTrainer personalTrainer1 = new PersonalTrainer("pt1");
        PersonalTrainer personalTrainer2 = new PersonalTrainer("pt2");

        customer1.setPersonalTrainer(personalTrainer1);

        //adding customers to the personal trainer 1
        personalTrainer1.addCustomer(customer2);
        personalTrainer1.addCustomer(customer3);
        personalTrainer1.addCustomer(customer4);

        //adding customers to the personal trainer 2, therefore removing them from trainer 1
        personalTrainer2.addCustomer(customer1);
        personalTrainer2.addCustomer(customer2);

        System.out.println("customers of " + personalTrainer1 + " " + personalTrainer1.getAllCustomers());
        System.out.println("trainer of customer1 " + customer1.getPersonalTrainer());

        System.out.println("customers of " + personalTrainer2 + " " + personalTrainer2.getAllCustomers());


        // attribute (gym * - * manager) (assignment is the middle class)
        System.out.println("\n" + "//attribute" + "\n");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //setting up the objects

        Manager m1 = new Manager("m1");
        Manager m2 = new Manager("m2");
        Manager m3 = new Manager("m3");
        Manager m4 = new Manager("m4");

        Gym g1 = new Gym("g1");
        Gym g2 = new Gym("g2");
        Gym g3 = new Gym("g3");
        Gym g4 = new Gym("g4");

        //creating an assignment object is the only way to assign Gym to Manager
        Assignment a1 = new Assignment(g1, m1);
        Assignment a3 = new Assignment(g1, m3);
        Assignment a4 = new Assignment(g1, m4);

        //if there's need to reassign some manager to another gym, then we have to remove assignment and create a new one
        a1.removeAssignment();
//        a3.removeAssignment();
//        a4.removeAssignment();


        //creating of a new assignment
        Assignment a2 = new Assignment(g2, m2);

        System.out.println("assignments of the manager 1 : " + m1.getAssignments_in_manager());
        System.out.println("assignments of the manager 2: " + m2.getAssignments_in_manager());
        System.out.println("assignments of the manager 3: " + m3.getAssignments_in_manager());

        System.out.println("assignments of the gym 1 : " + g1.getAssignments());
        System.out.println("assignments of the gym 2 : " + g2.getAssignments());
        System.out.println("assignments of the gym 3 : " + g3.getAssignments());


        //3) qualified (room 1 - * equipment)
        System.out.println("\n" + "//qualified" + "\n");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //setting up the objects

        Gym g5 = new Gym("g5");
        Gym g6 = new Gym("g6");

        EquipmentType horizontalBar = new EquipmentTypeHorizontalBar("Gymnastic", 220);

        Equipment e1 = new Equipment("e1", horizontalBar);
        Equipment e2 = new Equipment("e2", horizontalBar);
        Equipment e3 = new Equipment("e3", horizontalBar);

        //creating and adding rooms to the gyms (as part of composition, this is the only way to create rooms)
        g5.addRoom("r1");
        g5.addRoom("r2");


        //adding equipment to the room 1
        try {
            //adding eq to the room 1
            g5.getRoom(1).addEquipment(e1);
            g5.getRoom(1).addEquipment(e2);
            g5.getRoom(1).addEquipment(e3);

            //adding eq to the room2 AND removing from the room1 (IMPORTANT)
            g5.getRoom(2).addEquipment(e1);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Equipment from the room 1: " + g5.getRoom(1).getAll_equipment());
        System.out.println("Equipment from the room 2: " + g5.getRoom(2).getAll_equipment());

        System.out.println("Equipment 1 is in the room: " + e1.getRoom());
        System.out.println("Equipment 2 is in the room: " + e2.getRoom());
        System.out.println("Equipment 3 is in the room: " + e3.getRoom());



        //4) composition (gym 1 - * room)
        System.out.println("\n" + "//composition" + "\n");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //setting up the objects

        Gym g50 = new Gym("g50");
        Gym g60 = new Gym("g60");

        //adding room requires to create a room
        g50.addRoom("r1");
        g50.addRoom("r2");

        //here we add room called "r1" to the gym60
        //but it's not the room that was added to the g50, as you see from it's id
        //(the only thing in common in the name)
        g60.addRoom("r1");

        //removing room with id 3 from g50
        g50.removeRoom(3);

        System.out.println("g50 all rooms: " + g50.getAll_rooms()); //only one room with id 4

        //adding new room
        g50.addRoom("greatRoom");

        System.out.println("g50 all rooms: " + g50.getAll_rooms()); //2 rooms

        System.out.println("g60 all rooms: " + g60.getAll_rooms());


    }
}
