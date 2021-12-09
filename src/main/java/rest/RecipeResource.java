package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.RecipesDTO;
import dtos.UsersDTO;
import entities.User;
import facades.RecipeFacade;
import facades.UserFacade;
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
    private static final RecipeFacade instance = RecipeFacade.getUserFacade(EMF);
    private static final UserFacade FACADE = UserFacade.getUserFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

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

    // Edmin for groceryList
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("foodplan/{userName}/{weekNumber}")
    public String getFoodPlan(@PathParam("userName") String userName, @PathParam("weekNumber") int weekNumber) throws IOException {
        System.out.println(userName);
        System.out.println(weekNumber);
        String wp = instance.getFoodPlan(userName, weekNumber);
        return wp;
    }
    // Endpoint for Admin
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    public String getAllUsers() {
        UsersDTO u = FACADE.getAll();
        return GSON.toJson(u);
    }


}