/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.microjakartanosql.utils;

/**
 *
 * @author avbravo
 */
public class Ram {

    private long freeMemory;
    private long maxMemory;
    private long totalMemory;
    private long memoryUsedBytes;
    private long memoryUsedMB;

    public Ram() {
    }

    public Ram(long freeMemory, long maxMemory, long totalMemory) {
        this.freeMemory = freeMemory;
        this.maxMemory = maxMemory;
        this.totalMemory = totalMemory;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public long getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(long maxMemory) {
        this.maxMemory = maxMemory;
    }

    public long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public long getMemoryUsedBytes() {
        return memoryUsedBytes;
    }

    public void setMemoryUsedBytes(long memoryUsedBytes) {
        this.memoryUsedBytes = memoryUsedBytes;
    }

    public long getMemoryUsedMB() {
        return memoryUsedMB;
    }

    public void setMemoryUsedMB(long memoryUsedMB) {
        this.memoryUsedMB = memoryUsedMB;
    }

    @Override
    public String toString() {
        return "Ram{" + "freeMemory=" + freeMemory + ", maxMemory=" + maxMemory + ", totalMemory=" + totalMemory + ", memoryUsedBytes=" + memoryUsedBytes + ", memoryUsedMB=" + memoryUsedMB + '}';
    }
    
    
    
    

   

    
    
    
    
    public static class Builder {

        private long freeMemory;
        private long maxMemory;
        private long totalMemory;

        public Builder withOk(long freeMemory) {
            this.freeMemory = freeMemory;
            return this;
        }

        public Builder withFailure(long maxMemory) {
            this.maxMemory = maxMemory;
            return this;
        }

        public Builder withIp(long totalMemory) {
            this.totalMemory = totalMemory;
            return this;
        }

        public Ram build() {
            return new Ram(freeMemory, maxMemory, totalMemory);
        }

    }
}
