package com.espark.adarsh;

import com.pi4j.system.NetworkInfo;
import com.pi4j.system.SystemInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@Slf4j
@SpringBootApplication
public class ApplicationMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(ApplicationMain.class, args);
        printSystemInformation();
    }

    public static void printSystemInformation() throws IOException, InterruptedException {
        // display a few of the available system information properties
        log.info("----------------------------------------------------");
        log.info("HARDWARE INFO");
        log.info("----------------------------------------------------");
        log.info("Serial Number     :  " + SystemInfo.getSerial());
        log.info("CPU Revision      :  " + SystemInfo.getCpuRevision());
        log.info("CPU Architecture  :  " + SystemInfo.getCpuArchitecture());
        log.info("CPU Part          :  " + SystemInfo.getCpuPart());
        log.info("CPU Temperature   :  " + SystemInfo.getCpuTemperature());
        log.info("CPU Core Voltage  :  " + SystemInfo.getCpuVoltage());
//        log.info("CPU Model Name    :  " + SystemInfo.getModelName());
//        log.info("Processor         :  " + SystemInfo.getProcessor());
        log.info("Hardware Revision :  " + SystemInfo.getRevision());
        log.info("Is Hard Float ABI :  " + SystemInfo.isHardFloatAbi());
        log.info("Board Type        :  " + SystemInfo.getBoardType().name());

        log.info("----------------------------------------------------");
        log.info("MEMORY INFO");
        log.info("----------------------------------------------------");
        log.info("Total Memory      :  " + SystemInfo.getMemoryTotal());
        log.info("Used Memory       :  " + SystemInfo.getMemoryUsed());
        log.info("Free Memory       :  " + SystemInfo.getMemoryFree());
        log.info("Shared Memory     :  " + SystemInfo.getMemoryShared());
        log.info("Memory Buffers    :  " + SystemInfo.getMemoryBuffers());
        log.info("Cached Memory     :  " + SystemInfo.getMemoryCached());
        log.info("SDRAM_C Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_C());
        log.info("SDRAM_I Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_I());
        log.info("SDRAM_P Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_P());

        log.info("----------------------------------------------------");
        log.info("OPERATING SYSTEM INFO");
        log.info("----------------------------------------------------");
        log.info("OS Name           :  " + SystemInfo.getOsName());
        log.info("OS Version        :  " + SystemInfo.getOsVersion());
        log.info("OS Architecture   :  " + SystemInfo.getOsArch());
        log.info("OS Firmware Build :  " + SystemInfo.getOsFirmwareBuild());

        log.info("----------------------------------------------------");
        log.info("JAVA ENVIRONMENT INFO");
        log.info("----------------------------------------------------");
        log.info("Java Vendor       :  " + SystemInfo.getJavaVendor());
        log.info("Java Vendor URL   :  " + SystemInfo.getJavaVendorUrl());
        log.info("Java Version      :  " + SystemInfo.getJavaVersion());
        log.info("Java VM           :  " + SystemInfo.getJavaVirtualMachine());
        log.info("Java Runtime      :  " + SystemInfo.getJavaRuntime());

        log.info("----------------------------------------------------");
        log.info("NETWORK INFO");
        log.info("----------------------------------------------------");

        // display some of the network information
        log.info("Hostname          :  " + NetworkInfo.getHostname());
        for (String ipAddress : NetworkInfo.getIPAddresses()) {
            log.info("IP Addresses      :  " + ipAddress);
        }
        for (String fqdn : NetworkInfo.getFQDNs()) {
            log.info("FQDN              :  " + fqdn);
        }
        for (String nameserver : NetworkInfo.getNameservers()) {
            log.info("Nameserver        :  " + nameserver);
        }

        log.info("----------------------------------------------------");
        log.info("CODEC INFO");
        log.info("----------------------------------------------------");
        log.info("H264 Codec Enabled:  " + SystemInfo.getCodecH264Enabled());
        log.info("MPG2 Codec Enabled:  " + SystemInfo.getCodecMPG2Enabled());
        log.info("WVC1 Codec Enabled:  " + SystemInfo.getCodecWVC1Enabled());

        log.info("----------------------------------------------------");
        log.info("CLOCK INFO");
        log.info("----------------------------------------------------");
        log.info("ARM Frequency     :  " + SystemInfo.getClockFrequencyArm());
        log.info("CORE Frequency    :  " + SystemInfo.getClockFrequencyCore());
        log.info("H264 Frequency    :  " + SystemInfo.getClockFrequencyH264());
        log.info("ISP Frequency     :  " + SystemInfo.getClockFrequencyISP());
        log.info("V3D Frequency     :  " + SystemInfo.getClockFrequencyV3D());
        log.info("UART Frequency    :  " + SystemInfo.getClockFrequencyUART());
        log.info("PWM Frequency     :  " + SystemInfo.getClockFrequencyPWM());
        log.info("EMMC Frequency    :  " + SystemInfo.getClockFrequencyEMMC());
        log.info("Pixel Frequency   :  " + SystemInfo.getClockFrequencyPixel());
        log.info("VEC Frequency     :  " + SystemInfo.getClockFrequencyVEC());
        log.info("HDMI Frequency    :  " + SystemInfo.getClockFrequencyHDMI());
        log.info("DPI Frequency     :  " + SystemInfo.getClockFrequencyDPI());
    }
}
