package com.company.MyToshika.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.MyToshika.entity.MyToshikaEntity;
@Repository
public interface MyToshikaRepository extends JpaRepository<MyToshikaEntity, Integer> {

	List<MyToshikaEntity> findByAgeGreaterThan(int age);

//	List<MyToshikaEntity> findByFirstNameAndSalary(String firstName);

}
