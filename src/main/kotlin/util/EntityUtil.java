package util;

public class EntityUtil {


    public static boolean toBooleanMarried(String mar){


        if("y".equals(mar)){
            return true;
        }
        if("n".equals(mar)){
            return false;
        }

        return false;

    }
    public static String toStringMarried(boolean mar){


        if(mar){
            return "y";
        }else{
            return "n";
        }

    }
}
