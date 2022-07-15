package ch.clip.samples.authapi.skin;

import ch.clip.samples.authapi.outfit.Outfit;
import ch.clip.samples.authapi.user.AppUser;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy="skin", fetch= FetchType.LAZY)
    private  List<Outfit> outfits = new ArrayList<Outfit>();

    protected Skin() { }

    public Skin(String name) {
        this.name = name;
    }

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
