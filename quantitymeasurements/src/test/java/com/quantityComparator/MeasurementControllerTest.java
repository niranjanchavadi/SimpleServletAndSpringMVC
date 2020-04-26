package com.quantityComparator;


import com.quantityComparator.model.Measurementunits;
import com.quantityComparator.model.OutputDataDTO;
import com.quantityComparator.services.QuantityMeasurementException;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MeasurementControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    public Measurementunits getMeasurementData(String baseUnitType, Double baseUnitValue,
                                               String convUnitType, Double convUnitValue) {
        Measurementunits measurementunits = new Measurementunits();
        measurementunits.setBaseUnitType(baseUnitType);
        measurementunits.setBaseUnitValue(baseUnitValue);
        measurementunits.setConvUnitType(convUnitType);
        measurementunits.setConvUnitValue(convUnitValue);
        return measurementunits;
    }

    @Test
    public void testCompareLengthUnits() {

        OutputDataDTO outputDataDTO = this.restTemplate.postForObject("http://localhost:" + port + "/compareUnit",
                getMeasurementData("feet", 1.0, "inch", 12.0),
                OutputDataDTO.class);
        assertThat(outputDataDTO.getEqual()).isEqualTo(Boolean.TRUE);
    }


    @Test
    public void testCompareUnitsWithException() {


        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/compareUnit",
                getMeasurementData("feet", 1.0, "celsius", 12.0),
                QuantityMeasurementException.class)).isInstanceOf(QuantityMeasurementException.class);
    }


    @Test
    public void testCompareUnitsWithImproperConversion() {

        OutputDataDTO outputDataDTO = this.restTemplate.postForObject("http://localhost:" + port + "/compareUnit",
                getMeasurementData("feet", 1.0, "inch", 10.0),
                OutputDataDTO.class);
        assertThat(outputDataDTO.getEqual()).isFalse();
    }

    @Test
    public void testCompareTempeartureUnits() {

        OutputDataDTO outputDataDTO = this.restTemplate.postForObject("http://localhost:" + port + "/temperatureCompare",
                getMeasurementData("celsius", 100.0, "fahrenheit", 212.0),
                OutputDataDTO.class);
        assertThat(outputDataDTO.getEqual()).isEqualTo(Boolean.TRUE);
    }

    @Test
    public void testAddLengthUnits() {

        OutputDataDTO outputDataDTO = this.restTemplate.postForObject("http://localhost:" + port + "/addUnits",
                getMeasurementData("feet", 1.0, "inch", 12.0),
                OutputDataDTO.class);
        assertThat(outputDataDTO.getAdded_Unit()).isEqualTo(24.0);
    }




}