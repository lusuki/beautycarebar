package com.shm.bcb.core.entity;

import javax.persistence.PrePersist;
import java.util.Date;

public class CreatableListener {
	@PrePersist
	public void setCreatedAt(final Creatable entity) {
		entity.setCreated(new Date());
	}
}
