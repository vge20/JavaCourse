package com.Gleb;

import java.util.LinkedList;
import java.util.List;

public class PrinterCacheKeeper {

    public PrinterCacheKeeper() {
        printerCache = new LinkedList<>();
    }

    private List<String> printerCache;

    public void add(String string) {
        printerCache.add(string);
    }

    public List<String> getPrinterCache() {
        return printerCache;
    }
}
