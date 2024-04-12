package dataAccessLayer;

import java.util.List;
import transferObject.CharitableOrganizationDTO;

public interface CharitableOrganizationDao {
    List<CharitableOrganizationDTO> getAllCharitableOrganizations();
    CharitableOrganizationDTO getCharitableOrganizationById(int orgId);
    void addCharitableOrganization(CharitableOrganizationDTO organization);
    void updateCharitableOrganization(CharitableOrganizationDTO organization);
    void deleteCharitableOrganization(int orgId);
}
