package com.anhvurz90.practice.misc;

public class JavaBitwiseExample {

  public static void main(String[] args) {
    JavaBitwiseExample obj = new JavaBitwiseExample();
    System.out.format("ipToLong: %d\n", obj.ipToLong("192.168.1.2"));
    System.out.format("ipToLong2: %d\n", obj.ipToLong2("192.168.1.2"));
    
    System.out.format("longToIp: %s\n", obj.longToIp(3232235778L));
    System.out.format("longToIp2 %s\n", obj.longToIp2(3232235778L));
  }
  
  // example: 192.168.1.2
  public long ipToLong(String ipAddress) {
    // ipAddressInArray[0] = 192;
    String[] ipAddressInArray = ipAddress.split("\\.");
    
    long ret = 0;
    for (int i = 0; i < ipAddressInArray.length; i++) {
      ret += Integer.parseInt(ipAddressInArray[i]) * Math.pow(256, 3 - i);
      // 1. 192*256^3
      // 2. 168*256^2
      // 3. 1*256^1
      // 4. 2*256^0
    }
    return ret;
  }
  
  public long ipToLong2(String ipAddress) {
    long result = 0;
    String[] ipArr = ipAddress.split("\\.");
    
    for (int i = 0; i < ipArr.length; i++) {
      long ip = Integer.parseInt(ipArr[i]);
      result |= ip << ( 8 * (3-i) );
      // 1. 192 << 24
      // 2. 168 << 16
      // 3. 1 << 8
      // 4. 2 << 0
    }
    
    return result;
  }
  
  public String longToIp(long i) {
    return ((i >> 24) & 0xFF) + "." +
           ((i >> 16) & 0xFF) + '.' +
           ((i >> 8) & 0xFF) + '.' +
           (i & 0xFF);
  }
  
  public String longToIp2(long ip) {
    StringBuilder sb = new StringBuilder(15);
    for (int i = 0; i < 4; i++) {
      // 1. 2
      // 2. 1
      // 3. 168
      // 4. 192
      sb.insert(0, Long.toString(ip & 0xFF));
      if (i < 3) sb.insert(0, '.');
      
      ip = ip >> 8;
      // 1. 192.168.1.2
      // 2. 192.168.1
      // 3. 192.168
      // 4. 192
    }
    return sb.toString();
  }
}
