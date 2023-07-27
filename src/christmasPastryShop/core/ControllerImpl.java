package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class ControllerImpl implements Controller {

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        // TODO
        return null;
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        //TODO
        return null;
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        //TODO
        return null;
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        //TODO
        return null;
    }

    @Override
    public String leaveBooth(int boothNumber) {
        //TODO
        return null;
    }

    @Override
    public String getIncome() {
        //TODO
        return null;
    }
}
