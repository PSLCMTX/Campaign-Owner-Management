package com.org.campaign.owner.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.campaign.owner.management.model.CampaignModel;
import com.org.campaign.owner.management.repository.CampaignRepository;
import com.org.campaign.owner.management.service.CampaignService;

@RestController
@RequestMapping(path = "/api/campaign")
public class CampaignController {
	@Autowired
	private CampaignService campaignservice;

	@PostMapping(path = "/owner")
	public CampaignModel addcampaignmodel(@RequestBody CampaignModel campaign) {
		return campaignservice.addcampaignmodel(campaign);

	}

	@GetMapping(path = "/owner/{CampaignOwnerId}")
	public Optional<CampaignModel> getOwnerDetails(@PathVariable("CampaignOwnerId") int CampaignOwnerId) {
		return campaignservice.getOwnerDetails(CampaignOwnerId);
	}

	@PutMapping(path = "/owner/{CampaignOwnerId}")
	public Optional<CampaignModel> updateOwnerDetails(@PathVariable("CampaignOwnerId") int CampaignOwnerId,
			@RequestBody CampaignModel campaign) {
		return campaignservice.updateOwnerDetails(CampaignOwnerId, campaign);
	}

}