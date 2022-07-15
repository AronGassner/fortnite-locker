package ch.clip.samples.authapi.task;

import ch.clip.samples.authapi.outfit.Outfit;
import ch.clip.samples.authapi.user.AppUser;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;

    @OneToMany(mappedBy="task")
    private List<AppUser> projects = new ArrayList<AppUser>();

    protected Task() { }

    public Task(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

}
