package christmasPastryShop.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.repositories.interfaces.CocktailRepository;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {

    private Collection<Cocktail> cocktails;

    public CocktailRepositoryImpl() {
        this.cocktails = new ArrayList<>();
    }

    @Override
    public Cocktail getByName(String name) {
        return cocktails.stream()
                        .filter(c -> c.getName().equals(name))
                        .findFirst()
                        .orElse(null);
    }

    @Override
    public Collection<Cocktail> getAll() {
        return Collections.unmodifiableCollection(cocktails);
    }

    @Override
    public void add(Cocktail cocktail) {
        cocktails.add(cocktail);
    }
}
