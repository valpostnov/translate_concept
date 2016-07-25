package com.postnov.android.translate.data.source.study.entity;

import java.util.List;

/**
 * Created by platon on 25.07.2016.
 */
public class Profile {

    private User user;
    private List<Statistics> weekStatistics;
    private int unstudiedWords;

    public Profile(User user, List<Statistics> weekStatistics, int unstudiedWords) {
        this.user = user;
        this.weekStatistics = weekStatistics;
        this.unstudiedWords = unstudiedWords;
    }

    public List<Statistics> getWeekStatistics() {
        return weekStatistics;
    }

    public int getUnstudiedWords() {
        return unstudiedWords;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        if (unstudiedWords != profile.unstudiedWords) return false;
        if (!user.equals(profile.user)) return false;
        return weekStatistics.equals(profile.weekStatistics);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + weekStatistics.hashCode();
        result = 31 * result + unstudiedWords;
        return result;
    }
}
