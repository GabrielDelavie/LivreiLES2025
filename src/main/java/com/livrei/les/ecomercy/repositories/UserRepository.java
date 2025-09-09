package com.livrei.les.ecomercy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livrei.les.ecomercy.domain.Client;

public interface UserRepository extends JpaRepository<Client, Long> {

}
