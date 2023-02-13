package workout;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {

    private String type;
    private int exerciseCount;
    List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if(this.exercises.size() < exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if(exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                this.exercises.remove(exercise);
                return true;
            }
        }

        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if(exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }

        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        if(this.exercises.size() == 0) {
            return null;
        }

        return this.exercises.stream().sorted((f, s) -> s.getBurnedCalories() - f.getBurnedCalories()).collect(Collectors.toList()).get(0);
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("Workout type: ").append(type).append(System.lineSeparator());
        for (Exercise exercise : this.exercises) {
            builder.append(exercise.toString()).append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
