package ch.clip.samples.authapi.wrap;

import ch.clip.samples.authapi.outfit.Outfit;
import ch.clip.samples.authapi.user.AppUser;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Wrap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy="wrap", fetch= FetchType.LAZY)
    private  List<Outfit> outfits = new ArrayList<Outfit>();

    public Wrap(String name) {
        this.name = name;
    }

    protected Wrap() { }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  List<Outfit> setOutfit(List<Outfit> outfits){
        return this.outfits = outfits;
    };

}
