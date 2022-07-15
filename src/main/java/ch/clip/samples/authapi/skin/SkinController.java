package ch.clip.samples.authapi.skin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RestController für
 * @author luigicavuoti
 * @date 10.07.2020
 *
 */
@RestController
@RequestMapping("/skins")
public class SkinController {

    @Autowired
    private SkinRepository skinRepository;

    public SkinController(SkinRepository skinRepository) {
        this.skinRepository = skinRepository;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<Skin> getSkins() {
        return skinRepository.findAll();  //skinRepository.findAll();
    }


}
