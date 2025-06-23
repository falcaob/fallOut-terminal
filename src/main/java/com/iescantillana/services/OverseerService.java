package com.iescantillana.services;

import com.iescantillana.models.Overseer;
import com.iescantillana.repositories.OverseerRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class OverseerService implements UserDetailsService {

    @Autowired
    private OverseerRepository overseerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Overseer overseer = overseerRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Overseer not found with username: " + username));

        return new org.springframework.security.core.userdetails.User(overseer.getUsername(), overseer.getPassword(), new ArrayList<>());
    }

}
