package com.codingapi.example.demo;

import com.codingapi.txlcn.client.config.EnableDistributedTransaction;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * Date: 19-1-13 下午2:46
 *
 * @author ujued
 */
@Configuration
@EnableDiscoveryClient
@EnableDistributedTransaction
public class TransactionConfiguration {
    public TransactionConfiguration() {
    }
}
