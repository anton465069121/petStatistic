package com.petstatistic.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.petstatistic.common.ClientRequest;
import com.petstatistic.common.PetStatisticUtil;
import com.petstatistic.controller.LoginResponse;
import com.petstatistic.domain.AuthenticationToken;
import com.petstatistic.domain.Device;
import com.petstatistic.domain.PetUser;
import com.petstatistic.domain.UsageState;

@Service
public class PetStatisticService implements MessageListener{
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void onMessage(Message message) {
        try {
        	TextMessage msg = (TextMessage) message;
        	petStatisticHandle(msg.getStringProperty("body"),msg.getStringProperty("ret"));
           }catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 根据消息参数调用对应的处理方法
	 * @param request
	 * @param ret
	 * @throws Exception
	 */
	public void petStatisticHandle(String request,String ret) throws Exception{
		if(!StringUtils.hasLength(ret)){
			return;
		}
		ClientRequest clientRequest = new ObjectMapper().reader(ClientRequest.class).readValue(request);
		if(clientRequest.getMethod().equals("open")){
			Device device=findDevice(clientRequest);
			if(device==null){
				device=new Device();
				device.setImei(clientRequest.getImei());
				device.persist();
			}
		}
		if (clientRequest.getMethod().equals("register")) {
			persistRegisters(ret);
		}
		if (clientRequest.getMethod().equals("isUsernameInuse")) {
			mergeUsageState(clientRequest);
		}
		if (clientRequest.getMethod().equals("getChatServer")) {
			mergeUsageState(clientRequest);
		}
		if (clientRequest.getMethod().equals("login")) {
			login(clientRequest,ret);
		}
		
		if (clientRequest.getMethod().equals("getNearbyUser")) {
			mergeUsageState(clientRequest);
		}
		if (clientRequest.getMethod().equals("setUserLocation")) {
			mergeUsageState(clientRequest);
		}
		if (clientRequest.getMethod().equals("saveUserinfo")) {
			mergeUsageState(clientRequest);
		}
		if (clientRequest.getMethod().equals("getUserinfo")) {
			mergeUsageState(clientRequest);
		}
		if (clientRequest.getMethod().equals("savePetinfo")) {
			mergeUsageState(clientRequest);
		}
		// 根据用户编号和用户名查询用户
		if (clientRequest.getMethod().equals("selectUserByNameOrUserId")) {
			mergeUsageState(clientRequest);
		}
		// 修改宠物信息
		if (clientRequest.getMethod().equals("updatePetinfo")) {
			mergeUsageState(clientRequest);
		}
		// 删除宠物信息
		if (clientRequest.getMethod().equals("delPetInfo")) {
			mergeUsageState(clientRequest);
		}
		//获取最新版本信息
		if (clientRequest.getMethod().equals("updateVersion")) {
			mergeUsageState(clientRequest);
		}
		// 获取用户信息
		if (clientRequest.getMethod().equals("getUesr")) {
			mergeUsageState(clientRequest);
		}
		if (clientRequest.getMethod().equals("getFriends")) {
			mergeUsageState(clientRequest);
		}
		if (clientRequest.getMethod().equals("getOneFriend")) {
			mergeUsageState(clientRequest);
		}
		// 获取十条假数据
		if (clientRequest.getMethod().equals("cheatUser")) {
			mergeUsageState(clientRequest);
		}
		// 获取验证码
		if (clientRequest.getMethod().equals("getVerificationCode")) {
			return;
		}
		// 验证随机码
		if (clientRequest.getMethod().equals("verifyCode")) {
			mergeUsageState(clientRequest);
		}
		// 建立好友关系
		if (clientRequest.getMethod().equals("addFriend")) {
			mergeUsageState(clientRequest);
		}
		// 建立非好友好友关系
		if (clientRequest.getMethod().equals("delFriend")) {
			mergeUsageState(clientRequest);
		}
		// 建立黑名单关系
		if (clientRequest.getMethod().equals("insBlackList")) {
			mergeUsageState(clientRequest);
		}
		// 根据用户名查询一个用户的所有信息
		if (clientRequest.getMethod().equals("selectUserViewByUserName")) {
			mergeUsageState(clientRequest);
		}
		// 查询附近用户信息，根据宠物过滤一次
		if (clientRequest.getMethod().equals("getNearbyUserAndPet")) {
			mergeUsageState(clientRequest);
		}
		// 根据图片号删除一张图片id
		if (clientRequest.getMethod().equals("delOneImg")) {
			mergeUsageState(clientRequest);
		}
		// 分页获取用户动态
		if (clientRequest.getMethod().equals("getUserStateView")) {
			mergeUsageState(clientRequest);
		}
		// 用户添加状态
		if (clientRequest.getMethod().equals("addUserState")) {
			mergeUsageState(clientRequest);
		}
		// 删除用户动态
		if (clientRequest.getMethod().equals("delUserState")) {
			mergeUsageState(clientRequest);
		}
		// 评论用户动态
		if (clientRequest.getMethod().equals("addReply")) {
			mergeUsageState(clientRequest);
		}
		// 回复评论
		if (clientRequest.getMethod().equals("addCommentReply")) {
			mergeUsageState(clientRequest);
		}
		// 删除评论
		if (clientRequest.getMethod().equals("delReply")) {
			mergeUsageState(clientRequest);
		}
		// 修改好友备注
		if (clientRequest.getMethod().equals("updatefriendremark")) {
			mergeUsageState(clientRequest);
		}
		// 删除回复评论
		if (clientRequest.getMethod().equals("delCommentReply")) {
			mergeUsageState(clientRequest);
		}
		// 赞动态
		if (clientRequest.getMethod().equals("addZan")) {
			mergeUsageState(clientRequest);
		}
		// 取消赞
		if (clientRequest.getMethod().equals("delZan")) {
			mergeUsageState(clientRequest);
		}
		// 查询自己的动态
		if (clientRequest.getMethod().equals("findMyStates")) {
			mergeUsageState(clientRequest);
		}
		// 查询好友的所有动态
		if (clientRequest.getMethod().equals("findFriendStates")) {
			mergeUsageState(clientRequest);
		}
		// 查询所有好友的动态
		if (clientRequest.getMethod().equals("getAllFriendStates")) {
			mergeUsageState(clientRequest);
		}
		// 分页获取评论
		if (clientRequest.getMethod().equals("getRepliesByPageIndex")) {
			mergeUsageState(clientRequest);
		}
		// 分页获取回复评论
		if (clientRequest.getMethod().equals("getCommentsByPageIndex")) {
			mergeUsageState(clientRequest);
		}
		if (clientRequest.getMethod().equals("saveUserinfo2")) {//v2
			mergeUsageState(clientRequest);
		}
		if(clientRequest.getMethod().equals("resetPassword")){
			return;
		}
		if (clientRequest.getMethod().equals("register2")) {//v2
			persistRegisters(ret);
		}
		if (clientRequest.getMethod().equals("login2")) {
			login(clientRequest,ret);
		}
		// 意见反馈
		if (clientRequest.getMethod().equals("feedback")) {
			mergeUsageState(clientRequest);
		}
	}

	private void login(ClientRequest clientRequest,String ret) throws JsonParseException, JsonMappingException, IOException {
		LoginResponse loginResponse = new ObjectMapper().readValue(ret, LoginResponse.class);
		if(null == loginResponse){
			logger.warn("duplicated loginResponse found. {}",loginResponse);
		}
		AuthenticationToken authenticationToken = loginResponse.getAuthenticationToken();
		if(null == authenticationToken){
			logger.warn("duplicated authenticationToken found. {}",authenticationToken);
		}
		authenticationToken.persist();
	}

	private void persistRegisters(String ret) throws JsonProcessingException, IOException {
		AuthenticationToken authenticationToken = new ObjectMapper().reader(AuthenticationToken.class).readValue(ret);
		if(null == authenticationToken){
			logger.warn("duplicated authenticationToken found. {}",authenticationToken);
		}
		authenticationToken.persist();
		PetUser petUser = new PetUser();
		petUser.setId(authenticationToken.getUserid());
		petUser.setCreateTime(new Date(System.currentTimeMillis()));
		petUser.persist();
	}

	/**
	 * 查询是否存在device
	 * @param clientRequest
	 * @return
	 */
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
	
	public void mergeUsageState(ClientRequest clientRequest) {
		AuthenticationToken authenticationToken = AuthenticationToken.findAuthenticationToken(PetStatisticUtil.getParameter(clientRequest, "token"));
		if(null==authenticationToken){
			return;
		}
		List<UsageState> resultList = UsageState.findUsageStatesByUserId(authenticationToken.getUserid()).getResultList();
		if (resultList.size() <= 0) {
			UsageState uS = new UsageState();
			uS.setUserId(authenticationToken.getUserid());
			uS.setLastConnectTime(new Date(System.currentTimeMillis()));
			uS.persist();
		} else {
			for (UsageState uS : resultList) {
				uS.setUserId(authenticationToken.getUserid());
				uS.setLastConnectTime(new Date(System.currentTimeMillis()));
				uS.merge();
			}
		}
	}

	
//	@Autowired
//	private CamelContext camelContext;
	
//	@PostConstruct
//	public void init() {
//		try {
//				logger.info("start app camel routes");
//				camelContext.addRoutes(new RouteBuilder() {
//					@Override
//					public void configure() throws Exception {
//						from("jms:queue:VirtualTopicConsumers.statistic.apprequest?concurrentConsumers=1").to("bean:petStatisticService?method=petStatisticHandle").routeId("客户端请求统计");
//					}
//				});
//		} catch (Exception e) {
//			logger.error("camel context start fail",e);
//		}
//	}
}
