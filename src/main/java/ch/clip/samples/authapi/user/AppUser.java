package ch.clip.samples.authapi.user;

import ch.clip.samples.authapi.outfit.Outfit;
import ch.clip.samples.authapi.task.Task;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;


    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task;

    @JsonManagedReference
    @OneToMany(mappedBy="appuser", fetch= FetchType.LAZY)
    private  List<Outfit> outfits = new ArrayList<Outfit>();


    public AppUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    public AppUser(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }


    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ApplicationUser [id=" + id + ", username=" + username + ", password=" + password + "]";
    }

    public  List<Outfit> setOutfit(List<Outfit> outfits){
        return this.outfits = outfits;
    };

}
