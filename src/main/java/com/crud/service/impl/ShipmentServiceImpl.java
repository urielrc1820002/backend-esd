package com.crud.service.impl;

import com.crud.model.Shipment;
import com.crud.repository.ShipmentRepository;
import com.crud.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ShipmentServiceImpl implements ShipmentService {
    @Autowired//Notación correspondiente
    private ShipmentRepository shipmentRepository;
    @Override
    public Shipment createShipment (Shipment shipment) {
                return shipmentRepository.save(shipment);
    }
    @Override
    public void updateShipment (Shipment shipment) {
        shipmentRepository.save(shipment);
    }
    @Override
    public Shipment getShipment(int id) {
        Optional<Shipment> optional = shipmentRepository.findById(id);
        Shipment shipment = optional.get();
        return shipment;
    }
    @Override
    public List<Shipment> getShipments () {
        return (List<Shipment>)shipmentRepository.findAll();
    }
    @Override
    public void deleteShipment (int id) {
        shipmentRepository.deleteById(id);
    }
    @Override
    public boolean isShipmentExist(int id) {
        return shipmentRepository.existsById(id);
    }
}
