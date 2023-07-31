package christmasPastryShop.core;

import christmasPastryShop.common.enums.BoothType;
import christmasPastryShop.common.enums.CocktailType;
import christmasPastryShop.common.enums.DelicacyType;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import static christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private final DelicacyRepository<Delicacy> delicacyRepository;
    private final CocktailRepository<Cocktail> cocktailRepository;
    private final BoothRepository<Booth> boothRepository;
    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository,
                          CocktailRepository<Cocktail> cocktailRepository,
                          BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = delicacyRepository.getByName(name);

        if (delicacy != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, delicacy.getClass().getSimpleName(), name));
        }

        DelicacyType delicacyType = DelicacyType.valueOf(type);

        switch (delicacyType) {
            case Gingerbread:
                delicacy = new Gingerbread(name, price);
                break;
            case Stolen:
                delicacy = new Stolen(name, price);
                break;

        }

        delicacyRepository.add(delicacy);

        return String.format(DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {

        Cocktail cocktail = cocktailRepository.getByName(name);

        if (cocktail != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, cocktail.getClass().getSimpleName(), name));
        }

        CocktailType cocktailType = CocktailType.valueOf(type);

        switch (cocktailType) {
            case Hibernation:
                cocktail = new Hibernation(name, size, brand);
                break;
            case MulledWine:
                cocktail = new MulledWine(name, size, brand);
                break;

        }

        cocktailRepository.add(cocktail);

        return String.format(COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = boothRepository.getByNumber(boothNumber);

        if (booth != null) {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
        }

        BoothType boothType = BoothType.valueOf(type);

        switch (boothType) {
            case OpenBooth:
                booth = new OpenBooth(boothNumber, capacity);
                break;
            case PrivateBooth:
                booth = new PrivateBooth(boothNumber, capacity);
                break;
        }

        boothRepository.add(booth);

        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {

        Booth booth = boothRepository.getAll()
                                     .stream()
                                     .filter(b -> !b.isReserved())
                                     .filter(b -> b.getCapacity() >= numberOfPeople)
                                     .findFirst()
                                     .orElse(null);

        String resultMsg = String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);

        if (booth != null) {
            booth.reserve(numberOfPeople);
            resultMsg = String.format(BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
        }

        return resultMsg;
    }

    @Override
    public String leaveBooth(int boothNumber) {

        Booth booth = boothRepository.getByNumber(boothNumber);
        double bill = booth.getBill();
        this.totalIncome += bill;
        booth.clear();

        return String.format(BILL, boothNumber, bill);
    }

    @Override
    public String getIncome() {

        return String.format(TOTAL_INCOME, this.totalIncome);
    }
}
