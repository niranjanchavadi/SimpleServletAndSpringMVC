package com.quantityComparator.services;

import com.quantityComparator.model.InputDTO;
import com.quantityComparator.model.Measurementunits;
import com.quantityComparator.model.OutputDataDTO;
import com.quantityComparator.model.TemperatureUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuantityMeasurement {

    @Autowired
    private InputDTO inputDTO1;
    @Autowired
    private InputDTO inputDTO2;
    @Autowired
    private GetDtoObjects dtoObjects;
    @Autowired
    private OutputDataDTO outputDTO;

    public QuantityMeasurement() {
    }

    private void checkMeasurementTypeEquals(InputDTO convertFromDTO, InputDTO convertToDTO) throws QuantityMeasurementException {
        if (!compareMeasurementType(convertFromDTO, convertToDTO)) {
            throw new QuantityMeasurementException("Class Not Equal", QuantityMeasurementException.ExceptionType.CLASS_NOT_EQUAL);
        }
    }

    private boolean compareMeasurementType(InputDTO convertFromDTO, InputDTO convertToDTO) {
        return convertFromDTO.getUnitType().getClass().equals(convertToDTO.getUnitType().getClass());
    }

    public OutputDataDTO compareUnits(Measurementunits measurementunits) throws QuantityMeasurementException {
        createInputDto(measurementunits);
        boolean isEqual = Double.compare(inputDTO1.getValue() * inputDTO1.getUnitType().conversion(), inputDTO2.getValue() * inputDTO2.getUnitType().conversion()) == 0;
        outputDTO = dtoObjects.createComparisonOutputDtoObject(measurementunits.getBaseUnitValue(), measurementunits.getConvUnitValue(), isEqual);
        return outputDTO;
    }

    private void createInputDto(Measurementunits measurementunits) throws QuantityMeasurementException {
        inputDTO1 = dtoObjects.createInputDtoObject(measurementunits.getBaseUnitValue(), measurementunits.getBaseUnitType());
        inputDTO2 = dtoObjects.createInputDtoObject(measurementunits.getConvUnitValue(), measurementunits.getConvUnitType());
        checkMeasurementTypeEquals(inputDTO1, inputDTO2);
    }

    public OutputDataDTO additionOfUnits(Measurementunits measurementunits) throws QuantityMeasurementException {
        createInputDto(measurementunits);
        if (inputDTO1.getUnitType().getUnit().equals("celsius")) {
            throw new QuantityMeasurementException("Cannot add Temperatures", QuantityMeasurementException.ExceptionType.CANNOT_ADD_TEMPERATURE);
        }
        double output = inputDTO1.getValue() * inputDTO1.getUnitType().conversion() + inputDTO2.getValue() * inputDTO2.getUnitType().conversion();
        outputDTO = dtoObjects.createAdditionOutputDtoObject(measurementunits.getBaseUnitValue(), measurementunits.getConvUnitValue(), output, inputDTO1.getUnitType().getUnit());
        return outputDTO;
    }

    public OutputDataDTO temperatureComparision(Measurementunits measurementunits) throws QuantityMeasurementException {
        boolean isEqual;
        createInputDto(measurementunits);
        if (inputDTO1.getUnitType().equals(TemperatureUnit.CELSIUS))
            isEqual = Double.compare(inputDTO1.getValue() * 9 / 5 + TemperatureUnit.FAHRENHEIT.measurementValue, inputDTO2.getValue()) == 0;
        else
            isEqual = Double.compare(inputDTO2.getValue(), (inputDTO1.getValue() - TemperatureUnit.FAHRENHEIT.measurementValue) * 5 / 9) == 0;

        outputDTO = dtoObjects.createComparisonOutputDtoObject(measurementunits.getBaseUnitValue(), measurementunits.getConvUnitValue(), isEqual);
        return outputDTO;
    }

}