package com.petstatistic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.petstatistic.vo.OverView;

@Component
public class OverViewDAO {
	@PersistenceContext
	transient EntityManager entityManager;
	
	public List<OverView> getViews() {
		try {
//			StringBuffer sql = new StringBuffer();
//			sql.append(" select t11.channel,t11.newUsers,t12.newRegistors,t11.dailyLiving,t11.weeklyLiving,t11.mounthlyLiving,t11.allUsers,t11.allRegistors,concat(t11.allRegistors/t11.allUsers*100,'%') registrationRate from ");
//			sql.append(" (select t9.*,t10.mounthlyLiving from                                                                                                                                                                   ");
//			sql.append(" (select t7.*,t8.weeklyLiving from                                                                                                                                                                      ");
//			sql.append(" (select t5.*,t6.dailyLiving from                                                                                                                                                                       ");
//			sql.append(" (select t3.*,t4.allRegistors from                                                                                                                                                                      ");
//			sql.append(" (select t1.channel,t1.allUsers,t2.newUsers from                                                                                                                                                        ");
//			sql.append(" (select de.channel channel,count(de.id) allUsers from device de group by de.channel)t1                                                                                                                 ");
//			sql.append(" left join                                                                                                                                                                                              ");
//			sql.append(" (select de.channel channel,count(de.id) newUsers from device de where de.create_time = curdate() group by de.channel)t2                                                                                ");
//			sql.append(" on t1.channel = t2.channel) t3                                                                                                                                                                         ");
//			sql.append(" left join                                                                                                                                                                                              ");
//			sql.append(" (select de.channel,count(pu.id) allRegistors from device de,pet_user pu where pu.id = de.userid group by de.channel) t4                                                                                ");
//			sql.append(" on t3.channel = t4.channel) t5                                                                                                                                                                         ");
//			sql.append(" left join                                                                                                                                                                                              ");
//			sql.append(" (select de.channel,count(us.id) dailyLiving from device de,usage_state us where us.user_id = de.userid group by de.channel) t6                                                                         ");
//			sql.append(" on t5.channel = t6.channel)t7                                                                                                                                                                          ");
//			sql.append(" left join                                                                                                                                                                                              ");
//			sql.append(" (select de.channel,count(hl.id) weeklyLiving from device de, history_log hl where hl.user_id = de.userid and date_format(hl.history_date,'%Y%u') = date_format(curdate(),'%Y%u'))t8                    ");
//			sql.append(" on t7.channel = t8.channel) t9                                                                                                                                                                         ");
//			sql.append(" left join                                                                                                                                                                                              ");
//			sql.append(" (select de.channel,count(hl.id) mounthlyLiving from device de, history_log hl where hl.user_id = de.userid and date_format(hl.history_date,'%Y%m') = date_format(curdate(),'%Y%m')) t10                ");
//			sql.append(" on t9.channel = t10.channel) t11                                                                                                                                                                       ");
//			sql.append(" left join                                                                                                                                                                                              ");
//			sql.append(" (select de.channel,count(pu.id) newRegistors from device de,pet_user pu where pu.id = de.userid and pu.create_time = curdate() group by de.channel) t12                                                ");
//			sql.append(" on t11.channel = t12.channel;                                                                                                                                                                          ");
//			Query createQuery =  entityManager.createNativeQuery(sql.toString(),OverView.class);
			TypedQuery<OverView> createQuery =  entityManager.createQuery(" select o from OverView o ",OverView.class);
			return (List<OverView>)createQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
