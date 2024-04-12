package dataAccessImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataAccessLayer.DataSource;
import dataAccessLayer.InventoryDao;
import transferObject.InventoryDTO;

public class InventoryDaoImpl implements InventoryDao {

    @Override
    public InventoryDTO getInventoryItemById(int itemId) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM inventory WHERE itemid = ?")) {
            ps.setInt(1, itemId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return createInventoryItemFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<InventoryDTO> getAllInventoryItems() {
        List<InventoryDTO> inventoryItems = new ArrayList<>();
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM inventory");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                inventoryItems.add(createInventoryItemFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventoryItems;
    }

    @Override
    public List<InventoryDTO> getSurplusInventoryItems() {
        List<InventoryDTO> surplusItems = new ArrayList<>();
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM inventory WHERE isItemSurplus = TRUE");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                InventoryDTO item = createInventoryItemFromResultSet(rs);
                item.setSurPlus(true);
                surplusItems.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return surplusItems;
    }

    @Override
    public void addInventoryItem(InventoryDTO item) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO inventory (itemname, quantity, price) VALUES (?, ?, ?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getItemName());
            ps.setInt(2, item.getQuantity());
            ps.setDouble(3, item.getPrice());
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setItemId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInventoryItem(InventoryDTO item) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE inventory SET itemname = ?, quantity = ?, price = ?, isItemSurplus = ? WHERE itemid = ?")) {
            ps.setString(1, item.getItemName());
            ps.setInt(2, item.getQuantity());
            ps.setDouble(3, item.getPrice());
            ps.setBoolean(4, item.isSurPlus());
            ps.setInt(5, item.getItemId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteInventoryItem(int itemId) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM inventory WHERE itemid = ?")) {
            ps.setInt(1, itemId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private InventoryDTO createInventoryItemFromResultSet(ResultSet rs) throws SQLException {
        InventoryDTO item = new InventoryDTO();
        item.setItemId(rs.getInt("itemid"));
        item.setItemName(rs.getString("itemname"));
        item.setQuantity(rs.getInt("quantity"));
        item.setPrice(rs.getDouble("price"));
        return item;
    }
}
