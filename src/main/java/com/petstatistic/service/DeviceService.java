package com.petstatistic.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.camel.Body;
import org.apache.camel.CamelContext;
import org.apache.camel.Header;
import org.apache.camel.builder.RouteBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.petstatistic.dao.DeviceDAO;
import com.petstatistic.domain.Device;

@Service
public class DeviceService {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DeviceDAO deviceDao;
	
	@Autowired
	private CamelContext camelContext;
	
	@PostConstruct
	public void init() {
		try {
				logger.info("start app camel routes");
				camelContext.addRoutes(new RouteBuilder() {
					@Override
					public void configure() throws Exception {
						from("jms:queue:VirtualTopicConsumers.statistic.apprequest?concurrentConsumers=1").to("bean:deviceService?method=handlerOpen").routeId("客户端请求统计");
					}
				});
			

			
		} catch (Exception e) {
			logger.error("camel context start fail",e);
		}
		
	}

	
	public List<Device> getDevices() {
		return deviceDao.getDevices();
	}
	
	public void handlerOpen(@Body()String request,@Header("ret")String ret) throws Exception{
		if(!StringUtils.hasLength(ret)){
			return;
		}
		ClientRequest clientRequest = new ObjectMapper().reader(
				ClientRequest.class).readValue(request);
		if(clientRequest.getMethod().equals("open")){
			Device device=findDevice(clientRequest);
			if(device==null){
				device=new Device();
				device.setImei(clientRequest.getImei());
				device.persist();
			}
		}
	}


	private Device findDevice(ClientRequest clientRequest) {
		if(StringUtils.hasLength(clientRequest.getImei())){
			 List<Device> resultList = Device.findDevicesByImei(clientRequest.getImei()).getResultList();
			 if(resultList.size()>1){
				 logger.warn("duplicated imei found. {}",clientRequest.getImei());
			 }
			 if(resultList.size()>0){
				 return resultList.get(0);
			 }
		}
		 if(StringUtils.hasLength(clientRequest.getMac())){
			 List<Device> macresultList = Device.findDevicesByMac(clientRequest.getMac()).getResultList();
			 if(macresultList.size()>1){
				 logger.warn("duplicated mac found. {}",clientRequest.getMac());
			 }
			 if(macresultList.size()>0){
				 return macresultList.get(0);
			 }
		 }
		 return null;
	}

}
