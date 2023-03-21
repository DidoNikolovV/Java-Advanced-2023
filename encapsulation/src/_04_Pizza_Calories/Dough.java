package _04_Pizza_Calories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if(!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 200) {
            throw new IllegalArgumentException("ough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double caloriesPerGram = 0.0;
        if(flourType.equals("White")) {
            if(bakingTechnique.equals("Crispy")) {
                caloriesPerGram = 1.5 * 0.9;
            } else if(bakingTechnique.equals("Chewy")) {
                caloriesPerGram = 1.5 * 1.1;
            } else if(bakingTechnique.equals("Homemade")) {
                caloriesPerGram = 1.5 * 1.0;
            }
        } else if(flourType.equals("Wholegrain")) {
            if(bakingTechnique.equals("Crispy")) {
                caloriesPerGram = 1.0 * 0.9;
            } else if(bakingTechnique.equals("Chewy")) {
                caloriesPerGram = 1.0 * 1.1;
            } else if(bakingTechnique.equals("Homemade")) {
                caloriesPerGram = 1.0 * 1.0;
            }
        }

        return 2 * weight * caloriesPerGram;
    }
}
