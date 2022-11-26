package com.crud.service;

import com.crud.model.Shipment;
import java.util.List;

public interface ShipmentService {
    public abstract Shipment createShipment(Shipment shipment);
    public abstract void updateShipment(Shipment shipment);
    public abstract Shipment getShipment (int id);
    public abstract List<Shipment> getShipments();
    public abstract void deleteShipment(int id);
    public abstract boolean isShipmentExist(int id);
}
