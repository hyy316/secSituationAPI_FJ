package com.uway.mobile.domain;

public class SummaryReport {
	private String city;
	private String timeRange;
	private long vulnerability;
	private long malware;
	private long malwareEvents;
	private long indecency;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(String timeRange) {
		this.timeRange = timeRange;
	}

	public long getVulnerability() {
		return vulnerability;
	}

	public void setVulnerability(long vulnerability) {
		this.vulnerability = vulnerability;
	}

	public long getMalware() {
		return malware;
	}

	public void setMalware(long malware) {
		this.malware = malware;
	}

	public long getMalwareEvents() {
		return malwareEvents;
	}

	public void setMalwareEvents(long malwareEvents) {
		this.malwareEvents = malwareEvents;
	}

	public long getIndecency() {
		return indecency;
	}

	public void setIndecency(long indecency) {
		this.indecency = indecency;
	}

}
