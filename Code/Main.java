import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import org.omg.CORBA.ARG_IN;

public class Main
{
    static ArrayList<Movie> movies;
    static  ArrayList<User> users;
    static ArrayList<Admin> admins;
   




    public static void main(String arr[]) {
        movies = new ArrayList<>();
        users =  new ArrayList<>();
        admins = new ArrayList<>(); 
        Admin admin = new Admin("SAM","sam@gmail.com","samx");
        User newuser  = new User("SAM","sam@gmail.com","samx");
        users.add(newuser);
        admins.add(admin);
        // admins.add(admin);
        movies.add(new Movie("Lovetoday",2022,"tamil  ","love"));
        movies.add(new Movie("Inception",2022,"tamil  ","action"));
        movies.add(new Movie("Devil  ",2012,"Emglish","horror"));
        movies.add(new Movie("Frozen  ",2020 ,"English","sci-fi"));
        movies.add(new Movie("Kathi  ",2017,"tamil  ","action"));
        movies.add(new Movie("Friends",2014,"English","comedy"));
        
        
        
        Scanner sc = new Scanner(System.in);
        Boolean flag = true;
        while(flag){
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Welcome to MovieReview CLI Application!!!");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Enter 1  Register User \nEnter 2  Login User \nEnter 3  list All Movies \nEnter 4  Admin login \nENTER 5  List all reviews of a movie \nEnter 6 List all reviews given by a User \nEnter 7 List Top N movies");
            int num = sc.nextInt();
            
            
            switch(num)
            {
               
                case 1 :
                        sc.nextLine();
                        System.out.print("Enter your name");
                        final String name = sc.nextLine();
                        System.out.print("Enter your email");

                        final String email = sc.nextLine();
                        System.out.print("Enter your password");
                        final String password = sc.nextLine();
                        
                        final User user = new User(name, email, password);
                        users.add(user);
                        break;
                case 2 :
                        Person p = new Authenticate<User>().auth(users);

                        if(p!=null)
                        {
                            System.out.println("Signed in sucessfully");

                            userDashboard((User)p);
                        }

                        else 
                        {
                            System.out.println("Wrong info"); 
                        }
                        break;
                case 3:
                        listMovie(movies);
                        break;
                
                case 4:
                        Person obj = new Authenticate<Admin>().auth(admins);
                        if(obj!=null)
                        {
                    
                            System.out.println("Signed in sucessfully");

                            adminDashboard((Admin)obj);
                        }

                        else 
                        {
                            System.out.println("Wrong info"); 
                        } 

                        break;
                        
                case 6:    
                        System.out.println("Enter user ID"); 
                        int id = sc.nextInt();
                        User userobj = findUserByID( id);
                        userobj.listReviewsbyUser(userobj);
                        break;
                        
                case 7:
                        System.out.println("Enter Top N"); 
                        int n = sc.nextInt();
                        System.out.println("Enter 1 to sort based on year Enter  2 to sort based on Genre");
                        int f=sc.nextInt();
                        switch(f)
                        {
                            case 1:
                                    System.out.println("Enter the year"); 
                                    int year = sc.nextInt();
                                    sortbasedOnYear(year);
                            case 2:
                                    System.out.println("Enter the genre"); 
                                    String genre = sc.nextLine();
                                    sortbasedOnGenre(genre);
                        }
            }
        }
    }



    public static void listMovie(ArrayList<Movie> movies)
    {   
        System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
        System.out.println("movie.id \t"+"title "+" \t"+" language  \t "+" "+"Year" + "\t"+"isVerifiedByAdmin"+"\t"+"Rating");
        System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
        for(Movie movie : movies )
        {   if(movie.isVerified)
            {
            System.out.println(movie.movieID+" \t"+movie.title+" \t"+movie.language+" \t"+movie.year + "   \t"+movie.isVerified+" \t"+movie.Rating());
            }
        }
 
    }

    private static void adminDashboard(Admin adminobj) 
    { 
      Boolean flag = true;
      while(flag)
      {
        System.out.println("---------------------------------------------------------------"); 
        System.out.println("################  ADMIN DASHBOARD #######################");
        System.out.println("-------------------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("1 Verify Movies \n2 List all Movies\n3 Exit");
        int n = sc.nextInt();

        switch(n)
        {
            case 1:
                System.out.println("Enter movie ID"); 
                int id = sc.nextInt();
                Movie movieobj = findMovieByID( id);
                if(movieobj!=null)
                {
                adminobj.verifyMovie(movieobj);
                }
            case 2:
                System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
                System.out.println("movie.id   "+"isVerifiedByAdmin "+"  "+"title"+"   "+"\t\tlanguage"+" "+"\tYear" + "  "+" "+"Rating");
                System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
                for(Movie movie : movies )
                {
            
                    System.out.println(movie.movieID+"\t\t"+movie.isVerified+" \t"+" \t"+movie.title+" \t"+movie.language+" \t"+movie.year + "  \t"+movie.Rating());
                }

                break;
            case 3:
                 flag=false;
        }
      }

    }

    public static void userDashboard(User userobj)
    {   
        
        Boolean flag =true;
        while(flag)
        {
            System.out.println("---------------------------------------------------------------------------------"); 
            System.out.println("###################   USER DASHBOARD #######################");
            System.out.println("-----------------------------------------------------------------------------");
        
            Scanner sc = new Scanner(System.in);
            System.out.println("1 Add Movie \n2 Add Review \n3 List all Movies\n5 Exit");
            int n = sc.nextInt();   
        switch(n)
        {  
        case 1 : 
            sc.nextLine();
            System.out.print("Enter moviename: ");
            String moviename = sc.nextLine();

            System.out.print("Enter yearOfRelease: ");
            Integer year = sc.nextInt();
            sc.nextLine();  
            System.out.print("Enter language: ");
            String language = sc.nextLine();

            System.out.print("Enter genre");
            String genre = sc.nextLine();

            Movie movie = new Movie(moviename, year,language,genre);
            movies.add(movie);
                break;
        case 2:
            
            System.out.print("Enter the movie id to Review: ");
            int movieid = sc.nextInt();
            System.out.print("Enter Reviewscore out of 10: ");
            int score = sc.nextInt();
            if(score>10)
            {
                System.out.print("Enter value between 0-10: ");
                score = sc.nextInt();
            }

            Movie movieobj = findMovieByID(movieid );

            if(movieobj!=null&&movieobj.year<=Year.now().getValue())
            {
                userobj.addReview(movieobj,new Review(score,userobj,movieobj));
            }
            else
            {
                    System.out.println("Reason for the error");
                    System.out.println("1.User can only review Movies which have been released so far");
                    System.out.println("2.Movie id is wrong");
                
            }
            
            break;
        case 3 :

            listMovie(movies);
            break;
        case 5:
        flag=false;
            break;

        }
    }
    }


    public static Movie findMovieByID(Integer id)
    {


            for(Movie x:movies)
            {
                if(x.movieID==id)
                {
                
                return x;
                }
            }
            System.out.print("Enter correct ID");
            return null; 
    }


    public static User findUserByID(Integer id) 
    {


        for(User x:users)
        {
            if(x.userID==id)
            {
            
            return x;
            }
        }
        System.out.print("Enter correct ID");
        return null; 
    }

    public static void sortbasedOnYear(int year)
    { 
        ArrayList<Movie> moviesort = movies;
        Collections.sort(moviesort, (s1, s2) ->Integer.compare(s2.Rating(), s1.Rating()));

        System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
        System.out.println("movie.id \t"+"title "+" \t"+" language  \t "+" "+"Year" + "\t"+"isVerifiedByAdmin"+"\t"+"Rating");
        System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
        for(Movie movie : moviesort )
        {   if(movie.year==year)
            {
            System.out.println(movie.movieID+" \t"+movie.title+" \t"+movie.language+" \t"+movie.year + "   \t"+movie.isVerified+" \t"+movie.Rating());
            }
        }
    }
    
    public static void sortbasedOnGenre(String genre)
    { 
        ArrayList<Movie> moviesort = movies;
        Collections.sort(moviesort, (s1, s2) ->Integer.compare(s2.Rating(), s1.Rating()));

        System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
        System.out.println("movie.id \t"+"title "+" \t"+" language  \t "+" "+"Year" + "\t"+"isVerifiedByAdmin"+"\t"+"Rating");
        System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
        for(Movie movie : moviesort )
        {   if(movie.genre==genre)
            {
            System.out.println(movie.movieID+" \t"+movie.title+" \t"+movie.language+" \t"+movie.year + "   \t"+movie.isVerified+" \t"+movie.Rating());
            }
        }
    } 
}
