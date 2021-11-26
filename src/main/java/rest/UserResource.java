package rest;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.User;
import errorhandling.API_Exception;
import facades.UserFacade;
import security.errorhandling.AuthenticationException;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("signup")
public class UserResource {

    private static EntityManagerFactory emf;
    UserFacade FACADE = UserFacade.getUserFacade(emf);
    User user;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response signup(String jsonString) throws API_Exception {
        String username;
        String password;
        try {
            JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
            username = json.get("username").getAsString();
            user.setUserName(username);
            password = json.get("password").getAsString();
           // FACADE.CreateNewUser(user);
        } catch (Exception e) {
            throw new API_Exception("Malformed JSON Suplied", 400, e);
        }

        return null;
    }
}