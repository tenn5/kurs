package com.example.footbal2.constants;

import com.example.footbal2.R;

import java.util.Map;

public class TeamGermany {
    private final Map<Integer, Integer> teamMap = Map.ofEntries(
            Map.entry(1, R.drawable.ic_1),
            Map.entry(2, R.drawable.ic_2),
            Map.entry(3, R.drawable.ic_3),
            Map.entry(4, R.drawable.ic_4),
            Map.entry(5, R.drawable.ic_5),
            Map.entry(6, R.drawable.ic_6),
            Map.entry(9, R.drawable.ic_9),
            Map.entry(10, R.drawable.ic_10),
            Map.entry(11, R.drawable.ic_11),
            Map.entry(12, R.drawable.ic_12),
            Map.entry(15, R.drawable.ic_15),
            Map.entry(16, R.drawable.ic_16),
            Map.entry(17, R.drawable.ic_17),
            Map.entry(18, R.drawable.ic_18),
            Map.entry(19, R.drawable.ic_19),
            Map.entry(28, R.drawable.ic_28),
            Map.entry(38, R.drawable.ic_38),
            Map.entry(721, R.drawable.ic_721)
    );

    public Map<Integer, Integer> getTeamMap() {
        return teamMap;
    }
}
