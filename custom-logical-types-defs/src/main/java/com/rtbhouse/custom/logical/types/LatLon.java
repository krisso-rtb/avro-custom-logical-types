package com.rtbhouse.custom.logical.types;

public record LatLon(double latitude, double longitude) implements Comparable<LatLon> {

    @Override
    public int compareTo(LatLon other) {
        // Comparing coordinates doesn't make much sense, but it's required to implement Comparable interface
        // (forced by equals() method from enclosing Avro class)
        int res = Double.compare(this.latitude, other.latitude);
        if (res == 0) {
            res = Double.compare(this.longitude, other.longitude);
        }

        return res;
    }
}
