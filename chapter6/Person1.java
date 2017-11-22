package chapter6;

class Name
{
    private String firstName;
    private String lastName;
    public Name(){};
    public Name(String firstName,String lastName)
    {
        this.firstName=firstName;
        this.lastName=lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

public class Person1
{
    private final Name name;
    public Person1(Name name)
    {
        this.name=new Name(name.getFirstName(),name.getLastName());
    }
    public Name getName()
    {
        return new Name(name.getFirstName(),name.getLastName());
    }
    public static void main(String[] args)
    {
        Name n=new Name("wukong","sun");
        Person1 p=new Person1(n);
        System.out.println(p.getName().getFirstName());
        n.setFirstName("bajie");
        System.out.println(p.getName().getFirstName());

    }
}
