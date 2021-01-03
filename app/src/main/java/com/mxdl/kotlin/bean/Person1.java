package com.mxdl.kotlin.bean;

/**
 * Description: <Person1><br>
 * Author:      mxdl<br>
 * Date:        2021/1/3<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Person1 {
    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
