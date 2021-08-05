package com.org.campaign.owner.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.org.campaign.owner.management.model.CampaignModel;

@Repository

// CampaignRepository is a repository class which will extend MongoRepository
// for database connection.
public interface CampaignRepository extends MongoRepository<CampaignModel, Integer> {

}
