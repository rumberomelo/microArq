package com.rumberomelo.alarm;

import org.springframework.stereotype.Component;

import com.rumberomelo.arq.accessdata.DataManagerBean;


@Component
public class AlarmDataManager extends DataManagerBean<IAlarm, IAlarmCache, IAlarmNoCache>{}
