package com.quantityComparator.services;

import com.quantityComparator.model.InputDTO;
import com.quantityComparator.model.OutputDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetDtoObjects {

   @Autowired
   EnumMapper mapper;

   public InputDTO createInputDtoObject(Double measurementUnitValue, String measurementQuantityType) {
      try {
         return new InputDTO(measurementUnitValue, mapper.get(measurementQuantityType));
      } catch (QuantityMeasurementException e) {
         return null;
      }
   }

   public OutputDataDTO createComparisonOutputDtoObject(Double measurementUnitValue, Double measurementUnitValue1, Boolean isEquals)
   {
      return new OutputDataDTO(measurementUnitValue, measurementUnitValue1, isEquals);
   }

   public OutputDataDTO createAdditionOutputDtoObject(Double measurementUnitValue1, Double measurementUnitValue2, double output, String unit) {
      return new OutputDataDTO(measurementUnitValue1,measurementUnitValue2,output,unit);
   }
}