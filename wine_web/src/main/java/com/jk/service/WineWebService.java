package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-wine")
public interface WineWebService extends WineServiceApi {
}
