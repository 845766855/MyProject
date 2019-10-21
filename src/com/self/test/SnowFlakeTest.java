package com.self.test;

import com.self.util.SnowFlakeUtil;

public class SnowFlakeTest {



    public static void main(String[] args) {
        SnowFlakeUtil snow = new SnowFlakeUtil(12, 23);
        for (int i = 0; i < (1 << 5); i++) {
            new SnowFlakeThread(snow).run();
        }

    }
}
