package tk.trentoleaf.cineweb.db;

import org.joda.time.DateTime;
import tk.trentoleaf.cineweb.beans.model.*;
import tk.trentoleaf.cineweb.exceptions.db.AnotherFilmScheduledException;
import tk.trentoleaf.cineweb.exceptions.db.PlayGoneException;
import tk.trentoleaf.cineweb.exceptions.db.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ManageData
{

    private UsersDB usersDB = UsersDB.instance();
    private FilmsDB filmsDB = FilmsDB.instance();
    private PlaysDB playsDB = PlaysDB.instance();
    private RoomsDB roomsDB = RoomsDB.instance();
    private BookingsDB bookingsDB = BookingsDB.instance();

    //create admin
    final User a1 = new User(true, Role.ADMIN, "davide.pedranz@gmail.com", "c1n3w3b", "Davide", "Pedranz");
    final User a2 = new User(true, Role.ADMIN, "teo@teos.com", "c1n3w3b", "Matteo", "Zeni");
    final User a3 = new User(true, Role.ADMIN, "willo@willo.com", "c1n3w3b", "Williams", "Rizzi");
    final User a4 = new User(true, Role.ADMIN, "davide@pippo.com", "c1n3w3b", "Andrea", "Zorzi");
    final User a5 = new User(true, Role.ADMIN, "davide@pippo.com", "c1n3w3b", "Samuel", "Giacomelli");

    //create 10 client
    final User u1 = new User(true, Role.CLIENT, "davide.pedranz@gmail.com+", "usr", "Giannino", "Toniazzi");
    final User u2 = new User(true, Role.CLIENT, "davide.pedranz@gmail.com+", "usr", "Truce", "Baldazzi");
    final User u3 = new User(true, Role.CLIENT, "davide.pedranz@gmail.com+", "usr", "Jian", "Toscolino");
    final User u4 = new User(true, Role.CLIENT, "davide.pedranz@gmail.com+", "usr", "Mario", "Rossi");
    final User u5 = new User(true, Role.CLIENT, "davide.pedranz@gmail.com+", "usr", "Geronimo", "Figo");
    final User u6 = new User(true, Role.CLIENT, "davide.pedranz@gmail.com+", "usr", "Nico", "Ustino");
    final User u7 = new User(true, Role.CLIENT, "davide.pedranz@gmail.com+", "usr", "Mandrino", "Asti");
    final User u8 = new User(true, Role.CLIENT, "davide.pedranz@gmail.com+", "usr", "Pacchio", "Romolo");
    final User u9 = new User(true, Role.CLIENT, "davide.pedranz@gmail.com+", "usr", "Destio", "Rummi");
    final User u10 = new User(true, Role.CLIENT, "davide.pedranz@gmail.com+", "usr", "Carlina", "Busti");


    //create 30 film
    // save films
    //final Film ft1 = new Film("Teo alla ricerca della pizza perduta", "fantasy", "http://aaa.com", "http://aaaa.org", "trama moltooo lunga", 120);
    //final Film ft2 = new Film("Marcof e PoketMine", "horror", "http://bbb.com", "http://ccc.org", "trama", 30);
    final Film f1 = new Film("King Kong", "adventure","https://www.youtube.com/watch?v=AYaTCPbYGdk", 187, "In 1933 New York, an overly ambitious movie producer coerces his cast and hired ship crew to travel to mysterious Skull Island, where they encounter Kong, a giant ape who is immediately smitten with leading lady Ann Darrow.", "http://ia.media-imdb.com/images/M/MV5BMTgzODQwNjAwOV5BMl5BanBnXkFtZTcwMDA4MDA0MQ@@._V1_SY317_CR0,0,214,317_AL_.jpg");
    final Film f2 = new Film("Cars", "fantasy","https://www.youtube.com/watch?v=SbXIj2T-_uk", 117, "A hot-shot race-car named Lightning McQueen gets waylaid in Radiator Springs, where he finds the true meaning of friendship and family.", "http://ia.media-imdb.com/images/M/MV5BMTg5NzY0MzA2MV5BMl5BanBnXkFtZTYwNDc3NTc2._V1_SX214_AL_.jpg");
    final Film f3 = new Film("Jurassic World", "horror","https://www.youtube.com/watch?v=RFinNxS5KN4", 124, "Twenty-two years after the events of Jurassic Park, Isla Nublar now features a fully functioning dinosaur theme park, Jurassic World, as originally envisioned by John Hammond. After 10 years of operation and visitor rates declining, in order to fulfill a corporate mandate, a new attraction is created to re-spark visitors'' interest, which backfires horribly.", "http://ia.media-imdb.com/images/M/MV5BMTQ5MTE0MTk3Nl5BMl5BanBnXkFtZTgwMjczMzk2NTE@._V1_SX214_AL_.jpg");
    final Film f4 = new Film("American Sniper", "action","https://www.youtube.com/watch?v=99k3u9ay1gs", 132, "Navy SEAL sniper Chris Kyle''s pinpoint accuracy saves countless lives on the battlefield and turns him into a legend. Back home to his wife and kids after four tours of duty, however, Chris finds that it is the war he can''t leave behind.", "http://ia.media-imdb.com/images/M/MV5BMTkxNzI3ODI4Nl5BMl5BanBnXkFtZTgwMjkwMjY4MjE@._V1_SX214_AL_.jpg");
    final Film f5 = new Film("The Hangover", "action","https://www.youtube.com/watch?v=tcdUhdOlz9M", 100, "Three buddies wake up from a bachelor party in Las Vegas, with no memory of the previous night and the bachelor missing. They make their way around the city in order to find their friend before his wedding.", "http://ia.media-imdb.com/images/M/MV5BMTU1MDA1MTYwMF5BMl5BanBnXkFtZTcwMDcxMzA1Mg@@._V1_SX214_AL_.jpg");
    final Film f6 = new Film("The Godfather", "action","https://www.youtube.com/watch?v=sY1S34973zA", 175, "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", "http://ia.media-imdb.com/images/M/MV5BMjEyMjcyNDI4MF5BMl5BanBnXkFtZTcwMDA5Mzg3OA@@._V1_SX214_AL_.jpg");
    final Film f7 = new Film("Django Unchained", "action","https://www.youtube.com/watch?v=eUdM9vrCbow", 165, "With the help of a German bounty hunter, a freed slave sets out to rescue his wife from a brutal Mississippi plantation owner.", "http://ia.media-imdb.com/images/M/MV5BMjIyNTQ5NjQ1OV5BMl5BanBnXkFtZTcwODg1MDU4OA@@._V1_SX214_AL_.jpg");
    final Film f8 = new Film("Shining", "thriller","https://www.youtube.com/watch?v=S014oGZiSdI", 146, "A family heads to an isolated hotel for the winter where an evil and spiritual presence influences the father into violence, while his psychic son sees horrific forebodings from the past and of the future.", "http://ia.media-imdb.com/images/M/MV5BODMxMjE3NTA4Ml5BMl5BanBnXkFtZTgwNDc0NTIxMDE@._V1_SY317_CR1,0,214,317_AL_.jpg");
    final Film f9 = new Film("Grease", "musical","https://www.youtube.com/watch?v=wzWmxjYNfz4", 110, "Good girl Sandy and greaser Danny fell in love over the summer. But when they unexpectedly discover they're now in the same high school, will they be able to rekindle their romance?", "http://ia.media-imdb.com/images/M/MV5BMTcyMTA5MTY3MF5BMl5BanBnXkFtZTgwMTMwNzAxMDE@._V1_SX214_AL_.jpg");
    final Film f10 = new Film("Avatar", "fantasy","https://www.youtube.com/watch?v=d1_JBMrrYw8", 162, "A Paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home..", "http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SY317_CR0,0,214,317_AL_.jpg");
    final Film f11 = new Film("Fight Club", "action","https://www.youtube.com/watch?v=SUXWAEX2jlg", 139, "An insomniac office worker looking for a way to change his life crosses paths with a devil-may-care soap maker and they form an underground fight club that evolves into something much, much more...", "http://ia.media-imdb.com/images/M/MV5BMjIwNTYzMzE1M15BMl5BanBnXkFtZTcwOTE5Mzg3OA@@._V1__SX629_SY905_.jpg");
    final Film f12 = new Film("Inception", "action","https://www.youtube.com/watch?v=8hP9D6kZseM", 148, "A thief who steals corporate secrets through use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.", "http://ia.media-imdb.com/images/M/MV5BMTMyMzYxMDQ3NV5BMl5BanBnXkFtZTcwNTA1NTcwMw@@._V1__SX629_SY905_.jpg");
    final Film f13 = new Film("Matrix", "action","https://www.youtube.com/watch?v=q_tuIcqX5-g", 136, "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", "http://ia.media-imdb.com/images/M/MV5BMTkxNDYxOTA4M15BMl5BanBnXkFtZTgwNTk0NzQxMTE@._V1__SX629_SY905_.jpg");
    final Film f14 = new Film("Interstellar", "action", "https://www.youtube.com/watch?v=0vxOhd4qlnA",169, "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", "http://ia.media-imdb.com/images/M/MV5BMjIxNTU4MzY4MF5BMl5BanBnXkFtZTgwMzM4ODI3MjE@._V1__SX629_SY905_.jpg");
    final Film f15 = new Film("Edge of Tomorrow", "action","https://www.youtube.com/watch?v=fLe_qO4AE-M", 113, "A military officer is brought into an alien war against an extraterrestrial enemy who can reset the day and know the future. When this officer is enabled with the same power, he teams up with a Special Forces warrior to try and end the war.", "http://ia.media-imdb.com/images/M/MV5BMTc5OTk4MTM3M15BMl5BanBnXkFtZTgwODcxNjg3MDE@._V1__SX629_SY905_.jpg");
    final Film f16 = new Film("The Imitation Game", "action","https://www.youtube.com/watch?v=Sn-7SNrQWMo", 114, "During World War II, mathematician Alan Turing tries to crack the enigma code with help from fellow mathematicians.", "http://ia.media-imdb.com/images/M/MV5BNDkwNTEyMzkzNl5BMl5BanBnXkFtZTgwNTAwNzk3MjE@._V1__SX629_SY905_.jpg");
    final Film f17 = new Film("Guardians of the Galaxy", "action","https://www.youtube.com/watch?v=89yh3vYs-zo", 121, "A group of intergalactic criminals are forced to work together to stop a fanatical warrior from taking control of the universe.", "http://ia.media-imdb.com/images/M/MV5BMTAwMjU5OTgxNjZeQTJeQWpwZ15BbWU4MDUxNDYxODEx._V1__SX629_SY905_.jpg");
    final Film f18 = new Film("The Hunger Games: Mockingjay - Part 1", "action","https://www.youtube.com/watch?v=3PkkHsuMrho", 123, "Katniss Everdeen is in District 13 after she shatters the games forever. Under the leadership of President Coin and the advice of her trusted friends, Katniss spreads her wings as she fights to save Peeta and a nation moved by her courage.", "http://ia.media-imdb.com/images/M/MV5BMTcxNDI2NDAzNl5BMl5BanBnXkFtZTgwODM3MTc2MjE@._V1__SX629_SY905_.jpg");
    final Film f19 = new Film("Captain America: The Winter Soldier", "action","https://www.youtube.com/watch?v=tbayiPxkUMM", 136, "As Steve Rogers struggles to embrace his role in the modern world, he teams up with another super soldier, the black widow, to battle a new threat from old history: an assassin known as the Winter Soldier.", "http://ia.media-imdb.com/images/M/MV5BMzA2NDkwODAwM15BMl5BanBnXkFtZTgwODk5MTgzMTE@._V1__SX629_SY905_.jpg");
    final Film f20 = new Film("The Lego Movie", "fantasy","https://www.youtube.com/watch?v=fZ_JOBCLF-I", 100, "An ordinary Lego construction worker, thought to be the prophesied 'Special', is recruited to join a quest to stop an evil tyrant from gluing the Lego universe into eternal stasis.", "http://ia.media-imdb.com/images/M/MV5BMTg4MDk1ODExN15BMl5BanBnXkFtZTgwNzIyNjg3MDE@._V1__SX629_SY905_.jpg");
    final Film f21 = new Film("Maleficent", "fantasy","https://www.youtube.com/watch?v=w-XO4XiRop0", 97, "A vengeful fairy is driven to curse an infant princess, only to discover that the child may be the one person who can restore peace to their troubled land.", "http://ia.media-imdb.com/images/M/MV5BMTQ1NDk3NTk0MV5BMl5BanBnXkFtZTgwMTk3MDcxMzE@._V1__SX629_SY905_.jpg");
    final Film f22 = new Film("X-Men: Days of Future Past", "fantasy","https://www.youtube.com/watch?v=pK2zYHWDZKo", 132, "The X-Men send Wolverine to the past in a desperate effort to change history and prevent an event that results in doom for both humans and mutants.", "http://ia.media-imdb.com/images/M/MV5BMjEwMDk2NzY4MF5BMl5BanBnXkFtZTgwNTY2OTcwMDE@._V1__SX629_SY905_.jpg");
    final Film f23 = new Film("Dawn of the Planet of the Apes", "action","https://www.youtube.com/watch?v=DpSaTrW4leg", 130, "A growing nation of genetically evolved apes led by Caesar is threatened by a band of human survivors of the devastating virus unleashed a decade earlier.", "http://ia.media-imdb.com/images/M/MV5BMTgwODk3NDc1N15BMl5BanBnXkFtZTgwNTc1NjQwMjE@._V1__SX1626_SY828_.jpg");
    final Film f24 = new Film("Intouchables", "action","https://www.youtube.com/watch?v=34WIbmXkewU", 112, "After he becomes a quadriplegic from a paragliding accident, an aristocrat hires a young man from the projects to be his caregiver.", "http://ia.media-imdb.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1__SX629_SY905_.jpg");
    final Film f25 = new Film("The Wolf of Wall Street", "action","https://www.youtube.com/watch?v=pabEtIERlic", 180, "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", "http://ia.media-imdb.com/images/M/MV5BMjIxMjgxNTk0MF5BMl5BanBnXkFtZTgwNjIyOTg2MDE@._V1__SX629_SY905_.jpg");
    final Film f26 = new Film("Spirited Away", "action","https://www.youtube.com/watch?v=ByXuk9QqQkk", 125, "During her family's move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches, and spirits, and where humans are changed into beasts.", "http://ia.media-imdb.com/images/M/MV5BMjYxMDcyMzIzNl5BMl5BanBnXkFtZTYwNDg2MDU3._V1__SX629_SY905_.jpg");
    final Film f27 = new Film("How to Train Your Dragon 2", "fantasy","https://www.youtube.com/watch?v=Z9a4PvzlqoQ", 102, "When Hiccup and Toothless discover an ice cave that is home to hundreds of new wild dragons and the mysterious Dragon Rider, the two friends find themselves at the center of a battle to protect the peace.", "http://ia.media-imdb.com/images/M/MV5BMzMwMTAwODczN15BMl5BanBnXkFtZTgwMDk2NDA4MTE@._V1__SX629_SY905_.jpg");
    final Film f28 = new Film("Gone Girl", "action","https://www.youtube.com/watch?v=esGn-xKFZdU", 149, "With his wife's disappearance having become the focus of an intense media circus, a man sees the spotlight turned on him when it's suspected that he may not be innocent.", "http://ia.media-imdb.com/images/M/MV5BMTk0MDQ3MzAzOV5BMl5BanBnXkFtZTgwNzU1NzE3MjE@._V1__SX629_SY905_.jpg");
    final Film f29 = new Film("Neighbors", "action","https://www.youtube.com/watch?v=kL5c2szf3E4", 97, "After they are forced to live next to a fraternity house, a couple with a newborn baby do whatever they can to take them down.", "http://ia.media-imdb.com/images/M/MV5BOTQ0OTkzODgyNF5BMl5BanBnXkFtZTgwOTA3OTE4MDE@._V1__SX629_SY905_.jpg");
    final Film f30 = new Film("The Fault in Our Stars", "action","https://www.youtube.com/watch?v=9ItBvH5J6ss", 126, "Two teens, both who have different cancer conditions, fall in love after meeting at a cancer support group.", "http://ia.media-imdb.com/images/M/MV5BMjA4NzkxNzc5Ml5BMl5BanBnXkFtZTgwNzQ3OTMxMTE@._V1__SX629_SY905_.jpg");


    //create rooms
    final Room r1 = roomsDB.createRoom(20, 22);
    final Room r2 = roomsDB.createRoom(20, 15);
    final Room r3 = roomsDB.createRoom(18, 25);
    final Room r4 = roomsDB.createRoom(15, 5);


    public ManageData() throws AnotherFilmScheduledException, UserNotFoundException, PlayGoneException {
        inizializeData();
    }

    private void inizializeData() throws AnotherFilmScheduledException, UserNotFoundException, PlayGoneException {

        //add users
        usersDB.createUser(a1);
        usersDB.createUser(a2);
        usersDB.createUser(a3);
        usersDB.createUser(a4);
        usersDB.createUser(a5);
        usersDB.createUser(u1);
        usersDB.createUser(u2);
        usersDB.createUser(u3);
        usersDB.createUser(u4);
        usersDB.createUser(u5);
        usersDB.createUser(u6);
        usersDB.createUser(u7);
        usersDB.createUser(u8);
        usersDB.createUser(u9);
        usersDB.createUser(u10);
        //add films
        filmsDB.createFilm(f1);
        filmsDB.createFilm(f2);
        filmsDB.createFilm(f3);
        filmsDB.createFilm(f4);
        filmsDB.createFilm(f5);
        filmsDB.createFilm(f6);
        filmsDB.createFilm(f7);
        filmsDB.createFilm(f8);
        filmsDB.createFilm(f9);
        filmsDB.createFilm(f10);
        filmsDB.createFilm(f11);
        filmsDB.createFilm(f12);
        filmsDB.createFilm(f13);
        filmsDB.createFilm(f14);
        filmsDB.createFilm(f15);
        filmsDB.createFilm(f16);
        filmsDB.createFilm(f16);
        filmsDB.createFilm(f17);
        filmsDB.createFilm(f18);
        filmsDB.createFilm(f19);
        filmsDB.createFilm(f20);
        filmsDB.createFilm(f21);
        filmsDB.createFilm(f22);
        filmsDB.createFilm(f23);
        filmsDB.createFilm(f24);
        filmsDB.createFilm(f25);
        filmsDB.createFilm(f26);
        filmsDB.createFilm(f27);
        filmsDB.createFilm(f28);
        filmsDB.createFilm(f29);
        filmsDB.createFilm(f30);

        createPlay(3);

        createAllTicketsForR1();
        //teo buy all seats of room r2 for play 2
        createAllTicketsForR2();

    }

    private void createAllTicketsForR1() throws UserNotFoundException, PlayGoneException {
        // tickets to buy
        final List<Ticket> tickets = new ArrayList<>();
        final Ticket t1 = new Ticket(playsDB.getPlays().get(1), 1, 2, 9.33, "normale");
        final Ticket t2 = new Ticket(playsDB.getPlays().get(1), 1, 3, 8.50, "ridotto");
        final Ticket t3 = new Ticket(playsDB.getPlays().get(1), 1, 4, 8.50, "normale");
        // create a booking for Davide
        bookingsDB.createBooking(a1, tickets);

        final Ticket t4 = new Ticket(playsDB.getPlays().get(1), 4, 10, 8.50, "normale");
        // create a booking for Teo
        bookingsDB.createBooking(a2, tickets);
        final Ticket t5 = new Ticket(playsDB.getPlays().get(1), 5, 6, 8.50, "normale");
        // create a booking for Willi
        bookingsDB.createBooking(a3, tickets);
        final Ticket t6 = new Ticket(playsDB.getPlays().get(1), 6, 4, 8.50, "normale");
        // create a booking for Andrea
        bookingsDB.createBooking(a4, tickets);
        final Ticket t7 = new Ticket(playsDB.getPlays().get(1), 7, 4, 8.50, "normale");
        // create a booking for Sam
        bookingsDB.createBooking(a5, tickets);


    }

    private void createAllTicketsForR2() throws UserNotFoundException, PlayGoneException {
        // tickets to buy
        final List<Ticket> tickets = new ArrayList<>();
        for(int i=0; i< r1.getColumns();i++) {
            for(int j=0; i< r1.getRows();i++) {
                tickets.add(new Ticket(playsDB.getPlays().get(2), i, j, 8.50, "normale"));

            }
        }
        // create a booking
        bookingsDB.createBooking(a2, tickets);

    }

    public void createPlay(int x) throws AnotherFilmScheduledException {
        //create plays
        //final Play p1 = new Play(f1, r2, DateTime.now(), true);
        //final Play p2 = new Play(f2, r2, DateTime.now().plusMinutes(121), false);
        //final Play p3 = new Play(f1, r1, DateTime.now().plusMinutes(2), false);
        //final Play p4 = new Play(f2, r1, DateTime.now().plusMinutes(150), false);

        //    p4.set_3d(true);
        //    p4.setFid(f1.getFid());


        Boolean glasses3D = false;

        List <Film> films = filmsDB.getFilms();
        for(int i=0;i<films.size();i++)
        {
            playsDB.createPlay(new Play(films.get(i),r1,DateTime.now().plusMinutes(i*x), glasses3D));
            glasses3D = !glasses3D;
            playsDB.createPlay(new Play(films.get(i),r2,DateTime.now().plusMinutes(i*x), glasses3D));
            glasses3D = !glasses3D;
            playsDB.createPlay(new Play(films.get(i),r3,DateTime.now().plusMinutes(i*x), glasses3D));
            playsDB.createPlay(new Play(films.get(i),r4,DateTime.now().plusMinutes(i*x), glasses3D));
            glasses3D =! glasses3D;
        }
    }



}