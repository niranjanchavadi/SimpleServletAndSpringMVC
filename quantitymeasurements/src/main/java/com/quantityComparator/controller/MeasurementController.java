package com.quantityComparator.controller;


import com.quantityComparator.model.Measurementunits;
import com.quantityComparator.model.OutputDataDTO;
import com.quantityComparator.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MeasurementController {

    @Autowired
    private QuantityMeasurement measurement;


    @PostMapping(value = "/compareUnit",consumes = "application/json",produces = "application/json")
    @ResponseBody
    public OutputDataDTO compareUnits(@RequestBody Measurementunits measurementunits) throws QuantityMeasurementException {
        try {
            return measurement.compareUnits(measurementunits);
        } catch (QuantityMeasurementException e) {
            throw new QuantityMeasurementException("Exception occured", QuantityMeasurementException.ExceptionType.CLASS_NOT_EQUAL);
        }
    }

    @PostMapping(value = "/temperatureCompare",consumes = "application/json",produces = "application/json")
    @ResponseBody
    public OutputDataDTO compareTemperature(@RequestBody Measurementunits measurementunits) throws QuantityMeasurementException {
        try {
            return measurement.temperatureComparision(measurementunits);
        } catch (QuantityMeasurementException e) {
            throw new QuantityMeasurementException("Exception occured", QuantityMeasurementException.ExceptionType.CLASS_NOT_EQUAL);
        }
    }

    @PostMapping(value = "/addUnits",consumes = "application/json",produces = "application/json")
    @ResponseBody
    public OutputDataDTO addUnits(@RequestBody Measurementunits measurementunits) throws QuantityMeasurementException {
        try {
            return measurement.additionOfUnits(measurementunits);
        } catch (QuantityMeasurementException e) {
            throw new QuantityMeasurementException("Exception occured", QuantityMeasurementException.ExceptionType.valueOf("CLASS_NOT_EQUAL"));
        }
    }


}