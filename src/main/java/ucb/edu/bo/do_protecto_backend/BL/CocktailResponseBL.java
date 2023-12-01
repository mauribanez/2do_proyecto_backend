package ucb.edu.bo.do_protecto_backend.BL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ucb.edu.bo.do_protecto_backend.DTO.CocktailResponse;

@Service
public class CocktailResponseBL {

    private final String apiUrl = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=";

    @Autowired
    private RestTemplate restTemplate;

    public CocktailResponse getCocktailByName(String cocktailName) {
        String url = apiUrl + cocktailName;
        return restTemplate.getForObject(url, CocktailResponse.class);
    }
}

    
