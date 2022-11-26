package com.crud.service.impl;

import com.crud.model.Profile;
import com.crud.repository.ProfileRepository;
import com.crud.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService
    {
        @Autowired//Notación correspondiente
        private ProfileRepository profileRepository;
        @Override
        public Profile createProfile(Profile profile){
        return profileRepository.save(profile);
    }
        @Override
        public void updateProfile(Profile profile){
        profileRepository.save(profile);
    }
        @Override
        public Profile getProfile( int id){
        Optional<Profile> optional = profileRepository.findById(id);
        Profile profile = optional.get();
        return profile;
    }
        @Override
        public List<Profile> getProfiles() {
        return (List<Profile>) profileRepository.findAll();
    }
        @Override
        public void deleteProfile(int id){
        profileRepository.deleteById(id);
    }
        @Override
        public boolean isProfileExist (int id){
        return profileRepository.existsById(id);
    }
}