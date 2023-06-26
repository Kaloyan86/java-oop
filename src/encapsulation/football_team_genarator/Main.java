package encapsulation.football_team_genarator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] tokens = line.split(";");

            String command = tokens[0];
            String teamName = tokens[1];
            try {
                switch (command) {
                    case "Team":
                        teams.putIfAbsent(teamName, new Team(teamName));
                        break;
                    case "Add":
                        if (teams.containsKey(teamName)) {
                            Team team = teams.get(teamName);
                            String playerName = tokens[2];
                            int endurance = Integer.parseInt(tokens[3]);
                            int sprint = Integer.parseInt(tokens[4]);
                            int dribble = Integer.parseInt(tokens[5]);
                            int passing = Integer.parseInt(tokens[6]);
                            int shooting = Integer.parseInt(tokens[7]);

                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            team.addPlayer(player);

                        } else {
                            System.out.printf("Team %s does not exist.\n", teamName);
                        }

                        break;
                    case "Remove":
                        if (teams.containsKey(teamName)) {
                            Team team = teams.get(teamName);
                            String playerName = tokens[2];
                            team.removePlayer(playerName);
                        } else {
                            System.out.printf("Team %s does not exist.\n", teamName);
                        }
                        break;
                    case "Rating":
                        if (teams.containsKey(teamName)) {
                            Team team = teams.get(teamName);
                            System.out.printf("%s - %.0f\n", teamName, team.getRating());
                        } else {
                            System.out.printf("Team %s does not exist.\n", teamName);
                        }
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            line = scanner.nextLine();
        }
    }
}
