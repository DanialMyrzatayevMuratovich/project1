public class Person {
    private static int idCounter = 1;
    private String name, surname;
    private int age;
    private boolean gender;
    private final int id;

    public Person(String name, String surname, int age, boolean gender) {
        this.id = idCounter++;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String toString() {
        return name + " " + surname + ", " + age + " years old (" + (gender ? "Male" : "Female") + ").";
    }
}
