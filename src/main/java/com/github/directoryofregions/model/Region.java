package com.github.directoryofregions.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Region {

    private Integer code;

    private String name;

    private String abbreviation;

}
