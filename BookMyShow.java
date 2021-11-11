/*
    Requirements -> 
    https://youtu.be/7LaKmNfMCAo
*/

public class BookMyShow {
    List<City> city;

    public List<Movie> getMovies(Date date, String city);

    public List<Cinema> getCinemas(String cityName);
}

public class City {
    Integer CityID;
    String cityName;

    List<Cinema> cinemas;
}

public class Cinemas {
    Integer CinemaID;
    String cinemaName;

    List<Audi> audis;

    public Map<Date, Movies> getMovies(List<Date> dateList);

    public Map<Date, Show> getShows(List<Date> dateList);
}

public class Audi {
    Integer AudiID;
    Integer capacity;

    List<Show> shows;
}

public class Movie {
    String movieName;
    Language language;
    Genre genre;
    String releaseDate;
    Integer MovieID;
}

public class Show {
    Integer ShowID;
    Movie movie;
    Date startTime;
    Integer runningTime;

    Cinema cinema;
    List<Seat> seats;
}

public enum Genre {
    ACTION, THRILLER, ROMANCE
}

public enum Language {
    ENGISH, HINDI, TAMIL
}

public class Seat {
    Integer seatNumber;
    SeatType seatType;
    SeatStatus seatStatus;
    Double price;
}

public enum SeatType {
    NORMAL, VIP, DELUXE, COUPE
}

public enum SeatStatus {
    AVAILABLE, BOOKED, RESERVED, NOT_AVAILABLE
}

public class Search {
    public List<Movie> searchByTitle(String title);

    public List<Movie> searchByLanguage(Language language);

    public List<Movie> searchByGenre(Genre genre);

    public List<Movie> searchByReleaseDate(Date date);

    public List<Movie> searchByCityName(City city);
}

public class User {
    Integer userId;
    Search search;
    Credentials credentials;
    String name;
    String email;
    Address address;
}

public public class Credentials {
    String userName;
    String password;
}

public class Customer extends User {

    public Booking makeBooking(Booking booking);

    public List<Booking> getBooking();

}

public class Admin extends User {

    public boolean addMovie(Movie movie);

    public boolean addShow(Show show);
}

public class Booking {
    Integer BookingID;
    Date bookingDate;
    City city;
    Cinema cinema;
    Audi audi;
    Show show;
    Customer customer;
    BookingStatus bookingStatus;
    List<Seat> seats;
    Payment payment;

    public boolean makePayment(Payment Payment);
}

public class Payment {
    Double amount;
    Date paymentDate;
    Integer transactionID;
    PaymentStatus paymentStatus;
}

public enum BookingStatus {
    REQUESTED, PENDING, CONFIRMED, CANCELLED;
}

public enum PaymentStatus {
    UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED;
}
