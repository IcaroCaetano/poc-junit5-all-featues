package com.myprojecticaro.poc_junit5_all_featues.mockito.domain;

class RandomService {

    public int generate() {

        return (int) (Math.random() * 10);
    }
}