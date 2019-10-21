package com.self.util;

public class SnowFlakeUtil {
    private final static long SMTP = 1480166465631L;
    private final static long SEQUENCE_BIT = 8L;
    private final static long MACHINE_BIT = 5L;
    private final static long DATACENTER_BIT = 12L;

    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);
    private final static long MAX_MACHINE = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_DATACENTER = -1L ^ (-1L << DATACENTER_BIT);

    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long SMTP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    private long datacenterId;
    private long machineId;
    private long sequenceId = 0L;
    private long lastStmp = -1L;

    public SnowFlakeUtil(long datacenterId, long machineId) {
        if(datacenterId > MAX_DATACENTER || datacenterId < 0L) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if(machineId > MAX_MACHINE || machineId < 0L) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    public synchronized long getNext() {
        long currSmtp = getNewSmtp();
        if (currSmtp < lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if(currSmtp == lastStmp) {
            sequenceId = (sequenceId + 1) & MAX_SEQUENCE;
            if(sequenceId == 0L) {
                currSmtp = getNextMill();
            }

        } else {
            sequenceId = 0L;
        }
        lastStmp = currSmtp;
        return (currSmtp - SMTP) << SMTP_LEFT
                | datacenterId << DATACENTER_LEFT
                | machineId << MACHINE_LEFT
                | sequenceId;
    }

    private long getNewSmtp() {
        return System.currentTimeMillis();
    }

    private long getNextMill() {
        long mill = getNewSmtp();
        while (mill <= lastStmp) {
            mill = getNewSmtp();
        }
        return mill;
    }
}
