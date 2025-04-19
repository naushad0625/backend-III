package _03_MultiPlayerGameEventSystem;

import java.util.LinkedList;
import java.util.Queue;

public class EventQueue {
    private final Queue<Eventable> queue = new LinkedList<>();
    private final GameEventDispatcher dispatcher;
    private final int maxEventsPerTick;
    public EventQueue(GameEventDispatcher dispatcher, int maxEventsPerTick) {
        this.dispatcher = dispatcher;
        this.maxEventsPerTick = maxEventsPerTick;
    }
    public void post (Eventable event) {
        queue.offer(event);
    }
    public void process (){
        int processed = 0;
        while (!queue.isEmpty() && processed < maxEventsPerTick) {
            Eventable event = queue.poll();
            String eventType = event.getEventType();
            dispatcher.fire(eventType, event);
            processed++;
        }


    }
}
