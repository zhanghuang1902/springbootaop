package com.example.recovery.util;



import java.util.ArrayList;
import java.util.List;

/**
 *
 * ClassName: 
 *
 * @author
 * @date 2018年4月21日
 */
public class IdWorker {
    // ==============================Fields===========================================
    /** 开始时间截 (2019-01-23) */
    private final long twepoch = 1548209132664L;
    /** 机器id所占的位数 */
    private final long workerIdBits = 4L;

    /** 数据标识id所占的位数 可配置在properties中,启动时加载,此处默认先写成0*/
    private final long datacenterIdBits = 0L;

    /** 支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数) */
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /** 支持的最大数据标识id，结果是31 */
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    /** 序列在id中占的位数 */
    private final long sequenceBits = 5L;

    /** 机器ID向左移12位 */
    private final long workerIdShift = sequenceBits;

    /** 数据标识id向左移17位(12+5)*/
    private final long datacenterIdShift = sequenceBits + workerIdBits;

    /** 时间截向左移22位(5+5+12) */
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    /** 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095) */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /** 工作机器ID(0~31) 可用ip地址最后几个字节标示*/
    private long workerId;

    /** 数据中心ID(0~31) */
    private long datacenterId;

    /** 毫秒内序列(0~4095) */
    private long sequence = 1L;

    /** 上次生成ID的时间截 */
    private long lastTimestamp = -1L;

    private static IdWorker idWorker = new IdWorker(0, 0);
    //==============================Constructors=====================================
    /**
     * 构造函数
     * @param workerId 工作ID (0~1)
     * @param datacenterId 数据中心ID (0~1)
     */
    public IdWorker(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public static String getClerkFileName() {
        long id = idWorker.nextId();

        return  BusinessConst.ZX_PRESCRIPTION_CLERK+id;
    }


    // ==============================Methods==========================================
    /**
     * 获得下一个ID (该方法是线程安全的)
     * @return SnowflakeId
     */
    private synchronized long nextId() {
        long timestamp = timeGen();

        //如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        //如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            //毫秒内序列溢出
            if (sequence == 0) {
                //阻塞到下一个毫秒,获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        //时间戳改变，毫秒内序列重置
        else {
            sequence = 0L;
        }

        //上次生成ID的时间截
        lastTimestamp = timestamp;

        //移位并通过或运算拼到一起组成64位的ID
        return ( ((timestamp - twepoch) << timestampLeftShift)
                | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift)
                | sequence );
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 返回以毫秒为单位的当前时间
     * @return 当前时间(毫秒)
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public static String getId()
    {
        long id = idWorker.nextId();

        return  id+"";
    }

    public static String getDoctorFileName()
    {
        long id = idWorker.nextId();

        return  BusinessConst.ZX_PRESCRIPTION_DOCTOR+id;
    }

    public static String getDoctorGroupFileName()
    {
        long id = idWorker.nextId();

        return  BusinessConst.ZX_PRESCRIPTION_DOCTOR_GROUP+id;
    }

    public static String getAcademyFileName()
    {
        long id = idWorker.nextId();

        return  BusinessConst.ZX_PRESCRIPTION_ACADEMY+id;
    }

    public static String getPharmacistFileName()
    {
        long id = idWorker.nextId();

        return  BusinessConst.ZX_PRESCRIPTION_PHARMACIST+id;
    }

    public static String getApothecaryFileName()
    {
        long id = idWorker.nextId();

        return  BusinessConst.ZX_PRESCRIPTION_APOTHECARY+id;
    }

    public static List<String> getDoctorFileNameList(Integer count)
    {
        if(count <= 0){
            return new ArrayList<>();
        }
        List<String> ids = new ArrayList<>();
        for(int i = 0;i<count;i++){
            ids.add(BusinessConst.ZX_PRESCRIPTION_DOCTOR+idWorker.nextId());
        }

        return ids;
    }

    public static String getAssistantFileName()
    {
        return BusinessConst.ZX_PRESCRIPTION_ASSISTANT+idWorker.nextId();
    }

    public static List<String> getAssistantFileNameList(Integer count)
    {
        if(count <= 0){
            return new ArrayList<>();
        }
        List<String> ids = new ArrayList<>();
        for(int i = 0;i<count;i++){
            ids.add(BusinessConst.ZX_PRESCRIPTION_ASSISTANT+idWorker.nextId());
        }

        return ids;
    }

    public static List<String> getDrugstoreFileNameList(Integer count)
    {
        if(count <= 0){
            return new ArrayList<>();
        }
        List<String> ids = new ArrayList<>();
        for(int i = 0;i<count;i++){
            ids.add(BusinessConst.ZX_PRESCRIPTION_DRUGSTORE+idWorker.nextId());
        }

        return ids;
    }

    public static long getNextId()
    {
        return idWorker.nextId();
    }

    public static String getCustNo()
    {
        long id = idWorker.nextId();
        return "c"+id;
    }
    public static String payOrderNo()
    {
        long id = idWorker.nextId();

        return "p"+TimeUtil.getStringDate("yyyyMMddHHMM") + id;
    }

    public static String getCode(Integer num)
    {
        return TimeUtil.getStringDate("yyyyMMdd") + String.format("%05d",num);
    }

}
