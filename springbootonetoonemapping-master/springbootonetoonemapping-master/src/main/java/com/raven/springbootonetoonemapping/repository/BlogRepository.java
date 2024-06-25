package com.raven.springbootonetoonemapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raven.springbootonetoonemapping.entiry.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	
}