package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dtos.RecipeDTO;
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
    public String getRecipe() throws IOException {

        String APIKEY = "74e9c2acb0284f6eaa9657e397bbcbca";
        Gson gson = new Gson();
        String recipe = HttpUtils.fetchData("https://api.spoonacular.com/recipes/random?number=7&tags=dinner&apiKey=" + APIKEY);
        JsonObject jsonObject = new JsonParser().parse(recipe).getAsJsonObject();
        //RecipeDTO recipeDTO = gson.fromJson(jsonObject.get("recipes"), RecipeDTO.class);
        RecipeDTO recipeDTO = gson.fromJson(recipe, RecipeDTO.class);
        String result = gson.toJson(recipeDTO);
        return result;
    }

}