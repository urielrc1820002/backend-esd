package com.crud.controller;

import com.crud.exception.ShipmentNotFoundException;
import com.crud.model.Shipment;
import com.crud.service.ShipmentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class ShipmentServiceController {
    @Autowired
    private ShipmentService shipmentService;

    @RequestMapping(value = "/shipments", method = RequestMethod.POST)
    public ResponseEntity<Object> createShipment(@RequestBody Shipment shipment)
    {
        shipment = shipmentService.createShipment(shipment);
        return new ResponseEntity<>("Shipment is created successfully with id = " +shipment.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/shipments/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateShipment(@PathVariable("id") int id,
                                                 @RequestBody Shipment shipment)
    {
        boolean isShipmentExist = shipmentService.isShipmentExist(id);
        if (isShipmentExist)
        {
            shipment.setId(id);
            shipmentService.updateShipment(shipment);
            return new ResponseEntity<>("Shipment is updated successsfully", HttpStatus.OK);
        }
        else
        {
            throw new ShipmentNotFoundException();
        }

    }
    @Operation(summary = "Listar shipments")
    @RequestMapping(value = "/shipments/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getShipment(@PathVariable("id") int id)
    {
        boolean isShipmentExist = shipmentService.isShipmentExist(id);
        if (isShipmentExist)
        {
            Shipment shipment = shipmentService.getShipment(id);
            return new ResponseEntity<>(shipment, HttpStatus.OK);
        }
        else
        {
            throw new ShipmentNotFoundException();
        }

    }
    @RequestMapping(value = "/shipments", method = RequestMethod.GET)
    public ResponseEntity<Object> getShipments()
    {
        List<Shipment> ShipmentList = shipmentService.getShipments();
        return new ResponseEntity<>(ShipmentList, HttpStatus.OK);
    }

    @RequestMapping(value = "/shipments/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteShipment(@PathVariable("id") int id)
    {
        boolean isShipmentExist = shipmentService.isShipmentExist(id);
        if (isShipmentExist)
        {
            shipmentService.deleteShipment(id);
            return new ResponseEntity<>("Shipment is deleted successsfully", HttpStatus.OK);
        }
        else
        {
            throw new ShipmentNotFoundException();
        }

    }
}
