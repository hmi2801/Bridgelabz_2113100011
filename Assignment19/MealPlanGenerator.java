    package Bridgelabz_2113100011.Assignment19;

    interface MealPlan {
        void displayMeal();
    }

    class VegetarianMeal implements MealPlan {
        @Override
        public void displayMeal() {
            System.out.println("Vegetarian Meal: Salad, Paneer Curry, Rice");
        }
    }

    class VeganMeal implements MealPlan {
        @Override
        public void displayMeal() {
            System.out.println("Vegan Meal: Tofu Stir-fry, Quinoa, Smoothie");
        }
    }

    class KetoMeal implements MealPlan {
        @Override
        public void displayMeal() {
            System.out.println("Keto Meal: Grilled Chicken, Avocado, Eggs");
        }
    }

    class HighProteinMeal implements MealPlan {
        @Override
        public void displayMeal() {
            System.out.println("High-Protein Meal: Egg Whites, Chicken Breast, Lentils");
        }
    }

    class Meal<T extends MealPlan> {
        private T mealType;

        public Meal(T mealType) {
            this.mealType = mealType;
        }

        public void showMeal() {
            mealType.displayMeal();
        }
    }

    public class MealPlanGenerator {
        public static <T extends MealPlan> void generateMealPlan(T meal) {
            System.out.println("Generating Personalized Meal Plan...");
            meal.displayMeal();
        }

        public static void main(String[] args) {
            VegetarianMeal vegMeal = new VegetarianMeal();
            VeganMeal veganMeal = new VeganMeal();
            KetoMeal ketoMeal = new KetoMeal();
            HighProteinMeal proteinMeal = new HighProteinMeal();

            Meal<VegetarianMeal> meal1 = new Meal<>(vegMeal);
            Meal<VeganMeal> meal2 = new Meal<>(veganMeal);
            Meal<KetoMeal> meal3 = new Meal<>(ketoMeal);
            Meal<HighProteinMeal> meal4 = new Meal<>(proteinMeal);

            generateMealPlan(vegMeal);
            generateMealPlan(veganMeal);
            generateMealPlan(ketoMeal);
            generateMealPlan(proteinMeal);
        }
    }

