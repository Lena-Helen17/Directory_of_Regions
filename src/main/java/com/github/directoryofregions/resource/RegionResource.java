package com.github.directoryofregions.resource;

import com.github.directoryofregions.error.RegionNotExist;
import com.github.directoryofregions.model.Region;
import com.github.directoryofregions.service.RegionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class RegionResource {

    private final RegionService regionService;

    public RegionResource(RegionService regionService) {
        this.regionService = regionService;
    }

    @PostMapping("/region")
    public ResponseEntity<Region> createRegion(@RequestBody Region region) {
        Integer persistedObject = regionService.creatNewRegion(region);
        if (persistedObject != null) {
            log.info("Region " + region.getName() + " create successfully");
        }
        return new ResponseEntity<>(region, HttpStatus.CREATED);
    }

    @GetMapping("/regions")
    public ResponseEntity<List<Region>> getRegions() {
        List<Region> regionList = regionService.getRegions();
        if (regionList.isEmpty()) {
            throw new RegionNotExist("Regions not found");
        }
        log.info("Regions fetched successfully");
        return new ResponseEntity<>(regionList, HttpStatus.OK);
    }

    @GetMapping("/region/{code}")
        public ResponseEntity<Region> getRegion (Integer code){
            Region region = regionService.getRegion(code);
            log.info("Regions fetched successfully");
            return new ResponseEntity<>(region, HttpStatus.OK);
        }

    @DeleteMapping("/region/{code}")
        public ResponseEntity<Region> deleteRegion (Integer code){
            regionService.deleteRegion(code);
            log.info("Regions deleted successfully");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
