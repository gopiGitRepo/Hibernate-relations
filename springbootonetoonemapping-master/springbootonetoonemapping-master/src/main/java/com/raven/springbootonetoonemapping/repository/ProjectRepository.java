package com.raven.springbootonetoonemapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raven.springbootonetoonemapping.entiry.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}