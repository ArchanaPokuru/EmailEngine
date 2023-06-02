package com.springboot.mailAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.mailAPI.Module.EmailDetails;

public interface repository extends JpaRepository<EmailDetails, String>
{

}
