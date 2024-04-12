package dataAccessImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataAccessLayer.CharitableOrganizationDao;
import dataAccessLayer.DataSource;
import transferObject.CharitableOrganizationDTO;

public class CharitableOrganizationDaoImpl implements CharitableOrganizationDao {

    @Override
    public List<CharitableOrganizationDTO> getAllCharitableOrganizations() {
        List<CharitableOrganizationDTO> charitableOrganizations = new ArrayList<>();

        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM CharitableOrganizations");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CharitableOrganizationDTO charity = new CharitableOrganizationDTO();
                charity.setUserId(rs.getInt("userid"));
                charity.setName(rs.getString("name"));
                charity.setEmail(rs.getString("email"));
                charitableOrganizations.add(charity);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework for better error reporting
        }

        return charitableOrganizations;
    }

}
