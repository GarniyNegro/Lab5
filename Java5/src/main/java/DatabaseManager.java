import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/philharmonic";
    private static final String USER = "root";
    private static final String PASSWORD = "vavava";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createTables() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            String createEventsTable = """
                CREATE TABLE IF NOT EXISTS Events (
                    eventId INT PRIMARY KEY,
                    eventName VARCHAR(100),
                    eventDate DATE,
                    roomId INT,
                    eventSeats INT,
                    FOREIGN KEY (roomId) REFERENCES Rooms(roomId)
                )
            """;
            String createRoomsTable = """
                CREATE TABLE IF NOT EXISTS Rooms (
                    roomId INT PRIMARY KEY,
                    seatCapacity INT
                )
            """;

            stmt.execute(createRoomsTable);
            stmt.execute(createEventsTable);
            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
