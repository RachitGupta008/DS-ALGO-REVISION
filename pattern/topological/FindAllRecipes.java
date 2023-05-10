// Refactored using GPT
import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> allRecipes = new ArrayList<>();
        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        Set<String> recipesSet = new HashSet<>(Arrays.asList(recipes));
        Map<String, Integer> recipeIngredientCount = new HashMap<>();
        Map<String, List<String>> ingredientToRecipesMap = new HashMap<>();

        populateMaps(recipes, ingredients, recipeIngredientCount, ingredientToRecipesMap);

        Queue<String> queue = initializeQueue(supplies, recipes, recipeIngredientCount);

        while (!queue.isEmpty()) {
            String current = queue.remove();

            if (recipesSet.contains(current)) {
                allRecipes.add(current);
            }

            List<String> connectedRecipes = ingredientToRecipesMap.getOrDefault(current, new ArrayList<>());

            updateRecipeIngredientCountAndQueue(connectedRecipes, recipeIngredientCount, queue);
        }

        return allRecipes;
    }

    private void populateMaps(String[] recipes, List<List<String>> ingredients, Map<String, Integer> recipeIngredientCount, Map<String, List<String>> ingredientToRecipesMap) {
        for (int i = 0; i < recipes.length; i++) {
            List<String> currentRecipeIngredients = ingredientToRecipesMap.getOrDefault(recipes[i], new ArrayList<>());
            int currentRecipeCount = recipeIngredientCount.getOrDefault(recipes[i], 0);

            for (String ingredient : ingredients.get(i)) {
                List<String> connectedRecipes = ingredientToRecipesMap.getOrDefault(ingredient, new ArrayList<>());
                connectedRecipes.add(recipes[i]);
                ingredientToRecipesMap.put(ingredient, connectedRecipes);

                currentRecipeCount++;
            }

            recipeIngredientCount.put(recipes[i], currentRecipeCount);
            ingredientToRecipesMap.put(recipes[i], currentRecipeIngredients);
        }
    }

    private Queue<String> initializeQueue(String[] supplies, String[] recipes, Map<String, Integer> recipeIngredientCount) {
        Queue<String> queue = new ArrayDeque<>();

        for (String supply : supplies) {
            queue.add(supply);
        }

        for (String recipe : recipes) {
            if (recipeIngredientCount.get(recipe) == 0) {
                queue.add(recipe);
            }
        }

        return queue;
    }

    private void updateRecipeIngredientCountAndQueue(List<String> connectedRecipes, Map<String, Integer> recipeIngredientCount, Queue<String> queue) {
        for (String connectedRecipe : connectedRecipes) {
            int updatedCount = recipeIngredientCount.get(connectedRecipe) - 1;
            recipeIngredientCount.put(connectedRecipe, updatedCount);

            if (updatedCount == 0) {
                queue.add(connectedRecipe);
            }
        }
    }
}
