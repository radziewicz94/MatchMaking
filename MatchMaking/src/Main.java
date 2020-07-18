import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Match> streamMatch = createTeam();
        System.out.println("Wszystkie mecze: ");
        streamMatch.sorted(Comparator.comparingDouble(Match::goalDifference))
                .forEach(System.out::println);

        streamMatch = createTeam();
        List<Match> matches = streamMatch.collect(Collectors.toList());
        System.out.println(">>>\nWszystkie spotkania polski");
        teamScore(matches, Match -> Match.getHostTeamName().equals("Polska") || Match.getGuestsTeamName().equals("Polska"))
                .forEach(System.out::println);

        streamMatch = createTeam();
        long numberOfTeams = streamMatch.distinct()
                .count();
        System.out.println(">>>\nLiczba drużyn biorąca udział w rogrywkach: " + numberOfTeams);

        streamMatch = createTeam();
        int allGoals = streamMatch
                .map(Match -> Match.getGoalHostTeam() + Match.getGoalGuestsTeam())
                .reduce(0, Integer::sum);

        System.out.println(">>>\nLączna liczba goli: " + allGoals);

    }


    private static List<Match> teamScore(List<Match> match, Predicate<Match> predicate){
        List<Match> matchList = new ArrayList<>();
        for(Match match1 : match){
            if(predicate.test(match1))
                matchList.add(match1);
        }
        return matchList;
    }
    private static Stream<Match> createTeam() {
        Stream<Match> list = Stream.of(
                new Match("Polska", "Irlandia", 2, 0),
                new Match("Brazylia", "Francja", 0, 3),
                new Match("Włochy", "Polska", 2, 1),
                new Match("Brazylia", "Argentyna", 2, 2),
                new Match("Anglia", "Niemcy", 1, 2),
                new Match("Anglia", "Francja", 3, 0),
                new Match("Polska", "Portugalia", 1, 0),
                new Match("Brazylia", "Niemcy", 3, 3)
        );
        return list;
    }
}
