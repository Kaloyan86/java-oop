package christmasPastryShop.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;

public class BoothRepositoryImpl implements BoothRepository<Booth> {

    private Collection<Booth> booths;

    public BoothRepositoryImpl() {
        this.booths = new ArrayList<>();
    }

    @Override
    public Booth getByNumber(int number) {
        return booths.stream()
                     .filter(b -> b.getBoothNumber() == number)
                     .findFirst()
                     .orElse(null);
    }

    @Override
    public Collection<Booth> getAll() {
        return Collections.unmodifiableCollection(booths);
    }

    @Override
    public void add(Booth booth) {
        booths.add(booth);
    }
}
