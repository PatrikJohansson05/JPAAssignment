package se.lexicon.jpa_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_assignment.entity.Recipe;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findAllByName(String string);
    List<Recipe> findAllByRecipeIngredients(String ingredientName);
    List<Recipe> FindAllByRecipeCategories(String categoryName);
}
