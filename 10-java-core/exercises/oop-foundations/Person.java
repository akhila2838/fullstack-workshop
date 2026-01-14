public class Person {

    // private fields (encapsulation)
    private String name;
    private int age;
    private String email;

    // no-argument constructor
    public Person() {
    }

    // all-argument constructor
    public Person(String name, int age, String email) {
        this.name = name;
        setAge(age);       // use setter for validation
        setEmail(email);   // use setter for validation
    }

    // getters and setters
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
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Invalid email");
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }

    // main method to demonstrate functionality
    public static void main(String[] args) {
        Person p1 = new Person();

        Person p2 = new Person("John", 25, "john@email.com");
        p2.setAge(30);

        System.out.println(p2);
    }
}
