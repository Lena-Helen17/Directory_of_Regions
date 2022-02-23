package com.github.directoryofregions.repository;

import com.github.directoryofregions.model.Region;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RegionMapper {

    @Select("SELECT * FROM region")
    List<Region> getRegions();

    @Insert("INSERT INTO region(code, name, abbreviation) VALUES (#{code}, #{name}, #{abbreviation})")
    Integer saveRegion(Region region);

    @Update("Update region set name = #{name} where code = #{code}")
    void updateRegion(Region region);

    @Delete("Delete from region where code = #{code}")
    void deleteRegionByCode(Integer code);

    @Select("SELECT * FROM region where code = #{code}")
    Region getRegion(Integer code);

    @Select("SELECT * FROM region where name = #{name}")
    Region getRegionByName(String name);
}
