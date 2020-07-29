package com.dev.test;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface UserRepositery extends DatastoreRepository<User, Long> {
}
