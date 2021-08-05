package com.org.campaign.owner.management.model;

public class Channels {
	private String SMS;
	private String MMS;
	private String TV;

	/**
	 * 
	 */
	public Channels() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param sMS
	 * @param mMS
	 * @param tV
	 */
	public Channels(String sMS, String mMS, String tV) {
		super();
		SMS = sMS;
		MMS = mMS;
		TV = tV;
	}

	/**
	 * @return the sMS
	 */
	public String getSMS() {
		return SMS;
	}

	/**
	 * @param sMS
	 *            the sMS to set
	 */
	public void setSMS(String sMS) {
		SMS = sMS;
	}

	/**
	 * @return the mMS
	 */
	public String getMMS() {
		return MMS;
	}

	/**
	 * @param mMS
	 *            the mMS to set
	 */
	public void setMMS(String mMS) {
		MMS = mMS;
	}

	/**
	 * @return the tV
	 */
	public String getTV() {
		return TV;
	}

	/**
	 * @param tV
	 *            the tV to set
	 */
	public void setTV(String tV) {
		TV = tV;
	}

}
