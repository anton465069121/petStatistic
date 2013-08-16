package com.petstatistic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petstatistic.dao.OverViewDAO;
import com.petstatistic.vo.OverView;

@Service
public class OverViewService {
	@Autowired
	OverViewDAO overViewDao;

	public List<OverView> getViews() {
		return overViewDao.getViews();
	}
}
