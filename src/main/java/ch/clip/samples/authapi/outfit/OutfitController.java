package ch.clip.samples.authapi.outfit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController für
 * @author luigicavuoti
 * @date 10.07.2020
 *
 */
@RestController
@RequestMapping("/outfits")
public class OutfitController {

	@Autowired
    private OutfitRepository outfitRepository;

    public OutfitController(OutfitRepository outfitRepository) {
        this.outfitRepository = outfitRepository;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<Outfit> getOutfits() {
        return outfitRepository.findAll();  //outfitRepository.findAll();
    }

    /**
     * adds a new outfit to the list - or db
     * @param outfit
     */



    @PutMapping("/{id}")
    public void editOutfit(@PathVariable long id, @RequestBody Outfit outfit) {
        Outfit existingOutfit = outfitRepository.findById(id).get();
        Assert.notNull(existingOutfit, "Outfit not found");
        existingOutfit.setDescription(outfit.getDescription());
        outfitRepository.save(existingOutfit);
    }

    @DeleteMapping("/{id}")
    public void deleteOutfit(@PathVariable long id) {
        Outfit outfitToDel = outfitRepository.findById(id).get();
        outfitRepository.delete(outfitToDel);
    }
}
