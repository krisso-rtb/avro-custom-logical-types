package com.rtbhouse.custom.logical.types;

public record CustomDuration(int months, int days, int millis) implements Comparable<CustomDuration> {

    @Override
    public int compareTo(CustomDuration other) {
        int res = Integer.compare(this.months, other.months);
        if (res == 0) {
            res = Integer.compare(this.days, other.days);
            if (res == 0) {
                res = Integer.compare(this.millis, other.millis);
            }
        }

        return res;
    }
}
