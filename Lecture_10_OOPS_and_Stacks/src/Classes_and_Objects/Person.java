package Classes_and_Objects;
//Access specifiers
//default - Can be seen anywhere inside the package.
// Private -  Visible inside the same class
// Public -  Visible everywhere.
// Protected -  To be studied later

public class Person{
       private String name;
       private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
