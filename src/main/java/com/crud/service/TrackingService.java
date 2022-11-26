package com.crud.service;

import com.crud.model.Tracking;

import java.util.List;
public interface TrackingService
{


    public abstract Tracking createTracking(Tracking tracking);

    public abstract void updateTracking(Tracking tracking);

    public abstract Tracking getTracking(int id);

    public abstract List<Tracking> getTrackings();

    public abstract void deleteTracking(int id);

    public abstract boolean isTrackingExist(int id);
}
