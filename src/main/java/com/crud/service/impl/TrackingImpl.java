package com.crud.service.impl;
import com.crud.model.Profile;
import com.crud.repository.ProfileRepository;
import com.crud.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.model.Tracking;
import com.crud.service.TrackingService;
import com.crud.repository.TrackingRepository;
import java.util.Optional;
import java.util.List;
@Service
public class TrackingImpl implements TrackingService {



    @Autowired//Notación correspondiente
    private TrackingRepository trackingRepository;

    @Override
    public Tracking createTracking(Tracking tracking) {
        return trackingRepository.save(tracking);
    }

    @Override
    public void updateTracking(Tracking tracking) {
        trackingRepository.save(tracking);
    }

    @Override
    public Tracking getTracking(int id) {
        Optional<Tracking> optional = trackingRepository.findById(id);
        Tracking tracking = optional.get();
        return tracking;
    }

    @Override
    public List<Tracking> getTrackings() {
        return (List<Tracking>)trackingRepository.findAll();
    }

    @Override
    public void deleteTracking(int id) {
        trackingRepository.deleteById(id);
    }

    @Override
    public boolean isTrackingExist(int id) {
        return trackingRepository.existsById(id);
    }
}
