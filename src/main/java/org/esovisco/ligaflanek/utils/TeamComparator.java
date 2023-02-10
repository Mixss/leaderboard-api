package org.esovisco.ligaflanek.utils;

import org.esovisco.ligaflanek.domain.Team;

import java.util.Comparator;

public class TeamComparator implements Comparator<Team> {
    @Override
    public int compare(Team o1, Team o2) {
        return o2.getPoints().compareTo(o1.getPoints());
    }
}
