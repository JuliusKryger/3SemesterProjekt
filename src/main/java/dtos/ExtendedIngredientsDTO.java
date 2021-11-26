package dtos;

import java.util.ArrayList;
import java.util.List;

public class ExtendedIngredientsDTO {
    List<ExtendedIngredientDTO> extendedIngredients = new ArrayList<>();

    public ExtendedIngredientsDTO(List<ExtendedIngredientDTO> extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }
}
