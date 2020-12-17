package com.amazon.gdpr.model.gdpr.input;

public class AnonymizeDetails {
	
	int mappingId;
	int runId;
	int impactFieldId;
	int categoryId;
	String region;
	String countryCode;
	int anonymizationPatternId;
	Boolean status;
	
	public AnonymizeDetails(){
		
	}
	
	/**
	 * @param mappingId
	 * @param runId
	 * @param impactFieldId
	 * @param categoryId
	 * @param region
	 * @param countryCode
	 * @param anonymizationPatternId
	 * @param status
	 */
	public AnonymizeDetails(int mappingId, int runId, int impactFieldId, int categoryId, String region,
			String countryCode, int anonymizationPatternId, Boolean status) {
		super();
		this.mappingId = mappingId;
		this.runId = runId;
		this.impactFieldId = impactFieldId;
		this.categoryId = categoryId;
		this.region = region;
		this.countryCode = countryCode;
		this.anonymizationPatternId = anonymizationPatternId;
		this.status = status;
	}
	/**
	 * @return the mappingId
	 */
	public int getMappingId() {
		return mappingId;
	}
	/**
	 * @param mappingId the mappingId to set
	 */
	public void setMappingId(int mappingId) {
		this.mappingId = mappingId;
	}
	/**
	 * @return the runId
	 */
	public int getRunId() {
		return runId;
	}
	/**
	 * @param runId the runId to set
	 */
	public void setRunId(int runId) {
		this.runId = runId;
	}
	/**
	 * @return the impactFieldId
	 */
	public int getImpactFieldId() {
		return impactFieldId;
	}
	/**
	 * @param impactFieldId the impactFieldId to set
	 */
	public void setImpactFieldId(int impactFieldId) {
		this.impactFieldId = impactFieldId;
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return the anonymizationPatternId
	 */
	public int getAnonymizationPatternId() {
		return anonymizationPatternId;
	}
	/**
	 * @param anonymizationPatternId the anonymizationPatternId to set
	 */
	public void setAnonymizationPatternId(int anonymizationPatternId) {
		this.anonymizationPatternId = anonymizationPatternId;
	}
	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
