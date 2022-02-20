package com.github.directoryofregions.error;

public class RegionNotExist extends RuntimeException {
    public RegionNotExist(String msg) {
        super(msg);
    }
}
