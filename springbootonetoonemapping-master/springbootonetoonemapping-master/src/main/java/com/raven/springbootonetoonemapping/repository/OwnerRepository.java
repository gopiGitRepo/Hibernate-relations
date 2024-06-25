package com.raven.springbootonetoonemapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raven.springbootonetoonemapping.entiry.Owner;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {
	
}