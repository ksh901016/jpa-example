package com.corn.basic;

import javax.persistence.*;

@Entity
public class Hobby {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private int howLong;

    @ManyToOne(optional = false)
    @JoinColumn(name="id", insertable = false, updatable = false)
    private Account leader;

    public Account getLeader() {
        return leader;
    }

    public void setLeader(Account leader) {
        this.leader = leader;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHowLong() {
        return howLong;
    }

    public void setHowLong(int howLong) {
        this.howLong = howLong;
    }
}
