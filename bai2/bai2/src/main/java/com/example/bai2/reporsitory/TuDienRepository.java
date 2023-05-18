package com.example.bai2.reporsitory;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class TuDienRepository implements  ITuDienReprository {
    private static Map<String,String> stringMap=new HashMap<>();
    static {
        stringMap.put("Hello","Xin chào");
        stringMap.put("hello","xin chào");
        stringMap.put("Thanks","Cảm ơn");
        stringMap.put("thanks","cảm ơn");
        stringMap.put("Sorry","Xin lỗi");
        stringMap.put("sorry","xin lỗi");
        stringMap.put("Goodbye","Tạm biệt");
        stringMap.put("goodbye","tạm biệt");
        stringMap.put("I love you","Tôi yêu bạn");
        stringMap.put("i love you","tôi yêu bạn");

    }
    @Override
    public Map<String, String> tuDien() {
        return stringMap;
    }

}
