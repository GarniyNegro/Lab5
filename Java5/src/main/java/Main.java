import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.createTables();

        // CRUD операції для Room
        RoomDAO roomDAO = new RoomDAO();
        roomDAO.addRoom(new Room(101, 500));
        roomDAO.addRoom(new Room(102, 300));
        System.out.println("All rooms:");
        roomDAO.getAllRooms().forEach(System.out::println);

        // CRUD операції для Event
        EventDAO eventDAO = new EventDAO();
        eventDAO.addEvent(new Event(1, "Symphony Orchestra", "2024-11-15", 101, 500));
        eventDAO.addEvent(new Event(2, "Chamber Music Night", "2024-12-01", 102, 300));
        System.out.println("All events:");
        eventDAO.getAllEvents().forEach(System.out::println);
    }
}
