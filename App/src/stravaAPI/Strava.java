package stravaAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Strava {

    /** Needed functionality:
     *      - get all workouts of a specific sport.
     *      - Use GSON so handle json response. */

    /** Examples
     *  get 200 latest activities:
     *      https://www.strava.com/api/v3/athlete/activities?per_page=200&access_token=112233
     * */

    private static final String accessToken = "b6619af8de28762a718479686ac41b8260ffbcc5";

    public enum WorkoutType {
        RUNNING("Run"), HIKING("Hike"); //TODO should be changed to fit the request. and maybe more should be added.

        String stravaName;

        private WorkoutType(String stravaName){
            this.stravaName = stravaName;
        }

        public String getStravaName() {
            return stravaName;
        }
    }

    public static void main(String[] args) {

    }

    /** Takes a workout type
     * @param workoutType the type of workouts you want to get.
     * @return an arrayList with workout Objects */ //TODO THIS OBJECT SHOULD BE MADE //TODO Should have a version with no specific request type aka return all
    public static ArrayList<Object> getActivitiesByType(WorkoutType workoutType, int numberOfWorkouts){

        //Create URL that contains the requested information
        String urlString = "https://www.strava.com/api/v3/athlete/activities?per_page=" + numberOfWorkouts + "&access_token=" + accessToken;

        //Get the content of the URL
        StringBuilder pageContent = doHttpGetRequest(urlString);

        //Convert the stringBuilder to an arrayList of Workout objects
        //TODO HERE!
        System.out.println(pageContent.toString()); //TODO TEMP

        return new ArrayList(); //TODO TEMP
    }

    /** Takes a URL and sends a HTTP GET request, then returns the response. */
    public static StringBuilder doHttpGetRequest(String requestedUrl){

        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(requestedUrl); //MalformedURLException
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //IOException
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;

            while ((line = rd.readLine()) != null) {
                result.append(line);
                //System.out.println(line); //TODO TEMP
            }
            rd.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
