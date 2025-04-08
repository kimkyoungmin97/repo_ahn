package com.a5a5lab.module.oder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OderService {
	
	@Autowired
	OderDao oderDao;
}
