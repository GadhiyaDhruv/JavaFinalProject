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
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DataSource.getConnection();
            String query = "SELECT * FROM CharitableOrganizations";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                CharitableOrganizationDTO charity = new CharitableOrganizationDTO();
                charity.setUserId(rs.getInt("userid"));
                charity.setName(rs.getString("name"));
                charity.setEmail(rs.getString("email"));
                charitableOrganizations.add(charity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return charitableOrganizations;
    }

}
