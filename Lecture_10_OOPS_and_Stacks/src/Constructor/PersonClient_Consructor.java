package Constructor;

public class PersonClient_Consructor{
    public static void main(String[] args){
        PersonC p1 = new PersonC();
        PersonC p2 = new PersonC();
        PersonC p3 = new PersonC(25);
        PersonC p4 = new PersonC("Yanendra Jha", 20);

        // Persona one , Default Constructor, Default value.
        System.out.println(p1.getName());
        System.out.println(p1.getAge());

        // Person 2, Default constructor, value added by getter & setter.
        p2.setName("Yanendnra");
        p2.setAge(22);

        System.out.println(p2.getName());
        System.out.println(p2.getAge());

        // Person 3, 1 params Constructor, Age added by constructor.
        System.out.println(p3.getAge());
        System.out.println(p3.getName());

        //Person 4, 2 params Constructor, Age & name added by constructor.
        System.out.println(p4.getAge());
        System.out.println(p4.getName());

    }
}
