import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {
    public void addEvent(Event event) {
        String sql = "INSERT INTO Events (eventId, eventName, eventDate, roomId, eventSeats) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, event.getEventId());
            pstmt.setString(2, event.getEventName());
            pstmt.setDate(3, Date.valueOf(event.getEventDate()));
            pstmt.setInt(4, event.getRoomId());
            pstmt.setInt(5, event.getEventSeats());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Event getEventById(int eventId) {
        String sql = "SELECT * FROM Events WHERE eventId = ?";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Event(
                        rs.getInt("eventId"),
                        rs.getString("eventName"),
                        rs.getString("eventDate"),
                        rs.getInt("roomId"),
                        rs.getInt("eventSeats")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateEvent(Event event) {
        String sql = "UPDATE Events SET eventName = ?, eventDate = ?, roomId = ?, eventSeats = ? WHERE eventId = ?";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, event.getEventName());
            pstmt.setDate(2, Date.valueOf(event.getEventDate()));
            pstmt.setInt(3, event.getRoomId());
            pstmt.setInt(4, event.getEventSeats());
            pstmt.setInt(5, event.getEventId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(int eventId) {
        String sql = "DELETE FROM Events WHERE eventId = ?";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM Events";
        try (Connection conn = DatabaseManager.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                events.add(new Event(
                        rs.getInt("eventId"),
                        rs.getString("eventName"),
                        rs.getString("eventDate"),
                        rs.getInt("roomId"),
                        rs.getInt("eventSeats")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }
}
