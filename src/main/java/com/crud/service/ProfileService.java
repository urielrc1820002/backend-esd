package com.crud.service;

import com.crud.model.Profile;

import java.util.List;

public interface ProfileService {
    public abstract Profile createProfile(Profile profile);
    public abstract void updateProfile(Profile profile);
    public abstract Profile getProfile (int id);
    public abstract List<Profile> getProfiles();
    public abstract void deleteProfile(int id);
    public abstract boolean isProfileExist(int id);
}
