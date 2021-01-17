package com.record.hodgepodge.util;

import java.util.UUID;

public class KeyUtil {

    /**
     * 生成32位uuid
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
