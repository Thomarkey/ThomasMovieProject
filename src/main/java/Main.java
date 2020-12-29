import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        JSONParser jsonParser = new JSONParser();
        Scanner scannerIn = new Scanner(System.in);

        System.out.println("Which movie would you like to see?");
        String movie = scannerIn.nextLine().toLowerCase();
        String latestMovie = movie.replaceAll("\\s", "");

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

        System.out.println("\n" + movie + " came out in: " + latestMovieYear);
        System.out.println("And is rated: " + latestMovieRating + "!\n");

        System.out.println("What else do you need to know about " + movie + "? \n");

        //+ "\n"
        String exitOption = "Exit menu";
        String plotOption = "What is it about?";
        String lengthOption = "How long is the movie?";
        String castOption = "Who are the main characters?";
        String trailerOption = "Where can I find a trailer";
        String posterOption = "Show me the movie poster!";

        ArrayList<String> optionList = new ArrayList<String>();
        optionList.add(exitOption);
        optionList.add(plotOption);
        optionList.add(lengthOption);
        optionList.add(castOption);
        optionList.add(trailerOption);
        optionList.add(posterOption);

        int index = 0;
        for (String option : optionList) {
            System.out.println(index++ + ": " + option);
        }

        int option = scannerIn.nextInt();
        String selectedOption = "";

        while (optionList.size() > 0 && option != 0) {
            switch (option) {
//                case 0:
//                    option = 0;
//                    System.out.println("Enjoy the movie!");
//                    break;

                case 1:
                    try {
                        selectedOption = optionList.get(1);
                        System.out.println(getRightResponse(selectedOption, latestMovieJson));
                        optionList.remove(1);

                        System.out.println("What else do you need to know about " + movie + "?" + "\n");

                        index = 0;
                        for (String s : optionList) {
                            System.out.println(index++ + ": " + s);
                        }

                        option = scannerIn.nextInt();
//                        selectedOption = "";
                    } catch (Exception e) {
                        System.out.println("Wrong choice, try again:" + "\n");
                        index = 0;
                        for (String s : optionList) {
                            System.out.println(index++ + ": " + s);
                        }
                        option = scannerIn.nextInt();
                    }

                    break;
                case 2:
                    try {
                        selectedOption = optionList.get(2);
                        System.out.println(getRightResponse(selectedOption, latestMovieJson));
                        optionList.remove(2);

                        System.out.println("What else do you need to know about " + movie + "?" + "\n");

                        index = 0;
                        for (String s : optionList) {
                            System.out.println(index++ + ": " + s);
                        }

                        option = scannerIn.nextInt();
//                        selectedOption = "";
                    } catch (Exception e) {
                        System.out.println("Wrong choice, try again:" + "\n");
                        index = 0;
                        for (String s : optionList) {
                            System.out.println(index++ + ": " + s);
                        }
                        option = scannerIn.nextInt();
                    }


                    break;
                case 3:
                    try {
                        selectedOption = optionList.get(3);
                        System.out.println(getRightResponse(selectedOption, latestMovieJson));
                        optionList.remove(3);

                        System.out.println("What else do you need to know about " + movie + "?" + "\n");

                        index = 0;
                        for (String s : optionList) {
                            System.out.println(index++ + ": " + s);
                        }

                        option = scannerIn.nextInt();
//                        selectedOption = "";
                    } catch (Exception e) {
                        System.out.println("Wrong choice, try again:" + "\n");
                        index = 0;
                        for (String s : optionList) {
                            System.out.println(index++ + ": " + s);
                        }
                        option = scannerIn.nextInt();
                    }

                    break;
                case 4:
                    try {
                        selectedOption = optionList.get(4);
                        System.out.println(getRightResponse(selectedOption, latestMovieJson));
                        optionList.remove(4);

                        System.out.println("What else do you need to know about " + movie + "?" + "\n");

                        index = 0;
                        for (String s : optionList) {
                            System.out.println(index++ + ": " + s);
                        }

                        option = scannerIn.nextInt();
//                        selectedOption = "";
                    } catch (Exception e) {
                        System.out.println("Wrong choice, try again:" + "\n");
                        index = 0;
                        for (String s : optionList) {
                            System.out.println(index++ + ": " + s);
                        }
                        option = scannerIn.nextInt();
                    }

                    break;
                case 5:
                    try {
                        selectedOption = optionList.get(5);
                        System.out.println(getRightResponse(selectedOption, latestMovieJson));
                        optionList.remove(5);

                        System.out.println("What else do you need to know about " + movie + "?" + "\n");

                        index = 0;
                        for (String s : optionList) {
                            System.out.println(index++ + ": " + s);
                        }

                        option = scannerIn.nextInt();
//                        selectedOption = "";
                    } catch (Exception e) {
                        System.out.println("Wrong choice, try again:" + "\n");
                        index = 0;
                        for (String s : optionList) {
                            System.out.println(index++ + ": " + s);
                        }
                        option = scannerIn.nextInt();
                    }

                    break;
                default:
                    System.out.println("Wrong choice, try again:" + "\n");
                    index = 0;
                    for (String s : optionList) {
                        System.out.println(index++ + ": " + s);
                    }
                    option = scannerIn.nextInt();
            }
        }

        System.out.println("Enjoy " + movie);

    }

    private static String getRightResponse(String selectedOption, JSONObject latestMovieJson) {
        if (selectedOption.contains("about")) {
            return latestMovieJson.get("plot").toString() + "\n";
        } else if (selectedOption.contains("long")) {
            return latestMovieJson.get("length").toString() + "\n";
        } else if (selectedOption.contains("characters")) {
            return latestMovieJson.get("cast").toString() + "\n";
        } else if (selectedOption.contains("trailer")) {
            return latestMovieJson.get("trailer").toString() + "\n";
        } else if (selectedOption.contains("poster")) {
            return latestMovieJson.get("poster").toString() + "\n";
        }
        return null;
    }


}
