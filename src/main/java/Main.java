import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException, ParseException, NoSuchFieldException {
        JSONParser jsonParser = new JSONParser();
        Scanner scannerIn = new Scanner(System.in);

        System.out.println("What movie did u watch?");
        String latestMovie = scannerIn.nextLine().toLowerCase();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb-internet-movie-database-unofficial.p.rapidapi.com/film/" + latestMovie))
                .header("x-rapidapi-key", "2dd66d8d77msh40e7865781b08f3p16b8fdjsn2b04858ec374")
                .header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response);
//        System.out.println(response.body());


        JSONObject latestMovieJson = (JSONObject) jsonParser.parse(response.body());

        String latestMovieYear = latestMovieJson.get("year").toString();
        String latestMovieRating = latestMovieJson.get("rating").toString();

        System.out.println("This movie came out in: " + latestMovieYear);
        System.out.println("And is rated: " + latestMovieRating + "\n");

        System.out.println("What else do you need to know?" + "\n");

        //+ "\n"
        String plotOption = "What is it about?";
        String lengthOption = "How long is the movie?";
        String castOption = "Who are the main characters?";
        String trailerOption = "Where can I find a trailer";
        String posterOption = "Show me the movie poster!";

        ArrayList<String> optionList = new ArrayList<String>();
        optionList.add(plotOption);
        optionList.add(lengthOption);
        optionList.add(castOption);
        optionList.add(trailerOption);
        optionList.add(posterOption);

        int index = 1;
        for (String s : optionList) {
            System.out.println(index++ + ": " + s);
        }

        int option = scannerIn.nextInt();

        switch (option) {
            case 1:
                System.out.println(optionList.get(0));
                optionList.remove(0);
                break;
            case 2:
                System.out.println(optionList.get(1));
                break;
            case 3:
                System.out.println(optionList.get(2));
                break;
            case 4:
                System.out.println(optionList.get(3));
                break;
            case 5:
                System.out.println(optionList.get(4));
                break;
        }


    }

}
