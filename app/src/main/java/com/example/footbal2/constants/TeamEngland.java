package com.example.footbal2.constants;

import com.example.footbal2.R;

import java.util.HashMap;
import java.util.Map;

public class TeamEngland {
    private final Map<Integer, Integer> teamMap = Map.ofEntries(
            Map.entry(57, R.drawable.ic_57),
            Map.entry(58, R.drawable.ic_58),
            Map.entry(61, R.drawable.ic_61),
            Map.entry(62, R.drawable.ic_62),
            Map.entry(63, R.drawable.ic_63),
            Map.entry(64, R.drawable.ic_64),
            Map.entry(65, R.drawable.ic_65),
            Map.entry(66, R.drawable.ic_66),
            Map.entry(67, R.drawable.ic_67),
            Map.entry(73, R.drawable.ic_73),
            Map.entry(74, R.drawable.ic_74),
            Map.entry(76, R.drawable.ic_76),
            Map.entry(328, R.drawable.ic_328),
            Map.entry(338, R.drawable.ic_338),
            Map.entry(340, R.drawable.ic_340),
            Map.entry(341, R.drawable.ic_341),
            Map.entry(354, R.drawable.ic_354),
            Map.entry(356, R.drawable.ic_356),
            Map.entry(397, R.drawable.ic_397),
            Map.entry(563, R.drawable.ic_563)

    );

    public Map<Integer, Integer> getTeamMap() {
        return teamMap;
    }
}
