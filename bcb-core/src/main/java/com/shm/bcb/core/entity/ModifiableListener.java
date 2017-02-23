package com.shm.bcb.core.entity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class ModifiableListener {
	@PrePersist
	@PreUpdate
	public void setCreatedAt(final Modifiable entity) {
		entity.setModified(new Date());
	}
}
