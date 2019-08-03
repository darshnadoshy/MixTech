package com.example.cs564.dao;

import com.example.cs564.entity.CreatesEntity;
import com.example.cs564.entity.key.CreatesKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatesRepo extends  JpaRepository<CreatesEntity, CreatesKey> {

}
