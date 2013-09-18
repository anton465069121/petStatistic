package com.petstatistic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petstatistic.dao.DeviceDAO;

@Service
public class DeviceService {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DeviceDAO deviceDao;
	
//	@Autowired
//	private CamelContext camelContext;
//	
//	@PostConstruct
//	public void init() {
//		try {
//				logger.info("start app camel routes");
//				camelContext.addRoutes(new RouteBuilder() {
//					@Override
//					public void configure() throws Exception {
//						from("jms:queue:VirtualTopicConsumers.statistic.apprequest?concurrentConsumers=1").to("bean:deviceService?method=persistDevice").routeId("客户端请求统计");
//					}
//				});
//		} catch (Exception e) {
//			logger.error("camel context start fail",e);
//		}
//	}
//
//	/**
//	 * 查询并添加新device
//	 * @param request
//	 * @param ret
//	 * @throws Exception
//	 */
//	public void persistDevice(@Body()String request,@Header("ret")String ret) throws Exception{
//		if(!StringUtils.hasLength(ret)){
//			return;
//		}
//		ClientRequest clientRequest = new ObjectMapper().reader(ClientRequest.class).readValue(request);
//		if(clientRequest.getMethod().equals("open")){
//			Device device=findDevice(clientRequest);
//			if(device==null){
//				device=new Device();
//				device.setImei(clientRequest.getImei());
//				device.persist();
//			}
//		}
//	}
//
//	/**
//	 * 查询是否存在device
//	 * @param clientRequest
//	 * @return
//	 */
//	private Device findDevice(ClientRequest clientRequest) {
//		if(StringUtils.hasLength(clientRequest.getImei())){
//			 List<Device> resultList = Device.findDevicesByImei(clientRequest.getImei()).getResultList();
//			 if(resultList.size()>1){
//				 logger.warn("duplicated imei found. {}",clientRequest.getImei());
//			 }
//			 if(resultList.size()>0){
//				 return resultList.get(0);
//			 }
//		}
//		 if(StringUtils.hasLength(clientRequest.getMac())){
//			 List<Device> macresultList = Device.findDevicesByMac(clientRequest.getMac()).getResultList();
//			 if(macresultList.size()>1){
//				 logger.warn("duplicated mac found. {}",clientRequest.getMac());
//			 }
//			 if(macresultList.size()>0){
//				 return macresultList.get(0);
//			 }
//		 }
//		 return null;
//	}

}
