import java.time.LocalDateTime;

public class Movie {
    String name;
    double score;
    String actor;
    LocalDateTime playtime;

    public Movie(String name, double score, String actor, LocalDateTime playtime){
        this.name = name;
        this.score = score;
        this.actor = actor;
        this.playtime = playtime;
    }

    @Override
    public String toString(){
        return name + " " + score + " " + actor + " " + playtime;
    }
}
