package org.sckj.grid_list.cache;

import java.util.HashMap;
import java.util.Map;

public class RunNeedProperHolder {
    private static final Map<String, Object> objectHashMap = new HashMap<>();

    private static final class RunNeedProperHolderInstance {
        private static final RunNeedProperHolder runNeedProperHolder = new RunNeedProperHolder();
    }

    public static RunNeedProperHolder getInstance() {
        return RunNeedProperHolder.RunNeedProperHolderInstance.runNeedProperHolder;
    }

    public void setSource(String key, Object o) {
        objectHashMap.put(key, o);
    }

    public Object getSource(String key) {
        return objectHashMap.get(key);
    }

}
