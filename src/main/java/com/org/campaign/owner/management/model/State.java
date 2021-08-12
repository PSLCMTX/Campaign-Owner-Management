package com.org.campaign.owner.management.model;

import org.springframework.stereotype.Component;

@Component
public class State {

	private String Active;
	private String Suspended;
	private String Terminated;

	/**
	 * 
	 */
	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param active
	 * @param suspended
	 * @param terminated
	 */
	public State(String active, String suspended, String terminated) {
		super();
		Active = active;
		Suspended = suspended;
		Terminated = terminated;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return Active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(String active) {
		Active = active;
	}

	/**
	 * @return the suspended
	 */
	public String getSuspended() {
		return Suspended;
	}

	/**
	 * @param suspended
	 *            the suspended to set
	 */
	public void setSuspended(String suspended) {
		Suspended = suspended;
	}

	/**
	 * @return the terminated
	 */
	public String getTerminated() {
		return Terminated;
	}

	/**
	 * @param terminated
	 *            the terminated to set
	 */
	public void setTerminated(String terminated) {
		Terminated = terminated;
	}

}
