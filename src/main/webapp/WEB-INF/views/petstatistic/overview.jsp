<%@ page contentType="text/html" pageEncoding="GBK" %>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.petstatistic.vo.OverView" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'OverView.jsp' starting page</title>
  </head>
  <body>
	  <from>
		 <table width="200" border="1" id="myData">
		  <tr>
			<td>渠道名称</td>
			<td>今日新增用户</td>
			<td>今日注册用户</td>
			<td>今日联网用户</td>
			<td>七天联网用户</td>
			<td>30天联网用户</td>
			<td>总用户数量</td>
			<td>总注册用户数量</td>
			<td>注册率</td>
		  </tr>
		  <% 
		  	List<OverView> overviews = (List<OverView>)request.getSession().getAttribute("overviews");
    		if(overviews!=null && overviews.size()>0){
    		for(OverView overview:overviews){
    	  %>
    	  <tr>
			  <td>
				<%=overview.getChannel()%>
			  </td>
			  <td>
				<%=overview.getNewUsers()==null?0:overview.getNewUsers()%>
			  </td>
			  <td>
				<%=overview.getNewRegistors()==null?0:overview.getNewRegistors()%>
			  </td>
			  <td>
				<%=overview.getDailyLiving()==null?0:overview.getDailyLiving()%>
			  </td>
			  <td>
				<%=overview.getWeeklyLiving()==null?0:overview.getWeeklyLiving()%>
			  </td>
			  <td>
				<%=overview.getMounthlyLiving()==null?0:overview.getMounthlyLiving()%>
			  </td>
			  <td>
				<%=overview.getAllUsers()==null?0:overview.getAllUsers()%>
			  </td>
			  <td>
				<%=overview.getAllRegistors()==null?0:overview.getAllRegistors()%>
			  </td>
			  <td>
				<%=overview.getRegistrationRate()==null?0.00:overview.getRegistrationRate()%>
			  </td>
		  </tr>
		  <% }} %>
		</table>
	  </from>
  </body>
</html>
