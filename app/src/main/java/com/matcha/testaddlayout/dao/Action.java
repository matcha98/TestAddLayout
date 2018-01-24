package com.matcha.testaddlayout.dao;

/**
 * Created by User on 2018/1/18.
 */

public class Action {
    private int _id;
    private String pid;     //場次
    private int section;     //節次
    private String number;     //背號
    private int move;     //動作

    public Action(String pid,int section,String number,int move)
    {
        this.pid=pid;
        this.section=section;
        this.number=number;
        this.move=move;
    }
    public Action(int _id,String pid,int section,String number,int move)
    {
        this._id=_id;
        this.pid=pid;
        this.section=section;
        this.number=number;
        this.move=move;
    }
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return "_id : "+ _id+", pid : "+pid+" section : "+section+" number : "+number+" move : "+move;
    }
}
