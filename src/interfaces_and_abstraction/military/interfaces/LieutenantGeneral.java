package interfaces_and_abstraction.military.interfaces;

import java.util.Collection;

public interface LieutenantGeneral {

    Collection<Private> getPrivates();
    void addPrivate(Private priv);
}
