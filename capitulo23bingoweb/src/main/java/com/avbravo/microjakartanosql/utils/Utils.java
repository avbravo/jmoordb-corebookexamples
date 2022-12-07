/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.microjakartanosql.utils;

/**
 *
 * @author avbravo
 */
public class Utils {

    private static final long MEGABYTE = 1024L * 1024L;

    // <editor-fold defaultstate="collapsed" desc="Ram ramMemory()">
    /**
     * Muestra la memoria RAM libre
     *
     * @return
     */
    public static Ram ramMemory() {
        Ram ram = new Ram();
        try {
            Runtime rt = Runtime.getRuntime();
            ram.setFreeMemory(rt.freeMemory());
            ram.setMaxMemory(rt.maxMemory());
            ram.setTotalMemory(rt.totalMemory());
            long memory = ram.getTotalMemory() - ram.getFreeMemory();
            ram.setMemoryUsedBytes(memory);
            ram.setMemoryUsedMB(bytesToMegabytes(memory));
            ram.setFreeMemory(bytesToMegabytes(ram.getFreeMemory()));
            ram.setMaxMemory(bytesToMegabytes(ram.getMaxMemory()));
            ram.setTotalMemory(bytesToMegabytes(ram.getTotalMemory()));

//        System.out.println("Used memory is bytes: " + memory);
//        System.out.println("Used memory is megabytes: "
//                + bytesToMegabytes(memory));
        } catch (Exception e) {
            System.out.println("ramMemory " + e.getLocalizedMessage());
        }

        return ram;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="long bytesToMegabytes(long bytes)">
    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Long integerToLong(Integer i)">
    public static Long integerToLong(Integer i) {
        Long l = Long.valueOf(i.longValue());
        return l;
    } // </editor-fold>
}
