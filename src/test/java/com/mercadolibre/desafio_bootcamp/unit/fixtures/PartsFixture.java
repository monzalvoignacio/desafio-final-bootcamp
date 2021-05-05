package com.mercadolibre.desafio_bootcamp.unit.fixtures;

import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import com.mercadolibre.desafio_bootcamp.models.Part;
import com.mercadolibre.desafio_bootcamp.models.PartRecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartsFixture {

    // create default objects for PartDTo dto (last Modification) filtered by 01/10/2014
    public static List<PartDto> defaultFilteredListPartDto1() {
        List<PartDto> list = new ArrayList<>();
        list.add(new PartDto("82917292", "This is a default part", "Brian", "37", "A91", "1500", "1980", "800","180", "120", "150", "2015-07-12"));
        list.add(new PartDto("40927202", "Here we go again", "Roger", "28", "D31", "3200", "4250", "700","120", "70", "130", "2021-02-04"));
        return list;
    }

    // create default objects for PartDTo dto (last Modification)
    public static List<PartDto> defaultListPartDto() {
        List<PartDto> list = new ArrayList<>();
        list.add(new PartDto("82917292", "This is a default part", "Brian", "37", "A91", "1500", "1980", "800","180", "120", "150", "2015-07-12"));
        list.add(new PartDto("16282920", "Another default part", "Tony", "10", "F01", "9000", "11300", "400","170", "110", "80", "2010-05-29"));
        list.add(new PartDto("40927202", "Here we go again", "Roger", "28", "D31", "3200", "4250", "700","120", "70", "130", "2021-02-04"));
        list.add(new PartDto("27394020", "Last default part", "John", "5", "J04", "4100", "5200", "300","230", "220", "100", "1999-11-17"));
        return list;
    }

    // create default objects for PartDTo dto (last Price Modification)
    public static List<PartDto> defaultListPartDtoPriceModification() {
        List<PartDto> list = new ArrayList<>();
        list.add(new PartDto("82917292", "This is a default part", "Brian", "37", "A91", "1500", "1980", "800","180", "120", "150", "2019-03-12"));
        list.add(new PartDto("16282920", "Another default part", "Tony", "10", "F01", "9000", "11300", "400","170", "110", "80", "2013-11-29"));
        list.add(new PartDto("40927202", "Here we go again", "Roger", "28", "D31", "3200", "4250", "700","120", "70", "130", "2021-04-01"));
        list.add(new PartDto("27394020", "Last default part", "John", "5", "J04", "4100", "5200", "300","230", "220", "100", "2002-01-17"));
        return list;
    }

    // create default objects for PartRecord model
    public static List<PartRecord> defaultListPartRecord() {
        List<PartRecord> list = new ArrayList<>();
        PartRecord record1 = defaultPartRecord1();
        PartRecord record2 = defaultPartRecord2();
        PartRecord record3 = defaultPartRecord3();
        PartRecord record4 = defaultPartRecord4();
        Part part1 = defaultPart1();
        Part part2 = defaultPart2();
        Part part3 = defaultPart3();
        Part part4 = defaultPart4();
        record1.setPart(part1);
        record2.setPart(part2);
        record3.setPart(part3);
        record4.setPart(part4);
        return Arrays.asList(record1, record2, record3, record4);
    }

    // create default objects for Part model
    public static List<Part> defaultListPartModel() {
        List<Part> list = new ArrayList<>();
        PartRecord record1 = defaultPartRecord1();
        PartRecord record2 = defaultPartRecord2();
        PartRecord record3 = defaultPartRecord3();
        PartRecord record4 = defaultPartRecord4();
        Part part1 = defaultPart1();
        Part part2 = defaultPart2();
        Part part3 = defaultPart3();
        Part part4 = defaultPart4();
        record1.setPart(part1);
        record2.setPart(part2);
        record3.setPart(part3);
        record4.setPart(part4);
        return Arrays.asList(part1, part2, part3, part4);
    }

    // create default records, one by one...
    public static PartRecord defaultPartRecord1() {
        PartRecord record = new PartRecord();
        record.setId(1L);
        record.setPart(null);
        record.setDiscountType(null);
        record.setNormalPrice(1500.0);
        record.setUrgentPrice(1980.0);
        record.setLastModification(LocalDate.of(2019, 03, 12));
        return record;
    }
    public static PartRecord defaultPartRecord2() {
        PartRecord record = new PartRecord();
        record.setId(2L);
        record.setPart(null);
        record.setDiscountType(null);
        record.setNormalPrice(9000.0);
        record.setUrgentPrice(11300.0);
        record.setLastModification(LocalDate.of(2013, 11, 29));
        return record;
    }
    public static PartRecord defaultPartRecord3() {
        PartRecord record = new PartRecord();
        record.setId(3L);
        record.setPart(null);
        record.setDiscountType(null);
        record.setNormalPrice(3200.0);
        record.setUrgentPrice(4250.0);
        record.setLastModification(LocalDate.of(2021, 04, 01));
        return record;
    }
    public static PartRecord defaultPartRecord4() {
        PartRecord record = new PartRecord();
        record.setId(3L);
        record.setPart(null);
        record.setDiscountType(null);
        record.setNormalPrice(4100.0);
        record.setUrgentPrice(5280.0);
        record.setLastModification(LocalDate.of(2002, 01, 17));
        return record;
    }

    // create default parts, one by one...
    public static Part defaultPart1() {
        Part part = new Part();
        part.setId(1L);
        part.setPartCode("82917292");
        part.setDescription("This is a default part");
        part.setProvider(null);
        part.setStock(null);
        part.setNetWeight(800);
        part.setLongDimension(180);
        part.setWidthDimenion(120);
        part.setTalDimension(150);
        part.setLastModification(LocalDate.of(2015, 07, 12));
        return part;
    }
    public static Part defaultPart2() {
        Part part = new Part();
        part.setId(2L);
        part.setPartCode("16282920");
        part.setDescription("Another default part");
        part.setProvider(null);
        part.setStock(null);
        part.setNetWeight(400);
        part.setLongDimension(170);
        part.setWidthDimenion(110);
        part.setTalDimension(80);
        part.setLastModification(LocalDate.of(2010, 05, 29));
        return part;
    }
    public static Part defaultPart3() {
        Part part = new Part();
        part.setId(3L);
        part.setPartCode("40927202");
        part.setDescription("Here we go again");
        part.setProvider(null);
        part.setStock(null);
        part.setNetWeight(700);
        part.setLongDimension(120);
        part.setWidthDimenion(70);
        part.setTalDimension(130);
        part.setLastModification(LocalDate.of(2021, 02, 04));
        return part;
    }
    public static Part defaultPart4() {
        Part part = new Part();
        part.setId(4L);
        part.setPartCode("27394020");
        part.setDescription("Last default part");
        part.setProvider(null);
        part.setStock(null);
        part.setNetWeight(300);
        part.setLongDimension(230);
        part.setWidthDimenion(220);
        part.setTalDimension(100);
        part.setLastModification(LocalDate.of(1999, 11, 17));
        return part;
    }
}
