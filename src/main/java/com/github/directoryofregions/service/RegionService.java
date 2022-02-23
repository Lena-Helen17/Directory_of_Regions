package com.github.directoryofregions.service;

import com.github.directoryofregions.model.Region;

import java.util.List;

public interface RegionService {
    List<Region> getRegions();

    Integer creatNewRegion(Region region);

    Region getRegion(Integer code);

    Region getRegionByName(String name);

    void updateRegion(Region region);

    void deleteRegion(Integer code);
}
