package com.rtbhouse.custom.logical.types;

import java.time.LocalDate;

public record DaysSince2000(int daysSince2000) implements Comparable<DaysSince2000> {

    private static final LocalDate DAY_ZERO = LocalDate.of(1999, 12, 31);

    @Override
    public int compareTo(DaysSince2000 other) {
        return this.daysSince2000 - other.daysSince2000;
    }

    public LocalDate day() {
        return DAY_ZERO.plusDays(daysSince2000);
    }
}
