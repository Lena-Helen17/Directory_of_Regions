package com.github.directoryofregions.service;

import com.github.directoryofregions.repository.RegionMapper;
import com.github.directoryofregions.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegionDao implements RegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Region> getRegions() {
        return regionMapper.getRegions();
    }

    @Override
    public Integer creatNewRegion(Region region) {
        return regionMapper.saveRegion(region);
    }

    @Override
    public Region getRegion(Integer code) {
        return regionMapper.getRegion(code);
    }

    @Override
    public void updateRegion(Region region) {
        regionMapper.updateRegion(region);
    }

    @Override
    public void deleteRegion(Integer code) {
        regionMapper.deleteRegionByCode(code);
    }
}
