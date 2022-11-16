public class Admin extends Person {

     Role role = Role.Admin;

     public Admin(String name,String email ,String password)
     {
        super(name, email, password);
       
     }

    
     public void verifyMovie(Movie movie)
     {
        movie.isVerified=true;
     }

    
}
