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
	 * ������Ϣ�������ö�Ӧ�Ĵ�����
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
		// �����û���ź��û�����ѯ�û�
		if (clientRequest.getMethod().equals("selectUserByNameOrUserId")) {
			mergeUsageState(clientRequest);
		}
		// �޸ĳ�����Ϣ
		if (clientRequest.getMethod().equals("updatePetinfo")) {
			mergeUsageState(clientRequest);
		}
		// ɾ��������Ϣ
		if (clientRequest.getMethod().equals("delPetInfo")) {
			mergeUsageState(clientRequest);
		}
		//��ȡ���°汾��Ϣ
		if (clientRequest.getMethod().equals("updateVersion")) {
			mergeUsageState(clientRequest);
		}
		// ��ȡ�û���Ϣ
		if (clientRequest.getMethod().equals("getUesr")) {
			mergeUsageState(clientRequest);
		}
		if (clientRequest.getMethod().equals("getFriends")) {
			mergeUsageState(clientRequest);
		}
		if (clientRequest.getMethod().equals("getOneFriend")) {
			mergeUsageState(clientRequest);
		}
		// ��ȡʮ��������
		if (clientRequest.getMethod().equals("cheatUser")) {
			mergeUsageState(clientRequest);
		}
		// ��ȡ��֤��
		if (clientRequest.getMethod().equals("getVerificationCode")) {
			return;
		}
		// ��֤�����
		if (clientRequest.getMethod().equals("verifyCode")) {
			mergeUsageState(clientRequest);
		}
		// �������ѹ�ϵ
		if (clientRequest.getMethod().equals("addFriend")) {
			mergeUsageState(clientRequest);
		}
		// �����Ǻ��Ѻ��ѹ�ϵ
		if (clientRequest.getMethod().equals("delFriend")) {
			mergeUsageState(clientRequest);
		}
		// ������������ϵ
		if (clientRequest.getMethod().equals("insBlackList")) {
			mergeUsageState(clientRequest);
		}
		// �����û�����ѯһ���û���������Ϣ
		if (clientRequest.getMethod().equals("selectUserViewByUserName")) {
			mergeUsageState(clientRequest);
		}
		// ��ѯ�����û���Ϣ�����ݳ������һ��
		if (clientRequest.getMethod().equals("getNearbyUserAndPet")) {
			mergeUsageState(clientRequest);
		}
		// ����ͼƬ��ɾ��һ��ͼƬid
		if (clientRequest.getMethod().equals("delOneImg")) {
			mergeUsageState(clientRequest);
		}
		// ��ҳ��ȡ�û���̬
		if (clientRequest.getMethod().equals("getUserStateView")) {
			mergeUsageState(clientRequest);
		}
		// �û����״̬
		if (clientRequest.getMethod().equals("addUserState")) {
			mergeUsageState(clientRequest);
		}
		// ɾ���û���̬
		if (clientRequest.getMethod().equals("delUserState")) {
			mergeUsageState(clientRequest);
		}
		// �����û���̬
		if (clientRequest.getMethod().equals("addReply")) {
			mergeUsageState(clientRequest);
		}
		// �ظ�����
		if (clientRequest.getMethod().equals("addCommentReply")) {
			mergeUsageState(clientRequest);
		}
		// ɾ������
		if (clientRequest.getMethod().equals("delReply")) {
			mergeUsageState(clientRequest);
		}
		// �޸ĺ��ѱ�ע
		if (clientRequest.getMethod().equals("updatefriendremark")) {
			mergeUsageState(clientRequest);
		}
		// ɾ���ظ�����
		if (clientRequest.getMethod().equals("delCommentReply")) {
			mergeUsageState(clientRequest);
		}
		// �޶�̬
		if (clientRequest.getMethod().equals("addZan")) {
			mergeUsageState(clientRequest);
		}
		// ȡ����
		if (clientRequest.getMethod().equals("delZan")) {
			mergeUsageState(clientRequest);
		}
		// ��ѯ�Լ��Ķ�̬
		if (clientRequest.getMethod().equals("findMyStates")) {
			mergeUsageState(clientRequest);
		}
		// ��ѯ���ѵ����ж�̬
		if (clientRequest.getMethod().equals("findFriendStates")) {
			mergeUsageState(clientRequest);
		}
		// ��ѯ���к��ѵĶ�̬
		if (clientRequest.getMethod().equals("getAllFriendStates")) {
			mergeUsageState(clientRequest);
		}
		// ��ҳ��ȡ����
		if (clientRequest.getMethod().equals("getRepliesByPageIndex")) {
			mergeUsageState(clientRequest);
		}
		// ��ҳ��ȡ�ظ�����
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
		// �������
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
	 * ��ѯ�Ƿ����device
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
//						from("jms:queue:VirtualTopicConsumers.statistic.apprequest?concurrentConsumers=1").to("bean:petStatisticService?method=petStatisticHandle").routeId("�ͻ�������ͳ��");
//					}
//				});
//		} catch (Exception e) {
//			logger.error("camel context start fail",e);
//		}
//	}
}
