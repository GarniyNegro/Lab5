import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    public void addRoom(Room room) {
        String sql = "INSERT INTO Rooms (roomId, seatCapacity) VALUES (?, ?)";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, room.getRoomId());
            pstmt.setInt(2, room.getSeatCapacity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Room getRoomById(int roomId) {
        String sql = "SELECT * FROM Rooms WHERE roomId = ?";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, roomId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Room(rs.getInt("roomId"), rs.getInt("seatCapacity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateRoom(Room room) {
        String sql = "UPDATE Rooms SET seatCapacity = ? WHERE roomId = ?";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, room.getSeatCapacity());
            pstmt.setInt(2, room.getRoomId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRoom(int roomId) {
        String sql = "DELETE FROM Rooms WHERE roomId = ?";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, roomId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM Rooms";
        try (Connection conn = DatabaseManager.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rooms.add(new Room(rs.getInt("roomId"), rs.getInt("seatCapacity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
