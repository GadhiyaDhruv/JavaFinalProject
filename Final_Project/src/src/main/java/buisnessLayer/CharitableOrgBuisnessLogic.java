package buisnessLayer;

import java.util.ArrayList;
import java.util.List;

import transferObject.CharitableOrganizationDTO;

public class CharitableOrgBuisnessLogic {

	private List<CharitableOrganizationDTO> charitableOrganizations;

	public CharitableOrgBuisnessLogic() {
		charitableOrganizations = new ArrayList<>();
	}

	public CharitableOrganizationDTO getCharitableOrganizationById(int orgId) {
		for (CharitableOrganizationDTO org : charitableOrganizations) {
			if (org.getOrgId() == orgId) {
				return org;
			}
		}
		return null;
	}

	public List<CharitableOrganizationDTO> getAllCharitableOrganizations() {
		return charitableOrganizations;
	}

	public void addCharitableOrganization(CharitableOrganizationDTO charitableOrganization) {
		charitableOrganizations.add(charitableOrganization);
	}

	public void updateCharitableOrganization(CharitableOrganizationDTO updatedOrganization) {
		for (int i = 0; i < charitableOrganizations.size(); i++) {
			CharitableOrganizationDTO org = charitableOrganizations.get(i);
			if (org.getOrgId() == updatedOrganization.getOrgId()) {
				charitableOrganizations.set(i, updatedOrganization);
				return;
			}
		}
	}

	public void deleteCharitableOrganization(int orgId) {
		charitableOrganizations.removeIf(org -> org.getOrgId() == orgId);
	}
}
