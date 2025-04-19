package _03_MultiPlayerGameEventSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameEventDispatcher {

    private final Map<String, ArrayList<GameEventListener>> listeners = new HashMap<>();
    public void addListener (String key, GameEventListener listener){
        listeners.computeIfAbsent(key, k -> new ArrayList<>()).add(listener);
    }
    public void removeListener (String key, GameEventListener listener) {
        if(listeners.containsKey(key)) {
            listeners.get(key).removeIf(entry -> entry.equals(listener));
        }
    }
    public void fire (String eventType, Eventable event) {
        ArrayList<GameEventListener> typedListeners = listeners.get(eventType);
        if(!typedListeners.isEmpty()) {
            for (GameEventListener typedListener: typedListeners) {
                typedListener.handle(event);
            }
        }
    }
}
