package iview.wsienski.mvvmtrip.model;

/**
 * Created by Witold Sienski on 09.12.2017.
 */

public class Warrior {

    private final String mName;
    private final WarriorType mType;

    public Warrior(final String name, final WarriorType type) {
        mName = name;
        mType = type;
    }

    public String getName() {
        return mName;
    }

    public WarriorType getmType() {
        return mType;
    }

    public enum WarriorType {
        INFANTRY, CAVALRY, CANNON
    }


}
