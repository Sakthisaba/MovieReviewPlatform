import java.util.ArrayList;

public class Movie {
    String title ;
    Integer year;
    String language;
    String genre;
    Integer rating;
    ArrayList <Review> reviews;
    Boolean isVerified=false;
   
     Movie(String title ,Integer year,String language,String genre)
     
    {
        this.title =title;
        this.year=year;
        this.language=language;
        this.genre=genre;
       

    }


    
    
}
