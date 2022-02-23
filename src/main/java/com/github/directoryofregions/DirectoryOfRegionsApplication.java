package com.github.directoryofregions;

import com.github.directoryofregions.model.Region;
import com.github.directoryofregions.service.RegionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DirectoryOfRegionsApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RegionService regionRepository;

    @Override
    public void run(String... args) {

        logger.info("Inserting -> {}", regionRepository.creatNewRegion(new Region(77, "г. Москва", "MO")));
        logger.info("Inserting -> {}", regionRepository.creatNewRegion(new Region(78, "Санкт-Петербург", "SPB")));
        logger.info("Inserting -> {}", regionRepository.creatNewRegion(new Region(69, "Калининская область", "TO")));

        logger.info("Region code 69 -> {}", regionRepository.getRegion(69));

        logger.info("Region name Санкт-Петербург -> {}", regionRepository.getRegionByName("Санкт-Петербург"));

        regionRepository.updateRegion(new Region(69, "Тверская область", "TO"));

        logger.info("Update 69 -> {}", regionRepository.getRegion(69));

        regionRepository.deleteRegion(77);

        logger.info("All regions -> {}", regionRepository.getRegions());
    }

    public static void main(String[] args) {
        SpringApplication.run(DirectoryOfRegionsApplication.class, args);
    }

}
