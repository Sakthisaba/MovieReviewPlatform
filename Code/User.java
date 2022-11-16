import java.*;
import java.util.ArrayList;
import java.util.HashMap;

public class  User extends Person{
    int userID ;
    static int id =1;
    Review review;
    ArrayList <Review> reviews = new ArrayList<>();
    static Integer reviewCount =0;
    

    public User(String name,String email ,String password)
     {
        super(name, email, password);
        Role role = Role.User;
        this.userID=id++;
       
     }

  

    public void addReview(Movie movie,Review review) 
      {
         ++reviewCount;
      
        if(!this.isReviewedAlready(movie))
        { 
          
          reviews.add(review); 
          movie.reviews.add(review);
          System.out.println("Reviewed SUCCESSFULLY");
        }

        else 
        {
          System.out.println("You already reviewed this movie");
        }
 

      }

      public void listReviewsbyUser(User user)
      {
          for(Review r : reviews)
           {
             System.out.println(user.name + " has " +"reviewed "+r.movie.title+" with "+r.reviewScore +" rating");
           }
     
      }
      
      public Boolean isReviewedAlready(Movie movie)
      {
  
          if (this.reviews != null){
              // if (pastReviews.containsKey(this.user.reviews.rec)){
              //     if ((pastReviews.get(this.user)).equals(movie)){
                     
              //         return true;
              //     }
              // }

              for(Review review:reviews)
              {
                if(review.movie.equals(movie))
                {return true;}
              }
          }
          return false;
          
      
      }


  
}