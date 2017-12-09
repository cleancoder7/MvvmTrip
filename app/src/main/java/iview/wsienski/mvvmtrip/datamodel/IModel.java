package iview.wsienski.mvvmtrip.datamodel;

import java.util.List;

import io.reactivex.Observable;
import iview.wsienski.mvvmtrip.model.Warrior;

/**
 * Created by Witold Sienski on 09.12.2017.
 */

public interface IModel {

    Observable<List<Warrior>> getWarriorsObservable();

    List<Warrior> getWarriors();

    Observable<String> getWarriorStrength(final Warrior.WarriorType type);

}
