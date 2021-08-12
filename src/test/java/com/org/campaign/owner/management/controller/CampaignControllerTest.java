package com.org.campaign.owner.management.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.SuppressSignatureCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.campaign.owner.management.model.CampaignModel;
import com.org.campaign.owner.management.model.Channels;
import com.org.campaign.owner.management.model.State;
import com.org.campaign.owner.management.repository.CampaignRepository;
import com.org.campaign.owner.management.service.CampaignService;

@WebMvcTest(CampaignController.class)

public class CampaignControllerTest {

	private Channels channels;

	private State state;

	@MockBean
	private CampaignService campaignservice;

	private CampaignModel campaignmodel;

	@Autowired
	private MockMvc mockmvc;

	@MockBean
	CampaignRepository campaignRepository;

	@BeforeEach
	void setup() {

		Optional<CampaignModel> campaignmodel = Optional
				.of(new CampaignModel(1, "Monika", "1234567890", channels, state));

	}

	@Test
	public void addCampaignModelTest() throws Exception {
		Channels channels = new Channels("sms", "mms", "tv");
		State state = new State("Active", "Suspended", "Terminated");
		CampaignModel campaignModel = new CampaignModel(1, "Monika", "1234567890", channels, state);

		Mockito.when(campaignservice.addcampaignmodel(campaignModel)).thenReturn(campaignmodel);
		Mockito.when(campaignRepository.save(campaignModel)).thenReturn(campaignmodel);

		mockmvc.perform(MockMvcRequestBuilders.post("/api/campaign/owner").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n" + "    \"campaignOwnerName\":\"Monika\",\r\n"
						+ "    \"campaignContact\":\"1234567890\",\r\n" + "    \"campaignChannels\": {\r\n"
						+ "        \"sms\":\"yes\",\r\n" + "        \"mms\":\"no\",\r\n" + "        \"tv\":\"no\"\r\n"
						+ "    },\r\n" + "    \"campaignState\": {\r\n" + "        \"active\":\"Yes\",\r\n"
						+ "        \"suspended\":\"No\",\r\n" + "        \"terminated\":\"No\"\r\n" + "    }\r\n"
						+ "}"))

		.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	@SuppressSignatureCheck
	public void getCampaignModelTest() throws Exception {

		int campaignOwnerId = 1;
		Channels channels = new Channels("sms", "mms", "tv");
		State state = new State("Active", "Suspended", "Terminated");
		Optional<CampaignModel> campaignmodel = Optional
				.of(new CampaignModel(1, "Monika", "1234567890", channels, state));

		Mockito.when(campaignservice.getOwnerDetails(campaignOwnerId)).thenReturn(campaignmodel);
		Mockito.when(campaignRepository.findById(campaignOwnerId)).thenReturn(campaignmodel);

		mockmvc.perform(get("/api/campaign/owner/{CampaignOwnerId}", 1).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());

	}

	@Test
	public void updateCampaignModelTest() throws Exception {
		int campaignOwnerId = 1;
		Channels channels = new Channels("sms", "mms", "tv");
		State state = new State("Active", "Suspended", "Terminated");
		Optional<CampaignModel> campaignmodel = Optional
				.of(new CampaignModel(1, "Monika", "1234567890", channels, state));

		CampaignModel campaignModel1 = new CampaignModel(1, "Monika", "1234567890", channels, state);

		Mockito.when(campaignservice.updateOwnerDetails(1, campaignModel1)).thenReturn(campaignmodel);
		Mockito.when(campaignRepository.findById(campaignOwnerId)).thenReturn(campaignmodel);
		mockmvc.perform(put("/api/campaign/owner/{CampaignOwnerId}", 1).contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n" + "    \"campaignOwnerName\":\"Monika\",\r\n"
						+ "    \"campaignContact\":\"1234567890\",\r\n" + "    \"campaignChannels\": {\r\n"
						+ "        \"sms\":\"yes\",\r\n" + "        \"mms\":\"no\",\r\n" + "        \"tv\":\"no\"\r\n"
						+ "    },\r\n" + "    \"campaignState\": {\r\n" + "        \"active\":\"Yes\",\r\n"
						+ "        \"suspended\":\"No\",\r\n" + "        \"terminated\":\"No\"\r\n" + "    }\r\n"
						+ "}"))
		.andExpect(status().isOk());
	}

}
