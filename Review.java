import java.util.HashMap;

public class Review {
    
    User user;
    HashMap <User,Movie> pastReviews ;
    Integer reviewScore;
    
    Review(Integer reviewScore,User  user)
    {
        this.reviewScore=reviewScore;
        this.user = user;
    }

    public Boolean isReviewedAlready(Review review,Movie movie)
    {

        if (pastReviews != null){
            if (pastReviews.containsKey(review.user)){
                if ((pastReviews.get(review.user)).equals(movie)){
                    return true;
                }
            }
        }
        return false;
        
    
    }


    
}
