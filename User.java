import java.*;
import java.util.ArrayList;

public class  User extends Person{
   Review review;
   ArrayList <Review> reviews = new ArrayList<>();
   static Integer reviewCount =0;


  public User(String name,String email ,String password)
   {
        super(name, email, password);
        Role role = Role.User;
   }

  public void addMovie(Movie movie)
   {
    
   }

  public void addReview(Movie movie,Integer reviewScore) 
   {
      reviewCount++;
      if(!review.isReviewedAlready(review,movie)&&movie.isVerified)
      {
        reviews.add(new Review(reviewScore,this)); 

        review.pastReviews.put(this, movie);
      
      }
      else 
      {
          System.out.println("Already reviewed");
      }
 

  }

public void listReviewsbyUser(User user)
 {
     for(int i=0;i<user.reviewCount;i++)
      {
        System.out.println(user.reviews.get(i));
      }

 }


  
}