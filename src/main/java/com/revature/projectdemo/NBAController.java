package com.revature.projectdemo;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("players")
public class NBAController {
	public static List<Player> playerCache;
	public NBAController() {
		playerCache = new ArrayList<>();
		playerCache.add(new Player(34, "Lebron", "James"));
		playerCache.add(new Player(29, "James", "Harden"));
		playerCache.add(new Player(31, "Stephen", "Curry"));
    }
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> getAllMovies() {
		return playerCache;
	}

	@GET
	@Path("{age}")
	@Produces(MediaType.APPLICATION_JSON)
	public Player getPlayerByAge(@PathParam("age") int age) {
		return playerCache.get(age-1);
	}
	
	@GET
	@Path("first")
	@Produces(MediaType.APPLICATION_JSON)
	public Player getPlayerByFirst(@QueryParam("firstname") String firstName) {
		for (Player p : playerCache) {
			if (p.getFirstName().equalsIgnoreCase(firstName))
				return p;
		}
		return null;
    }
    
    @GET
	@Path("last")
	@Produces(MediaType.APPLICATION_JSON)
	public Player getPlayerByLast(@QueryParam("lastname") String lastName) {
		for (Player p : playerCache) {
			if (p.getLastName().equalsIgnoreCase(lastName))
				return p;
		}
		return null;
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Player postMovie(Player player) {
		return player;
	}
}


class Player {
    private int age;
    private String firstName;
    private String lastName;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
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

        public Player(int age, String firstName, String lastName) {
            this.age = age;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Player() {
        }

        @Override
        public String toString() {
            return "Player [age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + "]";
        }

        

    
}

