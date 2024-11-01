import java.util.Objects;

/**
 * Клас представляє інформацію про захід у філармонії.
 */
public class Event implements Comparable<Event> {
    private int eventId;
    private String eventName;
    private String eventDate;
    private int roomId;
    private int eventSeats;

    // Конструктор з приватним доступом
    protected Event(int eventId, String eventName, String eventDate, int roomId, int eventSeats) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.roomId = roomId;
        this.eventSeats = eventSeats;
    }

    // Getters and Setters

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getEventSeats() {
        return eventSeats;
    }

    public void setEventSeats(int eventSeats) {
        this.eventSeats = eventSeats;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", roomId=" + roomId +
                ", eventSeats=" + eventSeats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventId == event.eventId && roomId == event.roomId && eventSeats == event.eventSeats &&
                Objects.equals(eventName, event.eventName) && Objects.equals(eventDate, event.eventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, eventName, eventDate, roomId, eventSeats);
    }

    @Override
    public int compareTo(Event other) {
        return this.eventDate.compareTo(other.eventDate); // Порівнюємо за датою
    }
}
