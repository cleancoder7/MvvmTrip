package iview.wsienski.mvvmtrip.datamodel;

import java.util.List;

import io.reactivex.Observable;
import iview.wsienski.mvvmtrip.model.Message;
import iview.wsienski.mvvmtrip.model.User;
import iview.wsienski.mvvmtrip.model.Warrior;

/**
 * Created by Witold Sienski on 09.12.2017.
 */

public interface IRepository {

    Observable<User> getUser();

    Observable<Message> getMessage();

    Observable<List<Warrior>> getWarriorsObservable();

    Observable<String> getWarriorStrength(final Warrior.WarriorType type);

}
