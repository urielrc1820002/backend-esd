package com.crud.controller;

import java.util.List;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crud.exception.TrackingNotFoundException;
import com.crud.model.Tracking;
import com.crud.service.TrackingService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class TrackingServiceController {

    @Autowired
    private TrackingService trackingService;

    @RequestMapping(value = "/trackings", method = RequestMethod.POST)
    public ResponseEntity<Object> createTracking(@RequestBody Tracking tracking)
    {
        tracking = trackingService.createTracking(tracking);
        return new ResponseEntity<>("Tracking is created successfully with id = " +tracking.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/trackings/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateTracking(@PathVariable("id") int id,
                                                 @RequestBody Tracking tracking)
    {
        boolean isTrackingExist = trackingService.isTrackingExist(id);
        if (isTrackingExist)
        {
            tracking.setId(id);
            trackingService.updateTracking(tracking);
            return new ResponseEntity<>("Tracking is updated successsfully", HttpStatus.OK);
        }
        else
        {
            throw new TrackingNotFoundException();
        }

    }

    @RequestMapping(value = "/trackings/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getTracking(@PathVariable("id") int id)
    {
        boolean isTrackingExist = trackingService.isTrackingExist(id);
        if (isTrackingExist)
        {
            Tracking tracking = trackingService.getTracking(id);
            return new ResponseEntity<>(tracking, HttpStatus.OK);
        }
        else
        {
            throw new TrackingNotFoundException();
        }

    }


    @Operation(summary = "Get a .... id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Tracking",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Tracking.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id ",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Tracking not found",
                    content = @Content) })


    @RequestMapping(value = "/trackings", method = RequestMethod.GET)
    public ResponseEntity<Object> getTrackings()
    {
        List<Tracking> trackingList = trackingService.getTrackings();
        return new ResponseEntity<>(trackingList, HttpStatus.OK);
    }

    @RequestMapping(value = "/trackings/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTracking(@PathVariable("id") int id)
    {
        boolean isTrackingExist = trackingService.isTrackingExist(id);
        if (isTrackingExist)
        {
            trackingService.deleteTracking(id);
            return new ResponseEntity<>("Tracking is deleted successsfully", HttpStatus.OK);
        }
        else
        {
            throw new TrackingNotFoundException();
        }

    }
}
