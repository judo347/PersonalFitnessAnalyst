package mk;

import stravaAPI.Strava;

public class Main {

    public static void main(String[] args) {
        Strava.getActivitiesByType(Strava.WorkoutType.RUNNING, 5);
    }
}
