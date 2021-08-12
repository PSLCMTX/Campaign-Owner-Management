package com.org.campaign.owner.management.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.org.campaign.owner.management.model.CampaignModel;
import com.org.campaign.owner.management.model.Channels;
import com.org.campaign.owner.management.model.State;
import com.org.campaign.owner.management.repository.CampaignRepository;

@SpringBootTest

public class CampaignServiceTest {

	@Autowired
	Channels channels;

	@Autowired
	State state;

	@Autowired
	CampaignService campaignservice;

	@MockBean
	private CampaignRepository campaignrepository;

	@BeforeEach
	void setup() throws Exception {
		channels.setSMS("sms");
		state.setActive("active");
		Optional<CampaignModel> campaignmodel = Optional
				.of(new CampaignModel(1, "Monika", "1234567890", channels, state));
		Mockito.when(campaignrepository.findById(1)).thenReturn(campaignmodel);

	}

	@Test
	public void validAddOwnerDetails() throws Exception {
		Channels channels = new Channels("sms", "mms", "tv");
		State state = new State("Active", "Suspended", "Terminated");

		CampaignModel campaignModel = new CampaignModel(1, "Monika", "1234567890", channels, state);

		Mockito.when(campaignrepository.save(campaignModel)).thenReturn(campaignModel);
		CampaignModel model = campaignservice.addcampaignmodel(campaignModel);
		System.out.println(model);
		assertEquals("Monika", model.getCampaignOwnerName());
	}

	@Test
	public void validGetOwnerDetails() throws Exception {

		int campaignOwnerId = 1;

		CampaignModel campaignmodel = campaignservice.getOwnerDetails(campaignOwnerId).get();
		assertEquals(campaignOwnerId, campaignmodel.getCampaignOwnerId());
	}

	@Test
	public void validUpdateOwnerDetails() throws Exception {
		int campaignOwnerId = 1;
		Optional<CampaignModel> campaignmodel = Optional
				.of(new CampaignModel(1, "Monika", "1234567890", channels, state));
		CampaignModel model = new CampaignModel(1, "Monika", "1234567890", channels, state);
		Mockito.when(campaignrepository.findById(1)).thenReturn(campaignmodel);
		Optional<CampaignModel> campaignmodel1 = campaignservice.updateOwnerDetails(campaignOwnerId, model);

		assertThat(campaignmodel1).isNotNull();
		assertEquals("Monika", model.getCampaignOwnerName());

	}

}
