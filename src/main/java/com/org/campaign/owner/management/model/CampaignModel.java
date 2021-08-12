package com.org.campaign.owner.management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Campaign_Owner_Management")
public class CampaignModel {

	@Id
	private int campaignOwnerId;
	private String campaignOwnerName;
	private String campaignContact;
	private Channels campaignChannels;
	private State campaignState;

	/**
	 * 
	 */
	public CampaignModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param campaignOwnerName
	 * @param campaignContact
	 * @param campaignChannels
	 * @param campaignState
	 */
	public CampaignModel(int campaignOwnerId, String campaignOwnerName, String campaignContact, Channels campaignChannels,
			State campaignState) {
		super();
		this.campaignOwnerId = campaignOwnerId;
		this.campaignOwnerName = campaignOwnerName;
		this.campaignContact = campaignContact;
		this.campaignChannels = campaignChannels;
		this.campaignState = campaignState;
	}

	/**
	 * @return the campaignOwnerId
	 */
	public int getCampaignOwnerId() {
		return campaignOwnerId;
	}

	/**
	 * @param campaignOwnerId
	 *            the campaignOwnerId to set
	 */
	public void setCampaignOwnerId(int campaignOwnerId) {
		this.campaignOwnerId = campaignOwnerId;
	}

	/**
	 * @return the campaignOwnerName
	 */
	public String getCampaignOwnerName() {
		return campaignOwnerName;
	}

	/**
	 * @param campaignOwnerName
	 *            the campaignOwnerName to set
	 */
	public void setCampaignOwnerName(String campaignOwnerName) {
		this.campaignOwnerName = campaignOwnerName;
	}

	/**
	 * @return the campaignContact
	 */
	public String getCampaignContact() {
		return campaignContact;
	}

	/**
	 * @param campaignContact
	 *            the campaignContact to set
	 */
	public void setCampaignContact(String campaignContact) {
		this.campaignContact = campaignContact;
	}

	/**
	 * @return the campaignChannels
	 */
	public Channels getCampaignChannels() {
		return campaignChannels;
	}

	/**
	 * @param campaignChannels
	 *            the campaignChannels to set
	 */
	public void setCampaignChannels(Channels campaignChannels) {
		this.campaignChannels = campaignChannels;
	}

	/**
	 * @return the campaignState
	 */
	public State getCampaignState() {
		return campaignState;
	}

	/**
	 * @param campaignState
	 *            the campaignState to set
	 */
	public void setCampaignState(State campaignState) {
		this.campaignState = campaignState;
	}

}
