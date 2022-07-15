package ch.clip.samples.authapi.pickaxe;

import ch.clip.samples.authapi.pickaxe.Pickaxe;
import ch.clip.samples.authapi.pickaxe.PickaxeRepository;
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
@RequestMapping("/pickaxes")
public class PickaxeController {

    @Autowired
    private PickaxeRepository pickaxeRepository;

    public PickaxeController(PickaxeRepository pickaxeRepository) {
        this.pickaxeRepository = pickaxeRepository;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<Pickaxe> getPickaxes() {
        return pickaxeRepository.findAll();  //pickaxeRepository.findAll();
    }


}
