package ucb.edu.bo.do_protecto_backend.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.edu.bo.do_protecto_backend.BL.CocktailResponseBL;
import ucb.edu.bo.do_protecto_backend.DTO.CocktailResponse;

@RestController
@RequestMapping("/cocktails")

public class CocktailResponseAPI {
    @Autowired
    private CocktailResponseBL cocktailService;

    @GetMapping("/{cocktailName}")
    public CocktailResponse getCocktail(@PathVariable String cocktailName) {
        return cocktailService.getCocktailByName(cocktailName);
    }
}


