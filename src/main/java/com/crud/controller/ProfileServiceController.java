package com.crud.controller;

import com.crud.exception.ProfileNotFoundException;
import com.crud.model.Profile;
import com.crud.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProfileServiceController {
    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/profiles", method = RequestMethod.POST)
    public ResponseEntity<Object> createProfile (@RequestBody Profile profile)
    {
        profile = profileService.createProfile(profile);
        return new ResponseEntity<>("Profile is created successfully with id = " +profile.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/profiles/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProfile (@PathVariable("id") int id,
                                                  @RequestBody Profile profile)
    {
        boolean isProfileExist = profileService.isProfileExist(id);
        if (isProfileExist)
        {
            profile.setId(id);
            profileService.updateProfile (profile);
            return new ResponseEntity<>("Profile is updated successsfully", HttpStatus.OK);
        }
    else
        {
            throw new ProfileNotFoundException();
        }

    }

    @RequestMapping(value = "/profiles/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProfile (@PathVariable("id") int id)
    {
        boolean isProfileExist = profileService.isProfileExist(id);
        if (isProfileExist)
        {
            Profile profile = profileService.getProfile(id);
            return new ResponseEntity<>(profile, HttpStatus.OK);
        }
    else
        {
            throw new ProfileNotFoundException();
        }

    }
    @Operation(summary = "Listar profiles")
    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public ResponseEntity<Object> getProfiles()
    {
        List<Profile> ProfileList = profileService.getProfiles();
        return new ResponseEntity<>(ProfileList, HttpStatus.OK);
    }

    @RequestMapping(value = "/profiles/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProfile (@PathVariable("id") int id)
    {
        boolean isProfileExist = profileService.isProfileExist(id);
        if (isProfileExist)
        {
            profileService.deleteProfile(id);
            return new ResponseEntity<>("Profile is deleted successsfully", HttpStatus.OK);
        }
    else
        {
            throw new ProfileNotFoundException();
        }

    }
}
