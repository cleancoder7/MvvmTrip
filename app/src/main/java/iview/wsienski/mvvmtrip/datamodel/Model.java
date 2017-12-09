package iview.wsienski.mvvmtrip.datamodel;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import iview.wsienski.mvvmtrip.model.Warrior;

/**
 * Created by Witold Sienski on 09.12.2017.
 */

public class Model implements IModel {

    @Override
    public Observable<List<Warrior>> getWarriorsObservable() {
        return Observable.fromCallable(this::getWarriors);
    }

    @Override
    public List<Warrior> getWarriors() {
        return Arrays
                .asList(
                        new Warrior("Shield Bearer", Warrior.WarriorType.INFANTRY),
                        new Warrior("Hussar", Warrior.WarriorType.CAVALRY),
                        new Warrior("Normal cannon", Warrior.WarriorType.CANNON)
                );
    }

    @Override
    public Observable<String> getWarriorStrength(final Warrior.WarriorType type) {
        switch (type) {
            case INFANTRY:
                return Observable.just("Weak");
            case CAVALRY:
                return Observable.just("Strong");
            case CANNON:
                return Observable.just("Very strong");
            default:
                return Observable.empty();
        }
    }
}
