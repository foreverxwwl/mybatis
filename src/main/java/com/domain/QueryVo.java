package com.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor li
 * @create 2019-12-17 14:08
 */
public class QueryVo {
    private User user;

    private List<Integer> ids = new ArrayList<Integer>();

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
