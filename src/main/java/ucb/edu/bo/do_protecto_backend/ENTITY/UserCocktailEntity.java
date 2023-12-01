package ucb.edu.bo.do_protecto_backend.ENTITY;

import jakarta.persistence.*;

@Entity
@Table(name = "UserCocktails")
public class UserCocktailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_cocktail_id")
    private Long userCocktailId;

    @ManyToOne
    @JoinColumn(name = "Cocktails_cocktail_id", nullable = false)
    private CocktailEntity cocktail;

    @ManyToOne
    @JoinColumn(name = "Users_user_id", nullable = false)
    private UserEntity user;

    public Long getUserCocktailId() {
        return userCocktailId;
    }

    public void setUserCocktailId(Long userCocktailId) {
        this.userCocktailId = userCocktailId;
    }

    public CocktailEntity getCocktail() {
        return cocktail;
    }

    public void setCocktail(CocktailEntity cocktail) {
        this.cocktail = cocktail;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserCocktailEntity [userCocktailId=" + userCocktailId + ", cocktail=" + cocktail + ", user=" + user
                + "]";
    }

    
}