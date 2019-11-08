package org.kilocraft.essentials.config.provided;

import com.electronwill.nightconfig.core.file.FileConfig;

public class ProvidedValueReplaced {
    private FileConfig config;

    public ProvidedValueReplaced(FileConfig fileConfig) {
        this.config = fileConfig;
    }

    public String replaceGlobalObjects(String string) {
        StringBuilder builder = new StringBuilder();
        String[] strings = string.split(" ");

        for (String s : strings) {
            if (s.startsWith("%") && s.endsWith("%")) {
                String path = s.replaceAll("_", ".").replaceAll("%", "").toLowerCase();
                builder.append((String) this.config.get(path)).append(" ");
            } else builder.append(s).append(" ");
        }

        return builder.toString();
    }

}