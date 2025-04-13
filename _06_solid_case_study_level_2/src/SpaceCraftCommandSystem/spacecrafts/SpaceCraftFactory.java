package SpaceCraftCommandSystem.spacecrafts;

import SpaceCraftCommandSystem.SpaceCraftType;

public class SpaceCraftFactory {
    private static ISpaceCraft spaceCraft;

    public static ISpaceCraft create (SpaceCraftType type) {
        switch (type){
            case ROVER -> {
                spaceCraft =  new Rover();
            }
            case LANDER -> {
                spaceCraft = new Lander();
            }
            case SATELLITE -> {
                spaceCraft = new Satellite();
            }
        }

        return spaceCraft;
    }
}
