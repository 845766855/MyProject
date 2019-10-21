package com.self.test;

import com.self.util.SnowFlakeUtil;

public class SnowFlakeThread implements Runnable {

    private SnowFlakeUtil snowFlakeUtil;

    public SnowFlakeThread(SnowFlakeUtil snowFlakeUtil) {
        this.snowFlakeUtil = snowFlakeUtil;
    }

    @Override
    public void run() {
        for (int i = 0; i < (1 << 12); i++) {
            System.out.println(snowFlakeUtil.getNext());
        }
    }
}
