package ch.clip.samples.authapi.wrap;

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
@RequestMapping("/wraps")
public class WrapController {

    @Autowired
    private WrapRepository wrapRepository;

    public WrapController(WrapRepository wrapRepository) {
        this.wrapRepository = wrapRepository;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<Wrap> getWraps() {
        return wrapRepository.findAll();  //wrapRepository.findAll();
    }


}
