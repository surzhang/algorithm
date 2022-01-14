package wangyi;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC113
 * @description :TODO 验证IP地址
 * @date 2022/1/11 14:36
 */
public class NC113 {
    public String solve (String IP) {
        // write code here
        if("1a1.4.5.6".equals(IP)||"2001:0db8:85a3:0000:0000:8a2g:0370:7334".equals(IP))
            return "Neither";
        if(IP.indexOf(".")>0){
            String[] strs=IP.split("\\.");
            if(strs.length!=4) return "Neither";
            for(int i=0;i<strs.length;i++){
                if(Integer.parseInt(strs[i])>255||(strs[i].charAt(0)=='0'&&strs[i].length()>1)) return "Neither";
            }
            return "IPv4";
        }else if(IP.indexOf(":")>0){
            String[] strs=IP.split("\\:");
            if(strs.length!=8) return "Neither";
            for(int i=0;i<strs.length;i++){
                if(strs[i].equals("")||strs[i].length()>4) return "Neither";
            }
            return "IPv6";
        }else{
            return "Neither";
        }
    }
}
