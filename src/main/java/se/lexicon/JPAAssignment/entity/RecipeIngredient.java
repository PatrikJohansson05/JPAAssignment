package se.lexicon.jpa_assignment.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private se.lexicon.jpa_assignment.entity.Ingredient ingredient;

    private double amount;

    private se.lexicon.jpa_assignment.entity.Measurement measurement;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(referencedColumnName = "jpa_assignment_recipe.recipe.id")
    private se.lexicon.jpa_assignment.entity.Recipe recipe;


    public RecipeIngredient() {
    }

    public RecipeIngredient(se.lexicon.jpa_assignment.entity.Ingredient ingredient, double amount, se.lexicon.jpa_assignment.entity.Measurement measurement, se.lexicon.jpa_assignment.entity.Recipe recipe) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public String getId() {
        return id;
    }

    public se.lexicon.jpa_assignment.entity.Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(se.lexicon.jpa_assignment.entity.Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public se.lexicon.jpa_assignment.entity.Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(se.lexicon.jpa_assignment.entity.Measurement measurement) {
        this.measurement = measurement;
    }

    public se.lexicon.jpa_assignment.entity.Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(se.lexicon.jpa_assignment.entity.Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(ingredient, that.ingredient) &&
                measurement == that.measurement &&
                Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredient, amount, measurement, recipe);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "id='" + id + '\'' +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", recipe=" + recipe +
                '}';
    }
}