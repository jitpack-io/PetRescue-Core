package com.systemsinmotion.petrescue.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemsinmotion.petrescue.data.RemoteIdentifierRepository;
import com.systemsinmotion.petrescue.entity.RemoteIdentifier;

@Service("remoteIdentifierService")
public class RemoteIdentifierService {

	@Autowired
	RemoteIdentifierRepository remoteIdentifierRepository;

	public List<RemoteIdentifier> findAllRemoteIdentifiers() {
		return this.remoteIdentifierRepository.findAll();
	}

	public RemoteIdentifier findByRemoteId(String id) {
		return this.remoteIdentifierRepository.findByRemoteId(id);
	}

	public List<RemoteIdentifier> findLastUpdatedThatIsLessThan(Date date) {

		return this.remoteIdentifierRepository.findByLastUpdatedLessThan(date);
	}

	public List<RemoteIdentifier> findAllLastUpdatedThatIsAfter(Date date) {
		return this.remoteIdentifierRepository.findByLastUpdatedAfter(date);
	}

	public List<RemoteIdentifier> findAllLastUpdatedThatIsBefore(Date date) {
		return this.remoteIdentifierRepository.findByLastUpdatedBefore(date);
	}

}
