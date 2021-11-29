package rest;

import com.google.gson.Gson;
import dtos.RecipesDTO;
import facades.RecipeFacade;
import utils.EMF_Creator;
import utils.HttpUtils;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

@Path("recipe")
public class RecipeResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static RecipeFacade instance = RecipeFacade.getUserFacade(EMF);

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

    // lav nyt endpoint post, userid

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("weekly/{userName}/{weekNumber}")
    public String saveRecipes(@PathParam("userName") String userName, @PathParam("weekNumber") int weekNumber, String json) throws IOException {
        instance.saveFoodPlanToUser(userName, weekNumber, json);
        return "succes";
    }

}