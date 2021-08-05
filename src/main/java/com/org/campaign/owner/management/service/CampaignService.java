package com.org.campaign.owner.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.campaign.owner.management.model.CampaignModel;
import com.org.campaign.owner.management.repository.CampaignRepository;

@Service
public class CampaignService {

	@Autowired
	CampaignRepository campaignrepository;

	// addcampaignmodel method is a implementation of post method.
	// will implement mongodb sequence later
	private int campaignOwnerIdCount = 1;
	private List<CampaignModel> campaignDetails = new ArrayList<CampaignModel>();

	public CampaignModel addcampaignmodel(CampaignModel campaign) {
		campaign.setCampaignOwnerId(campaignOwnerIdCount);
		campaignDetails.add(campaign);
		campaignOwnerIdCount++;
		return campaignrepository.save(campaign);

	}

	// getOwnerDetails method is a implementation of get method
	public Optional<CampaignModel> getOwnerDetails(int CampaignOwnerId) {

		return campaignrepository.findById(CampaignOwnerId);

	}

	// updateOwnerDetails method is a implementation of put method
	public Optional<CampaignModel> updateOwnerDetails(int CampaignOwnerId, CampaignModel campaign) {

		Optional<CampaignModel> model = campaignrepository.findById(CampaignOwnerId);
		if (model.isPresent()) {

			model.get().setCampaignChannels(campaign.getCampaignChannels());
			model.get().setCampaignContact(campaign.getCampaignContact());
			model.get().setCampaignState(campaign.getCampaignState());
			campaignrepository.save(model.get());
			return model;

		}
		return Optional.empty();

	}

}
