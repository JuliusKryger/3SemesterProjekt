package rest;

import com.google.gson.Gson;
import dtos.RecipeDTO;
import dtos.RecipesDTO;
import utils.HttpUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

@Path("recipe")
public class RecipeResource {

    @Context
    private UriInfo context;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("weekly")
    public String getRecipes() throws IOException {

        String APIKEY = "74e9c2acb0284f6eaa9657e397bbcbca";
        Gson gson = new Gson();
        String recipe = HttpUtils.fetchData("https://api.spoonacular.com/recipes/random?number=7&tags=dinner&apiKey=" + APIKEY);

        RecipesDTO recipesDTO = gson.fromJson(recipe, RecipesDTO.class);
        String result = gson.toJson(recipesDTO);
        return result;


        // --- Let this be for now, encase we will need it for later --- RecipeDTO recipeDTO = gson.fromJson(jsonObject.get("recipes"), RecipeDTO.class);
    }

}