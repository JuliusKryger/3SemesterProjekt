package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import dtos.RecipeDTO;
import dtos.RecipesDTO;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "users")
public class User implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_name", length = 25)
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_pass")
    private String userPass;
    @JoinTable(name = "user_roles", joinColumns = {
            @JoinColumn(name = "user_name", referencedColumnName = "user_name")}, inverseJoinColumns = {
            @JoinColumn(name = "role_name", referencedColumnName = "role_name")})
    @ManyToMany
    private List<Role> roleList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<WeeklyPlan> weeklyPlans = new ArrayList<>();


    public User() {
    }

    public User(String userName, String userPass) {
        this.userName = userName;
        this.userPass = BCrypt.hashpw(userPass, BCrypt.gensalt());
    }
/*
    public void addRecipes(Hobby hobby) {
        if (hobby != null) {
            this.hobbies.add(hobby);
            hobby.getPersons().add(this);
        }
    }

    public void removeRecipes(Hobby hobby) {
        if (hobby != null) {
            this.hobbies.remove(hobby);
            hobby.getPersons().remove(this);
        }
    }

    public List<Hobby> getRecipeList(List<HobbyDTO> hobbyDTOS) {
        ArrayList<Hobby> list = new ArrayList<>();
        for (HobbyDTO h : hobbyDTOS) {
            list.add(new Hobby(h.getName(), h.getWikiLink(), h.getCategory(), h.getType()));
        }
        return list;
    }

    public List<HobbyDTO> getRecipeDTOList(List<Hobby> hobby) {
        ArrayList<HobbyDTO> list = new ArrayList<>();
        for (Hobby h : hobby) {
            list.add(new HobbyDTO(h));
        }
        return list;
    }

    public void replaceRecipes(ArrayList<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

 */

    public List<String> getRolesAsStrings() {
        if (roleList.isEmpty()) {
            return null;
        }
        List<String> rolesAsStrings = new ArrayList<>();
        roleList.forEach((role) -> {
            rolesAsStrings.add(role.getRoleName());
        });
        return rolesAsStrings;
    }

    //TODO Change when password is hashed
    public boolean verifyPassword(String pw) {
        return (BCrypt.checkpw(pw, userPass));
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return this.userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = BCrypt.hashpw(userPass, BCrypt.gensalt());
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public void addRole(Role userRole) {
        roleList.add(userRole);
    }

}
