public class Person {
    
    String name;
    String email;
    private String password;
    Role role;
    static Integer id =0;

    enum Role
    {
        Admin,
        User,
        Critic
    }

    public Person(String name,String email ,String password)
    {
       this.name=name;
       this.email=email;
       this.password=password;
       this.id = id++;

    }   
 
    public boolean verifypassword(String passwordAuth)
    {
           return passwordAuth.equals(password);
    }




}
