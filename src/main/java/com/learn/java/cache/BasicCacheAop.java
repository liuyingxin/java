package com.learn.java.cache;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BasicCacheAop {
    private static Splitter splitter = Splitter.on('.');
    public static final Map<String, Field> FIELD_MAP = new ConcurrentHashMap();
    public static final String EMPTY_CACHE_VALUE_FLAG = "###+--**-+###";

    public static final int SIMPLE_CACHE_KEY_MAX_LEN = 100;

    public BasicCacheAop() {
    }

    protected String justJoinToGetCacheKey(String className, String methodName, Map<String, Object> argName2Value, String... specificKeys) {
        try {
            className = StringUtils.isEmpty(className) ? "method-cache-" : className + ":" + methodName + ":";
            List<String> results = new ArrayList(specificKeys.length);
            String[] var6 = specificKeys;
            int var7 = specificKeys.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                String specificKey = var6[var8];
                Object realValue = getRealValueByMethodArgs(argName2Value, specificKey);
                if (realValue == null) {
                    results.add("");
                } else {
                    results.add(realValue.toString());
                }
            }

            return className + StringUtils.join(results, "");
        } catch (Exception var11) {
            throw new RuntimeException(var11);
        }
    }

    protected Object getRealValueByMethodArgs(Map<String, Object> argName2Value, String specificKey) {
        try {
            if (specificKey.startsWith("{") && specificKey.endsWith("}")) {
                specificKey = specificKey.substring(1, specificKey.length() - 1);
                List<String> fields = splitter.splitToList(specificKey);
                if (!argName2Value.containsKey(fields.get(0))) {
                    return null;
                } else {
                    Object argObject = argName2Value.get(fields.get(0));
                    Iterator<String> iterator = fields.iterator();
                    iterator.next();

                    while(iterator.hasNext() && argObject != null) {
                        String fieldName = iterator.next();
                        Field field = this.getField(argObject.getClass(), fieldName);
                        argObject = field.get(argObject);
                    }

                    return argObject;
                }
            } else {
                return specificKey;
            }
        } catch (Exception var8) {
            throw new RuntimeException(var8);
        }
    }

    protected Field getField(Class<?> aClass, String fieldName) throws NoSuchFieldException {
        String fieldKey = aClass.toString() + fieldName;
        Field field = FIELD_MAP.get(fieldKey);
        if (field != null) {
            return field;
        } else {
            field = aClass.getField(fieldName);
            if (field == null) {
                return null;
            } else {
                field.setAccessible(true);
                FIELD_MAP.put(fieldKey, field);
                return field;
            }
        }
    }

    protected Map<String, Object> getArgName2Value(JoinPoint pjp){
        String[] argNames = this.getArgNames(pjp);
        Object[] argValues = pjp.getArgs();
        Map<String, Object> argName2Value = new HashMap(argNames.length);

        for(int i = 0; i < argNames.length; ++i) {
            argName2Value.put(argNames[i], argValues[i]);
        }

        return argName2Value;
    }

    protected String[] getArgNames(JoinPoint pjp) {
        MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
        return methodSignature.getParameterNames();
    }

    protected String getMethodName(JoinPoint pjp) {
        Method method = this.getMethod(pjp);
        return null == method ? "" : method.getName();
    }

    protected Method getMethod(JoinPoint pjp) {
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        return signature.getMethod();
    }

    protected Type getReturnType(ProceedingJoinPoint pjp) {
        Method method = this.getMethod(pjp);
        return method.getGenericReturnType();
    }

    protected String getTargetClassFullName(JoinPoint pjp) {
        return pjp.getTarget().getClass().getName();
    }

    protected String getTargetClassName(JoinPoint pjp) {
        String targetClassFullName = this.getTargetClassFullName(pjp);
        if (StringUtils.isNotEmpty(targetClassFullName)) {
            int lastIndexOf = targetClassFullName.lastIndexOf(".");
            return lastIndexOf < 0 ? targetClassFullName : targetClassFullName.substring(lastIndexOf + 1);
        } else {
            return "";
        }
    }

    @SuppressWarnings("unchecked")
    protected List<String> getRealSpecificKeys(Map<String, Object> argName2Value, String[] specificKeys) {
        List<String> result = new ArrayList<>();
        List<Object> tempRealSpecificKeys = new ArrayList<>(specificKeys.length);
        for (String specificKey : specificKeys) {
            tempRealSpecificKeys.add(getRealValueByMethodArgs(argName2Value, specificKey));
        }

        for (Object temp : tempRealSpecificKeys) {
            if (temp instanceof Collection || temp.getClass().isArray()) {
                Collection tempCollection;
                if (temp instanceof Collection) {
                    tempCollection = (Collection) temp;
                } else {
                    tempCollection = new ArrayList();
                    for (int i = 0; i < Array.getLength(temp); i++) {
                        tempCollection.add(Array.get(temp, i));
                    }
                }
                Iterator iterator = (tempCollection).iterator();
                List<String> subList = new ArrayList<>();
                while (iterator.hasNext()) {
                    Object singleTemp = iterator.next();
                    if (singleTemp == null) {
                        iterator.remove();
                    } else {
                        subList.add(singleTemp.toString());
                    }
                }
                result.addAll(subList);
            } else {
                result.add(temp.toString());
            }
        }
        return result;
    }

    protected String justJoinToGetCacheKey(Map<String, Object> argName2Value, String... specificKeys) {
        try {
            List<String> results = new ArrayList<>(specificKeys.length);
            for (String specificKey : specificKeys) {
                Object realValue = getRealValueByMethodArgs(argName2Value, specificKey);
                if (realValue == null) {
                    results.add("");
                } else {
                    results.add(realValue.toString());
                }
            }
            return StringUtils.join(results, "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
