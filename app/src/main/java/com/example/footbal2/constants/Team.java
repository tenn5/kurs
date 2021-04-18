package com.example.footbal2.constants;

import com.example.footbal2.R;

import java.util.Map;

public class Team {
    private final Map<Integer, Integer> teamEngland = Map.ofEntries(
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

    private final Map<Integer, Integer> teamGermany = Map.ofEntries(
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

    private final Map<Integer, Integer> teamSpain = Map.ofEntries(
            Map.entry(77, R.drawable.ic_77),
            Map.entry(78, R.drawable.ic_78),
            Map.entry(79, R.drawable.ic_79),
            Map.entry(81, R.drawable.ic_81),
            Map.entry(82, R.drawable.ic_82),
            Map.entry(83, R.drawable.ic_83),
            Map.entry(86, R.drawable.ic_86),
            Map.entry(88, R.drawable.ic_88),
            Map.entry(90, R.drawable.ic_90),
            Map.entry(92, R.drawable.ic_92),
            Map.entry(94, R.drawable.ic_94),
            Map.entry(95, R.drawable.ic_95),
            Map.entry(250, R.drawable.ic_250),
            Map.entry(263, R.drawable.ic_263),
            Map.entry(264, R.drawable.ic_264),
            Map.entry(278, R.drawable.ic_278),
            Map.entry(285, R.drawable.ic_285),
            Map.entry(299, R.drawable.ic_299),
            Map.entry(558, R.drawable.ic_558),
            Map.entry(559, R.drawable.ic_559)

    );


    public Map<Integer, Integer> getTeamEngland() {
        return teamEngland;
    }

    public Map<Integer, Integer> getTeamGermany() {
        return teamGermany;
    }

}
